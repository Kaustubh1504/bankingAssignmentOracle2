package userDAO;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    User getUser(String userId);
    void updateUser(User user);
    void deleteUser(String userId);
    List<User> getAllUsers();
}
