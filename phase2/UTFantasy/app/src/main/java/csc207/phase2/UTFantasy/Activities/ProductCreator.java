package csc207.phase2.UTFantasy.Activities;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Products.Product;

import static csc207.phase2.UTFantasy.Products.Potion.pink;
import static csc207.phase2.UTFantasy.Products.Potion.purple;
import static csc207.phase2.UTFantasy.Products.Potion.red;

public class ProductCreator {
  private ArrayList<Product> products;

  ProductCreator() {
    ProductBuilder builder = new PotionBuilder();
    builder.addProduct(pink);
    builder.addProduct(red);
    builder.addProduct(purple);
    products = builder.getProducts();
  }

  public ArrayList<Product> getProducts() {
    return products;
  }
}
