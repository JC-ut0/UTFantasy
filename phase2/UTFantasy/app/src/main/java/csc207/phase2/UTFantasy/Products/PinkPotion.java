package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class PinkPotion extends Potion {
  /** constructor of PinkPotion */
  PinkPotion() {
    super("Hyper Potion", 300, R.drawable.pink, 200);
  }

  @Override
  @NonNull
  public String toString() {
    return "This is a hyper potion, it can restore 200 hp.";
  }
}
