package csc207.phase2.UTFantasy.Products;

abstract class Potion extends Product {
  /** the health point that Potion can restore */
  private int healthPoint;
  /** Construct of Potion, inherit from Product */
  Potion(String name, int price, int imageRes, int hp) {
    super(name, price, imageRes);
    this.healthPoint = hp;
  }

  /** getter of health point */
  public int getHealthPoint() {
    return healthPoint;
  }
}
