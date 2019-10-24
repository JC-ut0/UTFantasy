package csc207.phase1.UTFantasy;

import android.content.Context;
import android.content.Intent;

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
    private static final long serialVersionUID = 1L;

    /**
     * A static HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, User> userHashMap;

    private static UserManager userManager;

    private String userFile = "user.txt";

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
            if (password.equals(pwd)) {
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

    /**
     * Save the current User's file, logout and got to LoginActivity.
     *
     * @param context The Context that calls this logout method.
     */
    void logout(Context context) {
        // save file first
        saveUserManager(context);
        // go back to User Activity from the current Activity
        Intent intent = new Intent(context, LoginActivity.class);
        // prevent User coming back to this activity!
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
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
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(userManager);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadUserManager(Context context) throws Exception {
        try {
            FileInputStream fis = context.openFileInput(userFile);
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

    public void message(String message, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("UT Fantasy");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
