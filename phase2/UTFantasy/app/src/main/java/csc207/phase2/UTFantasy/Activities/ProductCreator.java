package csc207.phase2.UTFantasy.Activities;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Products.Product;

public class ProductCreator {
    private ArrayList<Product> products;
    private ProductBuilder builder;
    ProductCreator(){
        builder = new PotionBuilder();
        builder.addProduct("pink");
        builder.addProduct("red");
        builder.addProduct("purple");
        products = builder.getProducts();
    }

    public ArrayList<Product> getProducts(){
        return products;
    }


}
