package csc207.phase2.UTFantasy.Products;

/** Use Factory Design Pattern to create products. */
class ProductFactory {
  private Product product;

  Product makeProduct(ProductName productName) {
    switch (productName) {
      case redPotion:
        product = new RedPotion();
        break;
      case pinkPotion:
        product = new PinkPotion();
        break;
      case purplePotion:
        product = new PurplePotion();
        break;
      case masterBall:
        product = new MasterBall();
        break;
      case pokeBall:
        product = new PokeBall();
        break;
      case ultraBall:
        product = new UltraBall();
        break;
    }
    return product;
  }
}
