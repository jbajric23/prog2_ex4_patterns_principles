package at.ac.fhcampuswien.fhmdb.controllers;

public class ControllerFactory {
    private static MainController mainControllerInstance;
    private static WatchlistController watchlistControllerInstance;
    private static MovieListController movieListControllerInstance;

    public static MainController getMainControllerInstance() {
        if (mainControllerInstance == null) {
            mainControllerInstance = new MainController();
        }
        return mainControllerInstance;
    }

    public static WatchlistController getWatchlistControllerInstance() {
        if (watchlistControllerInstance == null) {
            watchlistControllerInstance = new WatchlistController();
        }
        return watchlistControllerInstance;
    }

    public static MovieListController getMovieListControllerInstance() {
        if (movieListControllerInstance == null) {
            movieListControllerInstance = new MovieListController();
        }
        return movieListControllerInstance;
    }
}
