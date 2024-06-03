package at.ac.fhcampuswien.fhmdb.database;


import at.ac.fhcampuswien.fhmdb.enums.UpdateType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WatchlistRepositoryTest {

    private WatchlistRepository watchlistRepository;
    private Observer mockObserver;

    @BeforeEach
    public void setUp() throws DataBaseException {
        watchlistRepository = WatchlistRepository.getInstance();
        mockObserver = Mockito.mock(Observer.class);
        watchlistRepository.addObserver(mockObserver);
    }

    @Test
    public void testNotifyObservers() {
        watchlistRepository.notifyObservers(UpdateType.ADDED);
        verify(mockObserver, times(1)).update(UpdateType.ADDED);
    }
}