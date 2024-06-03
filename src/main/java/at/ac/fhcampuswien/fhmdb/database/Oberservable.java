package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.enums.UpdateType;

public interface Oberservable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(UpdateType updateType);

}
