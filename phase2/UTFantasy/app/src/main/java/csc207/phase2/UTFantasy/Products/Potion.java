package csc207.phase2.UTFantasy.Products;

public abstract class Potion extends Product {
    private int healthPoint;

    Potion(String name, int price, int imageRes, int hp){
        super(name, price, imageRes);
        this.healthPoint = hp;
    }

    public int getHealthPoint(){
        return healthPoint;
    }
}
