package csc207.phase1.UTFantasy.Character;

public class Player extends Person {
    /**
     * the amount this player has
     */
    private int money;

    public Player(String name, String gender) {
        super(name,gender);
        this.money = 0;
    }

    public void move(String direction) {
        switch (direction){
            case("left"):
                x -=1;
                break;
            case("right"):
                x += 1;
                break;
            case("up"):
                y -= 1;
                break;
            case("down"):
                y +=1;
                break;
        }
    }

    public int getMoney() {
        return money;
    }

    void setMoney(int money) {
        this.money = money;
    }
}
