package csc207.phase1.UTFantasy;

public class User {

    private String name;
    private String password;
    private Player player;

    public User(String name, Player player) {
        this.name = name;
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
