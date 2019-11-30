package csc207.phase2.UTFantasy.Products;

import java.util.ArrayList;

import static csc207.phase2.UTFantasy.Products.ProductName.masterBall;
import static csc207.phase2.UTFantasy.Products.ProductName.pinkPotion;
import static csc207.phase2.UTFantasy.Products.ProductName.purplePotion;
import static csc207.phase2.UTFantasy.Products.ProductName.redPotion;

/** Create a list of products on sale in shop */
public class ProductCreator {
  private ArrayList<Product> products;

  public ProductCreator() {
    ProductBuilder builder = new ProductBuilder();
    builder.addProduct(pinkPotion);
    builder.addProduct(redPotion);
    builder.addProduct(purplePotion);
    builder.addProduct(masterBall);
    products = builder.getProducts();
  }

  public ArrayList<Product> getProducts() {
    return products;
  }
}
