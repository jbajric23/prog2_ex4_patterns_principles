package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

/**
 * Abstract class for the different sort states
 * Is the main foundation of the state pattern
 */
public abstract class SortState {
    protected MovieListController movieListController;

    public SortState(MovieListController movieListController) {
        this.movieListController = movieListController;
    }

    public abstract void sort();
    public abstract void nextSortState();
}
