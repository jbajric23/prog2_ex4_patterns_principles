package at.ac.fhcampuswien.fhmdb.database;

public interface Oberservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
