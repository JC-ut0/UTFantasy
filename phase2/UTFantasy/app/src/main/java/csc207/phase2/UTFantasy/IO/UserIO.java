package csc207.phase2.UTFantasy.IO;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import csc207.phase2.UTFantasy.User.UserData;
import csc207.phase2.UTFantasy.User.UserIOInterface;

/** A Singleton class to manage UserData. Will be initialized in the StartUp activity. */
public class UserIO implements UserIOInterface {

  /** The file to store UserData */
  private final String userFile = "user.txt";
  //  private String userFile =
  // Environment.getExternalStorageDirectory().getAbsolutePath()+"/user.txt";
  private UserData userData;

  /** A unique UserIO that will be only created once. */
  private static final UserIO SINGLETON_USER_IO = new UserIO();

  /** Singleton Constructor of UserIO. */
  private UserIO() {}

  /**
   * Always return a same UserIO. Initialize a UserIO when this method is call at first time. Should
   * load data in the activity
   *
   * @return a unique UserIO
   */
  public static UserIO getSingletonUserIo() {
    return SINGLETON_USER_IO;
  }

  /**
   * return UserData
   *
   * @return UserData
   */
  public UserData getUserData() {
    return userData;
  }

  /**
   * Save UserData to local.
   *
   * @param context the Activity(Context) that calls this method.
   */
  @Override
  public void saveUserData(Context context) {
    try {
      FileOutputStream fos = context.openFileOutput(userFile, Context.MODE_PRIVATE);
      ObjectOutputStream outputStream = new ObjectOutputStream(fos);
      outputStream.writeObject(userData);
      outputStream.close();
    } catch (IOException e) {
      Toast.makeText(context, "E:" + e.getMessage(), Toast.LENGTH_LONG).show();
      e.printStackTrace();
    }
  }

  /**
   * Load UserData from local..
   *
   * @param context the Activity(Context) that calls this method.
   */
  @Override
  public void loadUserData(Context context) {
    try {
      FileInputStream fis = context.openFileInput(userFile);
      if (fis != null) {
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        this.userData = (UserData) inputStream.readObject();
        inputStream.close();
        if (userData == null) userData = new UserData();
      }
    } catch (FileNotFoundException e) {
      Toast.makeText(context, "Created a new UserData\n" + e.getMessage(), Toast.LENGTH_LONG)
          .show();
      e.printStackTrace();
      userData = new UserData();
    } catch (IOException | ClassNotFoundException e) {
      AlertDialog.Builder builder = new AlertDialog.Builder(context);
      builder.setTitle(e.getClass().toString());
      builder.setMessage(e.getMessage());
      builder.setPositiveButton("OK", null);
      builder.show();
      e.printStackTrace();
      userData = new UserData();
    }
  }
}
