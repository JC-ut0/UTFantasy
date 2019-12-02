package csc207.phase2.UTFantasy.Products;

/** Use Factory Design Pattern to create products. */
class ProductFactory {

  Product makePotion(ProductName potion) {
    switch (potion) {
      case redPotion:
        return new RedPotion();
      case pinkPotion:
        return new PinkPotion();
      case purplePotion:
        return new PurplePotion();
      case masterBall:
        return new MasterBall();
      case pokeBall:
        return new PokeBall();
      case ultraBall:
        return new UltraBall();
    }
    return null;
  }
}
