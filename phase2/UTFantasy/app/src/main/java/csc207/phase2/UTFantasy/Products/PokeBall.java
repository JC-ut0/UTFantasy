package csc207.phase2.UTFantasy.Products;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.R;

public class PokeBall extends Ball {
  PokeBall() {
    super("Poke Ball", 200, R.drawable.pokeball_shop, 0.3);
  }

  @NonNull
  @Override
  public String toString() {
    return "This is a poke ball, it can catch a pokemon with 30%.";
  }
}
