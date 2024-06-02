package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.enums.UpdateType;

public interface Observer {
    void update(UpdateType updateType);

}
