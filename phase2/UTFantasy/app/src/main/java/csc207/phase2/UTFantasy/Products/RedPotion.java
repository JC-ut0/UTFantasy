package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class RedPotion extends Product {
  /** static variable single_instance of RedPotion */
  private static RedPotion red;

  /** private constructor restricted to this class itself */
  private RedPotion() {
    super("Super Potion", 200, R.drawable.red);
  }

  /**
   * static method to create instance of Singleton class
   *
   * @return a RedPotion
   */
  public static RedPotion getRed() {
    if (red == null) {
      red = new RedPotion();
    }
    return red;
  }

  @Override
  @NonNull
  public String toString() {
    return "This is a super potion, it can restore 50 hp.";
  }
}
