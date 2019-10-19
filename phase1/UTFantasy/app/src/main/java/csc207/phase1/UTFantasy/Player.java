package csc207.phase1.UTFantasy;

import java.util.ArrayList;

class Player extends Person{
    /**
     * the amount this player has*/
    private int money;

    void setMoney(int money){
        this.money = money;
    }

    int getMoney(){
        return money;
    }
    Player(String name, String gender, int money){
        super(name, gender);
        this.money = money;
    }
    void move(){}


}
