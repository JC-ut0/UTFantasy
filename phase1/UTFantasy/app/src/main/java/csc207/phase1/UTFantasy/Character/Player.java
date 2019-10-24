package csc207.phase1.UTFantasy.Character;

import java.io.Serializable;

import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.UnitDraw;

public class Player extends Person implements Serializable {
    /**
     * the map manager this player belongs to
     */
    public MapManager mapManager;
    /**
     * the amount this player has
     */
    private int money;

    /**
     * the direction that the player is facing to
     */
    public String direction = "down";

    public Player(String name, String gender) {
        super(name, gender);
        this.money = 0;
    }

    public void move(String direction) {
        switch (direction) {
            case ("left"):
                for (int[] block : mapManager.blockMap) {
                    if (block[0] < getX() - 1 && getX() - 1 <
                            block[1] && block[2] < getY() && getY() < block[3]) {
                        x += 1;
                    }
                }
                x -= 1;
                break;
            case ("right"):
                for (int[] block : mapManager.blockMap) {
                    if (block[0] < getX() + 1 && getX() + 1 <
                            block[1] && block[2] < getY() && getY() < block[3]) {
                        x -= 1;
                    }
                }
                x += 1;
                break;
            case ("up"):
                for (int[] block : mapManager.blockMap) {
                    if (block[0] < getX() && getX() <
                            block[1] && block[2] < getY() - 1 && getY() - 1 < block[3]) {
                        y += 1;
                    }
                }
                y -= 1;
                break;
            case ("down"):
                for (int[] block : mapManager.blockMap) {
                    if (block[0] < getX() && getX() <
                            block[1] && block[2] < getY() + 1 && getY() + 1 < block[3]) {
                        y -= 1;
                    }
                }
                y += 1;
                break;
        }
        this.direction = direction;
    }

    int getMoney() {
        return money;
    }

    void setMoney(int money) {
        this.money = money;
    }
}
