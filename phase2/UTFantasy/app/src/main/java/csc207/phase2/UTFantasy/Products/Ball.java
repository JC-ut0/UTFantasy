package csc207.phase2.UTFantasy.Products;

public abstract class Ball extends Product {
  /** the probability of catching a pokemon, range from 0 to 1 */
  private double getRate;

  /** Constructor of Ball, inherit from Product */
  Ball(String name, int price, int imageRes, double getRate) {
    super(name, price, imageRes);
    this.getRate = getRate;
  }

  public double getRate() {
    return getRate;
  }
}
