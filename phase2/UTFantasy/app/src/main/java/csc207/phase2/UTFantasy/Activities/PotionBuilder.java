package csc207.phase2.UTFantasy.Activities;

import csc207.phase2.UTFantasy.Products.Potion;
import csc207.phase2.UTFantasy.Products.PotionFactory;

public class PotionBuilder extends ProductBuilder {
  PotionBuilder() {
    super();
  }

  public void addProduct(Potion potion) {
    PotionFactory potionFactory = new PotionFactory();
    products.add(potionFactory.makePotion(potion));
  }
}
