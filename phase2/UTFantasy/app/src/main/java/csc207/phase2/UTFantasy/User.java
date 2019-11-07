package csc207.phase2.UTFantasy;

import java.io.Serializable;

import csc207.phase2.UTFantasy.Character.Player;

public class User implements Serializable {
    /**
     * username
     */
    private String name;
    /**
     * password of this user
     */
    private String password;
    /**
     * player of this user
     */
    private Player player;

    /**
     * Construct a User
     *
     * @param name     username
     * @param password password of account
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    String getPassword() {
        return password;
    }

    /**
     * Check if the user has a player.
     *
     * @return true if the User has a player, false if not.
     */
    public boolean hasPlayer() {
        return player != null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Player getPlayer() {
        return player;
    }
}
