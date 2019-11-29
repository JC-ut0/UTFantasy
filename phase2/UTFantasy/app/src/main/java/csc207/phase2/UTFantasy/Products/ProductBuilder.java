package csc207.phase2.UTFantasy.Products;

import java.util.ArrayList;

public class ProductBuilder {
  /** a list of products */
  ArrayList<Product> products;

  ProductBuilder() {
    products = new ArrayList<>();
  }

  /** add product to list products */
  void addProduct(ProductName name) {
    ProductFactory productFactory = new ProductFactory();
    products.add(productFactory.makePotion(name));
  }

  /** return a list of product */
  public ArrayList<Product> getProducts() {
    return products;
  }
}
