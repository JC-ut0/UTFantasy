package csc207.phase1.UTFantasy;

import java.util.HashMap;

public class UserManager {
    private static HashMap<String, User> userHashMap;

    public UserManager(HashMap<String, User> userHashMap) {
        this.userHashMap = userHashMap;
    }

     public static boolean login(String name, String password){
        if(userHashMap.containsKey(name)){
            String ps = userHashMap.get(name).getPassword();
            return password.equals(ps);
        }
        return false;
    }
    public static User register(String name, String password){
        User user = new User(name, password);
        return user;
    }

    public static User getUser(String accountStr) {
        if (userHashMap.containsKey((accountStr))) {
            return userHashMap.get(accountStr);
        }
        return null;
    }

    void logout(){

    }

    void restore(){

    }

    void store(){

    }
}
