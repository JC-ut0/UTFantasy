package csc207.phase2.UTFantasy.Products;

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
    }
    return null;
  }
}
