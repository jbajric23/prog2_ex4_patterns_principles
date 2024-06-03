package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;

import java.util.Comparator;

/**
 * Concrete class for the ascending sort state
 * Sorts the movies in ascending order when the sorting button is pressed the first time
 */
public class AscendingState extends SortState {

    public AscendingState(MovieListController movieListController) {
        super(movieListController);
    }

    @Override
    public void sort() {
        movieListController.getObservableMovies().sort(Comparator.comparing(Movie::getTitle));
    }

    @Override
    public void nextSortState() {
        movieListController.setSortState(new DescendingState(movieListController));
    }
}
