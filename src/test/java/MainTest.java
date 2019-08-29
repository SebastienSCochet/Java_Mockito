import database.UserDAO;
import org.mockito.*;
import view.MainViewImpl;
import view.MainView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import presenter.MainPresenter;

import static org.mockito.Mockito.*;

/**
 * A mock is a used to instantiate classes or interfaces. Every methods of a mock return null,
 * we have to say what value is returned.
 * We can do the same on a spy. But the spy has his real return values by default. We spy concrete object to verify if a method is
 * called or not.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
    private MainView mainView;
    @Mock
    private UserDAO userDAO;

    // Spies
    private MainPresenter mainPresenter;
    private MainViewImpl mainViewImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Because @InjectMocks can't be used with a specified mock.

        mainPresenter = Mockito.spy(new MainPresenter(mainView, userDAO));
        mainViewImpl = Mockito.spy(new MainViewImpl(mainPresenter));
    }

    @Test
    public void whenPresenterInitializedThenUserNameIsDisplayedFromDatabase() {
        when(userDAO.getName(1)).thenReturn("Bob");
        mainPresenter.onInit();
        verify(mainView, atLeastOnce()).displayName("Bob");
    }

    @Test
    public void whenUserKickedThenLoseLifePoints() {
        mainViewImpl.onManKicked();
        verify(mainPresenter, atLeastOnce()).loseLifePoints(anyInt());
        verify(userDAO, atLeastOnce()).decreaseLifePoints(anyInt(), anyInt());
    }

    @Test
    public void whenLoseLifePointsThenDisplayIt() {
        mainPresenter.loseLifePoints(anyInt());
        verify(mainView, atLeastOnce()).displayText(anyString());
    }
}
