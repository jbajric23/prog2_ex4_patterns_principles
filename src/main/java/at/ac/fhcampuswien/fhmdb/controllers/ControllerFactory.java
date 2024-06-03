package at.ac.fhcampuswien.fhmdb.controllers;

import javafx.util.Callback;
import java.util.HashMap;
import java.util.Map;

public class ControllerFactory implements Callback<Class<?>, Object> {
    private final Map<Class<?>, Object> singletons = new HashMap<>();

    @Override
    public Object call(Class<?> type) {
        if (!singletons.containsKey(type)) {
            try {
                singletons.put(type, type.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return singletons.get(type);
    }

    public <T> T getController(Class<T> type) {
        return type.cast(call(type));
    }
}
