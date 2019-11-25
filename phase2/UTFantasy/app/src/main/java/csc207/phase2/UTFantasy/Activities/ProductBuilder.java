package csc207.phase2.UTFantasy.Activities;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Products.PotionFactory;
import csc207.phase2.UTFantasy.Products.Product;

public abstract class ProductBuilder {
  ArrayList<Product> products;

  ProductBuilder() {
    products = new ArrayList<>();
  }

  abstract void addProduct(String name);

  public ArrayList<Product> getProducts() {
    return products;
  }
}
