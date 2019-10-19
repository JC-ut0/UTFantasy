package csc207.phase1.UTFantasy.Character;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.MainActivity;

public class Player extends Person implements Serializable{
    /**
     * the amount this player has
     */
    private int money;

    void setMoney(int money) {
        this.money = money;
    }

    int getMoney() {
        return money;
    }

    public Player(String name, String gender) {
        super(name,gender);
        this.money = 0;
    }

    void move() {
    }


}
