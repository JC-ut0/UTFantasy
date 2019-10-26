package csc207.phase1.UTFantasy;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

import csc207.phase1.UTFantasy.Activities.LoginActivity;

/**
 * A Singleton class to manage all the Users. Will be initialized in the login activity.
 */
public class UserManager implements Serializable {

    /**
     * A static HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, User> userHashMap;

    private static UserManager userManager;

    private String userFile = "user.txt";

    private String playerFile = "player.txt";

    /**
     * Singleton Constructor of UserManager.
     */
    private UserManager() {
        // read local file, update the userHashMap
        userHashMap = new HashMap<>();
    }

    /**
     * always return a same UserManager.
     *
     * @return a UserManager
     */
    public static UserManager getUserManager() {
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager;
    }

    public User login(String name, String password) {
        if (userHashMap.containsKey(name)) {
            String pwd = Objects.requireNonNull(userHashMap.get(name)).getPassword();
            if (password.equals(pwd)){
                return userHashMap.get(name);
            }
        }
        return null;
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

    public void saveUserManager(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(userFile, Context.MODE_PRIVATE);
            FileOutputStream playFos = context.openFileOutput(playerFile, Context.MODE_PRIVATE);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            ObjectOutputStream playerOS = new ObjectOutputStream(playFos);
            outputStream.writeObject(userHashMap);
            playerOS.writeObject(userManager);
            outputStream.close();
            playerOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUserManager(Context context) throws Exception {
        try {
            FileInputStream fis = context.openFileInput(playerFile);
            if (fis != null) {
                ObjectInputStream inputStream = new ObjectInputStream(fis);
                userManager = (UserManager) inputStream.readObject();
                if (userManager == null) userManager = new UserManager();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            message("FileReading problem, the userHashMap is set to be empty!", context);
        }
    }

    private void message(String str, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("UT Fantasy");
        builder.setMessage(str);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
