package csc207.phase1.UTFantasy;

import java.io.Serializable;

import csc207.phase1.UTFantasy.Character.Player;

public class User implements Serializable {

    private String name;
    private String password;
    private Player player;

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
     * return whether the User has a player.
     *
     * @return whether the User has a player.
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
