package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

class PurplePotion extends Potion {

  /** Constructor of PurplePotion */
  PurplePotion() {
    super("Potion", 200, R.drawable.purple, 10);
  }

  @Override
  @NonNull
  public String toString() {
    return "This is a potion, it can restore 10 hp.";
  }
}
