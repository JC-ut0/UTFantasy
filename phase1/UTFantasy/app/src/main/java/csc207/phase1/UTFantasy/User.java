package csc207.phase1.UTFantasy;

import csc207.phase1.UTFantasy.Character.Player;

public class User {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Player getPlayer() {
        return player;
    }
}
