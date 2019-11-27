package csc207.phase2.UTFantasy.Products;

import java.util.ArrayList;


public class ProductBuilder {
  ArrayList<Product> products;

  ProductBuilder() {
    products = new ArrayList<>();
  }

  void addProduct(ProductName name) {
    ProductFactory productFactory = new ProductFactory();
    products.add(productFactory.makePotion(name));
  }

  public ArrayList<Product> getProducts() {
    return products;
  }
}
