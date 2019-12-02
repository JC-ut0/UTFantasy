package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class UltraBall extends Ball {
  /** Constructor of Ultra Ball. */
  UltraBall() {
    super("Ultra Ball", 2000, R.drawable.ultraball, 0.5);
  }

  @NonNull
  @Override
  public String toString() {
    return "This is an Ultra Ball which can catch pokemon with 50%";
  }
}
