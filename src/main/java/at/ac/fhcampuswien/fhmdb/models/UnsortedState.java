package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

/**
 * Concrete class for the unsorted sort state
 * Only occurs when the program starts and until the sorting button is pressed
 */
public class UnsortedState extends SortState {

    public UnsortedState(MovieListController movieListController) {
        super(movieListController);
    }

    @Override
    public void sort() {
        // do nothing
    }

    @Override
    public void nextSortState() {
        movieListController.setSortState(new AscendingState(movieListController));
    }
}
