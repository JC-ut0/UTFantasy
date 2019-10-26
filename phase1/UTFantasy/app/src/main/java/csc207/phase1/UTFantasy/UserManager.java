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

    /**
     * A  HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, User> userHashMap;

    /**
     * A unique userManager that will be only created once.
     */
    private static UserManager userManager;

    /**
     * Where all user data are stored.
     */
    private String userFile = "user";

    /**
     * Singleton Constructor of UserManager.
     */
    private UserManager() {
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

    /**
     * Login by username and password.
     *
     * @param username the username of the User.
     * @param password the password of the User.
     * @return A User if logged in successfully, null if not.
     */
    public User login(String username, String password) {
        if (userHashMap.containsKey(username)) {
            String pwd = Objects.requireNonNull(userHashMap.get(username)).getPassword();
            if (password.equals(pwd)) {
                return userHashMap.get(username);
            }
        }
        return null;
    }

    /**
     * Register using username and password. Update the userHapMap after resisting.
     *
     * @param username the username of the User.
     * @param password the password of the User.
     * @return A new User.
     */
    public User register(String username, String password) {
        User user = new User(username, password);
        userHashMap.put(username, user);
        return user;
    }

    /**
     * Get the User in userHashMap if the username is in the userHapMap.
     *
     * @param username the username of the User.
     * @return a User if the username is in the userHashMap, null if not.
     */
    public User getUser(String username) {
        if (userHashMap.containsKey((username))) {
            return userHashMap.get(username);
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


    /**
     * Return userHashMap
     *
     * @return userHashMap
     */
    public HashMap<String, User> getUserHashMap() {
        return userHashMap;
    }

    /**
     * Set a new userHashMap.
     *
     * @param userHashMap a new userHashMap.
     */
    public void setUserHashMap(HashMap<String, User> userHashMap) {
        this.userHashMap = userHashMap;
    }

    /**
     * Save all data of UserManager to local.
     *
     * @param context the Activity(Context) that calls this method.
     */
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

    /**
     * Load data from local, and update the UserManager.
     *
     * @param context the Activity(Context) that calls this method.
     */
    public void loadUserManager(Context context) {
        try {
            FileInputStream fis = context.openFileInput(userFile);
            if (fis != null) {
                ObjectInputStream inputStream = new ObjectInputStream(fis);
                UserManager localUserManager = (UserManager) inputStream.readObject();
                userHashMap = localUserManager.userHashMap;
                if (userHashMap == null) userHashMap = new HashMap<>();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            userHashMap = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Build a dialog that title is UT Fantasy.
     *
     * @param message The message of the dialog.
     * @param context The Activity that calls this method.
     */
    public void message(String message, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("UT Fantasy");
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    /**
     * Build a dialog .
     *
     * @param title   The title of the dialog.
     * @param message The message of the dialog.
     * @param context The Activity that calls this method.
     */
    public void message(String title, String message, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
