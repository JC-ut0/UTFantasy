package csc207.phase2.UTFantasy.IO;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import csc207.phase2.UTFantasy.AllSkills.Thunderblot;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
import csc207.phase2.UTFantasy.User.User;
import csc207.phase2.UTFantasy.User.UserData;
import csc207.phase2.UTFantasy.User.UserIOInterface;

/** A Singleton class to manage UserData. Will be initialized in the StartUp activity. */
public class UserIO implements UserIOInterface {

  /** The file to store UserData */
  private String userFile = "user.txt";

  private UserData userData;

  /** A unique UserIO that will be only created once. */
  private static UserIO SINGLETON_USER_IO = new UserIO();

  /** Singleton Constructor of UserIO. */
  private UserIO() {}

  /**
   * Always return a same UserIO. Initialize a UserIO when this method is call at first time. Should
   * load data in the activity
   *
   * @return a unique UserIO
   */
  public static synchronized UserIO getSingletonUserIo() {
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
    } catch (FileNotFoundException | ClassNotFoundException e) {
      Toast.makeText(
              context, "Created a new UserData\n" + e.getClass().toString(), Toast.LENGTH_LONG)
              .show();
      e.printStackTrace();
      Log.e("Exception", e.getMessage() + e.getMessage());
        createNewUserData();
    } catch (IOException e) {
      AlertDialog.Builder builder = new AlertDialog.Builder(context);
      builder.setTitle(e.getClass().toString());
      builder.setMessage(e.getMessage());
      builder.setPositiveButton("OK", null);
      builder.show();
      e.printStackTrace();
        createNewUserData();
    }
  }

  /** This method is only used for demo, should not be include in this class.*/
    private void createNewUserData() {
        userData = new UserData();
        User user = new User("yimi", "20191128");
        Player player = new Player("yimi", "girl");
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 100);
        pokemon.updateSkills(new Thunderblot(), null);
        player.addPokemon(pokemon);
        player.setMoney(1000000000);
        user.setPlayer(player);
        userData.addUser("yimi", user);
  }
}
