package csc207.phase2.utFantasy.products;

import androidx.annotation.NonNull;

import csc207.phase2.utFantasy.R;

public class PurplePotion extends Product {
  /** static variable single_instance of PurplePotion */
  private static PurplePotion purple;

  /** private constructor restricted to this class itself */
  private PurplePotion() {
    super("Potion", 100, R.drawable.purple);
  }

  /**
   * static method to create instance of Singleton class
   *
   * @return a PurplePotion
   */
  public static PurplePotion getPurple() {
    if (purple == null) {
      purple = new PurplePotion();
    }
    return purple;
  }

  @Override
  @NonNull
  public String toString() {
    return "This is a potion, it can restore 30 hp.";
  }
}
