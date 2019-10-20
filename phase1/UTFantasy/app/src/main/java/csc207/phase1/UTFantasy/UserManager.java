package csc207.phase1.UTFantasy;

import java.util.HashMap;
import java.util.Objects;

/**
 * A class to manage all the Users. Will be initialized in the login activity.
 */
public class UserManager {

    /**
     * A static HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, User> userHashMap;

    private String path;

    /**
     * Constructor of UserManager.
     */
    public UserManager() {

    }

    public boolean login(String name, String password) {
        if (userHashMap.containsKey(name)) {
            String pwd = Objects.requireNonNull(userHashMap.get(name)).getPassword();
            return password.equals(pwd);
        }
        return false;
    }

    public User register(String name, String password) {
        User user = new User(name, password);
        userHashMap.put(name, user);
        return user;
    }

    public User getUser(String accountStr) {
        if (userHashMap.containsKey((accountStr))) {
            return userHashMap.get(accountStr);
        }
        return null;
    }

    void logout() {

    }


    public HashMap<String, User> getUserHashMap() {
        return userHashMap;
    }

    public void setUserHashMap(HashMap<String, User> userHashMap) {
        this.userHashMap = userHashMap;
    }

    void save() {

    }
}
