package database;

public interface UserDAO {
    void retrieveLifePoints(int userId, int lifePoints);
    String getName(int userId);
}
