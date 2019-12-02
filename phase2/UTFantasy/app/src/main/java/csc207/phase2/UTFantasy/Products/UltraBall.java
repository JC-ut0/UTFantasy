package csc207.phase2.UTFantasy.Products;

import csc207.phase2.UTFantasy.R;

public class UltraBall extends Ball {
  UltraBall() {
    super("Ultra Ball", 2000, R.drawable.ultraball, 0.5);
  }

  @Override
  public String toString() {
    return "This is an Ultra Ball which can catch pokemon with 50%";
  }
}
