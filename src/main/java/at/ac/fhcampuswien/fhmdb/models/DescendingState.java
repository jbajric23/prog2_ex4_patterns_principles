package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

import java.util.Comparator;

/**
 * Concrete class for the ascending sort state
 * Occurs after the sorting button is pressed and the list is sorted in ascending order
 */
public class DescendingState extends SortState {
    public DescendingState(MovieListController movieListController) {
        super(movieListController);
    }

    @Override
    public void sort() {
        movieListController.getObservableMovies().sort(Comparator.comparing(Movie::getTitle).reversed());
    }

    @Override
    public void nextSortState() {
        movieListController.setSortState(new AscendingState(movieListController));
    }
}
