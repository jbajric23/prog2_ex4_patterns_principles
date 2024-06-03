package at.ac.fhcampuswien.fhmdb.controllers;

public class ControllerFactory {
    private static MainController mainControllerInstance;
    private static WatchlistController watchlistControllerInstance;
    private static MovieListController movieListControllerInstance;


    public static Object getControllerInstance(Class<?> controllerClass) {
        if (controllerClass == MainController.class) {
            if (mainControllerInstance == null) {
                mainControllerInstance = new MainController();
            }
            return mainControllerInstance;
        } else if (controllerClass == WatchlistController.class) {
            if (watchlistControllerInstance == null) {
                watchlistControllerInstance = new WatchlistController();
            }
            return watchlistControllerInstance;
        } else if (controllerClass == MovieListController.class) {
            if (movieListControllerInstance == null) {
                movieListControllerInstance = new MovieListController();
            }
            return movieListControllerInstance;
        } else {
            throw new IllegalArgumentException("Invalid controller class: " + controllerClass);
        }
    }
}
