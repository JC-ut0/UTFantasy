package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

class PinkPotion extends Potion {
  /** constructor of PinkPotion */
  PinkPotion() {
    super("Hyper Potion", 1000, R.drawable.pink, 100);
  }

  @Override
  @NonNull
  public String toString() {
    return "This is a hyper potion, it can restore 100 hp.";
  }
}
