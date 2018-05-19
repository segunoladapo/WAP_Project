package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by 986296 on 5/18/2018.
 */
public class UserDao {

    private static List<User> users;
    static {
        users = new ArrayList<>();
        User user = new User();
        user.setUsername("sunil");
        user.setPassword("sunil");
        users.add(user);
    }
    public static void createUser(User user){
        users.add(user);
    }

    public static Optional<User> findUser(String username){
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny();
    }

    public static Optional<User> findUserByPwdAndUsername(String username, String password){
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findAny();

    }


}
