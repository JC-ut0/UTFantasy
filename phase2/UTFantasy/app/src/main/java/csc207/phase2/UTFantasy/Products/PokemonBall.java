package csc207.phase2.UTFantasy.Products;

public abstract class PokemonBall extends Product {
  /** the probability of catching a pokemon, range from 0 to 1 */
  private double getRate;

  PokemonBall(String name, int price, int imageRes, double getRate) {
    super(name, price, imageRes);
    this.getRate = getRate;
  }

  public double getRate() {
    return getRate;
  }
}
