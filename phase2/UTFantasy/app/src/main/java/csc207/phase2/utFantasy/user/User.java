package csc207.phase2.utFantasy.user;

import java.io.Serializable;

import csc207.phase2.utFantasy.character.Player;

/** A User which can log in and create a player to play the game (maybe more players later) */
public class User implements Serializable {
  /** username */
  private String name;
  /** password of this user */
  private String password;
  /** player of this user */
  private Player player;

  /**
   * Construct a User
   *
   * @param name username
   * @param password password of account
   */
  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  /**
   * return the name of this user
   *
   * @return the name of this user
   */
  public String getName() {
    return name;
  }

  /**
   * return password of this user.
   *
   * @return password of this user.
   */
  String getPassword() {
    return password;
  }

  /**
   * set new password for this user
   *
   * @param password new password for this user
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Check if the user has a player.
   *
   * @return true if the User has a player, false if not.
   */
  public boolean hasPlayer() {
    return player != null;
  }

  /**
   * return a player instance
   *
   * @return a player instance
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * set a new player for this user
   *
   * @param player a new player
   */
  public void setPlayer(Player player) {
    this.player = player;
  }
}
