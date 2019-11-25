package csc207.phase2.UTFantasy.Activities;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Products.PotionFactory;
import csc207.phase2.UTFantasy.Products.Product;

public class PotionBuilder extends ProductBuilder {
    PotionBuilder(){
        super();
    }
    public void addProduct(String name){
        PotionFactory potionFactory = new PotionFactory();
        products.add(potionFactory.makePotion(name));
    }
}
