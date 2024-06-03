package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.enums.UpdateType;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository implements Oberservable{


    private List<Observer> observers;
    private static WatchlistRepository instance;
    private Dao<WatchlistMovieEntity, Long> dao;
    private WatchlistMovieEntity lastModifiedMovie;

    private boolean wasAddedToWatchlist;

    private WatchlistRepository() throws DataBaseException {
        try {
            this.dao = DatabaseManager.getInstance().getWatchlistDao();
            this.observers = new ArrayList<>(); // Initialize the observers list

        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public static WatchlistRepository getInstance() throws DataBaseException {
        if (instance == null) {
            instance = new WatchlistRepository();
        }
        return instance;
    }

    public List<WatchlistMovieEntity> getWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }

    public WatchlistMovieEntity getLastModifiedMovie() {
        return lastModifiedMovie;
    }
    public int addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        System.out.println("Adding to watchlist");
        try {
            // only add movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                int result = dao.create(movie);
                lastModifiedMovie = movie; // Set the last modified movie
                wasAddedToWatchlist = true; // Set wasAddedToWatchlist to true
                return result;
            } else {
                wasAddedToWatchlist = false; // Set wasAddedToWatchlist to false
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        } finally {
            notifyObservers(UpdateType.ADDED); // Notify observers after the movie has been added
        }
    }

    public int removeFromWatchlist(String apiId) throws DataBaseException {
        try {
            int result = dao.delete(dao.queryBuilder().where().eq("apiId", apiId).query());
            if (result > 0) {
                lastModifiedMovie = new WatchlistMovieEntity(apiId); // Set the last modified movie
                wasAddedToWatchlist = false; // Set wasAddedToWatchlist to false
            }
            return result;
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        } finally {
            notifyObservers(UpdateType.REMOVED); // Notify observers after the movie has been removed
        }
    }

    public boolean isInWatchlist(String apiId) throws DataBaseException {
        try {
            if (dao.queryBuilder().where().eq("apiId", apiId).countOf() > 0) {
                System.out.println("Movie is in watchlist");
                return true;
            } else {
                System.out.println("Movie is not in watchlist");
                return false;
            }
        } catch (Exception e) {
            throw new DataBaseException("Error while checking if movie is in watchlist");
        }
    }

    public boolean wasAddedToWatchlist() {
        return wasAddedToWatchlist;
    }

    //methods to implement the observer pattern for the watchlist
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer); //add observer to list
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); //remove observer from list
    }

    @Override
    public void notifyObservers(UpdateType updateType) {
        System.out.println("Notifying observers");
        for (Observer observer : observers) {
            observer.update(updateType); //notify all observers
        }
    }
}
