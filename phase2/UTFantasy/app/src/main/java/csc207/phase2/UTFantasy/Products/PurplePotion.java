package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class PurplePotion extends Potion {

  /** Constructor of PurplePotion */
  PurplePotion() {
    super("Potion", 100, R.drawable.purple, 30);
  }

  @Override
  @NonNull
  public String toString() {
    return "This is a potion, it can restore 30 hp.";
  }
}
