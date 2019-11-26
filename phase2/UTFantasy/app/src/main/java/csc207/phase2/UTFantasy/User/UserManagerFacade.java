package csc207.phase2.UTFantasy.User;

import android.app.Activity;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;

public class UserManagerFacade implements UserManagerFacadeInterface {

  private UserIOInterface userIO;
  private UserAuthorizer userAuthorizer;
  private Activity activity;

  public UserManagerFacade(UserIOInterface userIO, Activity activity) {
    this.activity = activity;
    this.userIO = userIO;
    userAuthorizer = new UserAuthorizer(userIO);
  }

  @Override
  public User login(String username, String password) {
    return userAuthorizer.login(username, password);
  }

  @Override
  public User register(String username, String password) {
    return userAuthorizer.register(username, password);
  }

  @Override
  public User getUser(String username) {
    return userAuthorizer.getUser(username);
  }

  @Override
  public void saveUserData() {
    userIO.saveUserData(activity);
  }

  private UserData getUserData() {
    return userAuthorizer.getUserData();
  }

  @Override
  public void loadUserData() {
    userIO.loadUserData(activity);
  }

  public boolean isUserExisted(String username) {
    return userIO.getUserData().getUserHashMap().containsKey(username);
  }

  @Override
  public List<Player> getScoreBoardPlayerList() {
    return userIO.getUserData().getScoreBoardPlayerList();
  }
}