package database;

public interface UserDAO {
    void decreaseLifePoints(int userId, int lifePoints);
    String getName(int userId);
}
