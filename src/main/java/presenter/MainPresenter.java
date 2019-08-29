package presenter;

import database.UserDAO;
import view.MainView;

public class MainPresenter {
    MainView mainView;
    UserDAO userDAO;

    public MainPresenter(MainView mainView, UserDAO userDAO) {
        this.mainView = mainView;
        this.userDAO = userDAO;

        onInit();
    }

    public void onInit() {
        mainView.displayName(userDAO.getName(1));
    }

    public void loseLifePoints(int lifePoints) {
        userDAO.decreaseLifePoints(1, lifePoints);
        mainView.displayText(lifePoints + " life points lost.");
    }
}
