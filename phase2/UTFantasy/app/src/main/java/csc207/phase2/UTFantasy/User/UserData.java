package csc207.phase2.UTFantasy.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;

public class UserData implements Serializable {
  /** A HashMap that keys are UserName, values are User instance. */
  private HashMap<String, User> userHashMap;

  public UserData() {
    userHashMap = new HashMap<>();
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

  public HashMap<String, User> getUserHashMap() {
    return userHashMap;
  }

  void addUser(String username, User user) {
    userHashMap.put(username, user);
  }

  /**
   * retrun a list of players that want to show their score.
   *
   * @return a list of players that want to show their score.
   */
  public List<Player> getScoreBoardPlayerList() {
    List<Player> scoreBoardPlayerList = new ArrayList<>();
    for (User user : userHashMap.values()) {
      if (user.hasPlayer()) {
        Player player = user.getPlayer();
        if (player.isShowingScore()) scoreBoardPlayerList.add(player);
      }
    }
    return scoreBoardPlayerList;
  }
}
