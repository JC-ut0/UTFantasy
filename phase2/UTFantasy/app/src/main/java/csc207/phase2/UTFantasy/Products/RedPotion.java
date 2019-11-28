package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class RedPotion extends Potion {
  /** Constructor of RedPotion */
  RedPotion() {
    super("Super Potion", 200, R.drawable.red, 50);
  }


  @Override
  @NonNull
  public String toString() {
    return "This is a super potion, it can restore 50 hp.";
  }
}
