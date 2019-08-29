package view;

import database.UserDAO;
import database.UserDAOImpl;
import presenter.MainPresenter;

public class MainViewImpl implements MainView {

    private MainPresenter mainPresenter;

    public MainViewImpl() {
        mainPresenter = new MainPresenter(this, new UserDAOImpl());
    }

    public MainViewImpl(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    public void displayName(String name) {
        System.out.println(name);
    }

    public void onManKicked() {
        mainPresenter.loseLifePoints(4);
    }

    public void displayText(String text) {
        System.out.println(text);
    }
}
