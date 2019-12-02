package csc207.phase2.UTFantasy.userUseCase;

import android.app.Activity;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;

/** A Facade that include all user use case methods. */
public class UserManagerFacade implements UserManagerFacadeInterface {

  private UserIOInterface userIO;
  private UserAuthorizer userAuthorizer;
  private Activity activity;

  /**
   * Constructor of this UserManagerFacade
   *
   * @param userIO the singleton userIO.
   * @param activity the activity that create this UserManagerFacade
   */
  public UserManagerFacade(UserIOInterface userIO, Activity activity) {
    this.activity = activity;
    this.userIO = userIO;
    userAuthorizer = new UserAuthorizer(userIO);
  }

  /**
   * Login the user by username and password.
   *
   * @param username username typed in.
   * @param password user password typed in
   * @return a User instance if logged in successfully, otherwise null.
   */
  @Override
  public User login(String username, String password) {
    return userAuthorizer.login(username, password);
  }

  /**
   * Register the user by username and password.
   *
   * @param username username typed in.
   * @param password user password typed in
   * @return a User instance.
   */
  @Override
  public User register(String username, String password) {
    return userAuthorizer.register(username, password);
  }

  /**
   * Get a User instance according to username.
   *
   * @param username the requested username
   * @return a User instance according to username, if the user does not exist, return null.
   */
  @Override
  public User getUser(String username) {
    return userAuthorizer.getUser(username);
  }

  /** Save all user data to local file use the activity that create this UserManagerFacade. */
  @Override
  public void saveUserData() {
    userIO.saveUserData(activity);
  }

  /**
   * Get all user data stored locally from local file use the activity that create this
   * UserManagerFacade.
   */
  @Override
  public void loadUserData() {
    userIO.loadUserData(activity);
  }

  /**
   * Check if the User existed according to username.
   *
   * @param username the username requested
   * @return true if existed, false if not.
   */
  public boolean isUserExisted(String username) {
    return userIO.getUserData().getUserHashMap().containsKey(username);
  }

  /**
   * Get Score Board Player List. The list only contains players that want to show their scores.
   *
   * @return Score Board Player List.
   */
  @Override
  public List<Player> getScoreBoardPlayerList() {
    return userIO.getUserData().getScoreBoardPlayerList();
  }
}
