package csc207.phase2.utFantasy.products;

import csc207.phase2.utFantasy.R;

public class PinkPotion extends Product {

  /** static variable single_instance of PinkPotion */
  private static PinkPotion pink;

  /** private constructor restricted to this class itself */
  private PinkPotion() {
    super("Hyper Potion", 300, R.drawable.pink);
  }

  /**
   * static method to create instance of Singleton class
   *
   * @return a PinkPotion
   */
  public static PinkPotion getPink() {
    if (pink == null) {
      pink = new PinkPotion();
    }
    return pink;
  }

  public String toString() {
    return "This is a hyper potion, it can restore 200 hp.";
  }
}
