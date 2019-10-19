package csc207.phase1.UTFantasy;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> map;

    public UserManager(HashMap<String, User> map) {
        this.map = map;
    }

    boolean login(String name, String password){
        if(map.containsKey(name)){
            String ps = map.get(name).getPassword();
            return password.equals(ps);
        }
        return false;
    }
    public static User register(String name, String password){
        User user = new User(name, password);
        return user;
    }
    void logout(){

    }

    void restore(){

    }

    void store(){

    }
}
