package csc207.phase2.UTFantasy.Products;

abstract class PokemonBall extends Product {
  /** the probability of catching a pokemon, range from 0 to 1 */
  private double getCaught;

  PokemonBall(String name, int price, int imageRes, double getCaught) {
    super(name, price, imageRes);
    this.getCaught = getCaught;
  }

  double getGetCaught() {
    return getCaught;
  }
}
