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
    {
        users = new ArrayList<>();

    }
    public static void createUser(User user){
        users.add(user);
    }

    public static Optional<User> findUser(String username){
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny();
    }


}
