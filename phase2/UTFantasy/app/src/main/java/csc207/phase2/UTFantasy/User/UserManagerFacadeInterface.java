package csc207.phase2.UTFantasy.User;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;

public interface UserManagerFacadeInterface {

  User login(String username, String password);

  User register(String username, String password);

  User getUser(String username);

  void saveUserData();

  void loadUserData();

  boolean isUserExisted(String username);

  List<Player> getScoreBoardPlayerList();
}
