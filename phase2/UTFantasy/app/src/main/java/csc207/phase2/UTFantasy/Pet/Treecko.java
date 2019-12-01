package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Treecko extends Pokemon {
  /** Constructor of a Treecko. */
  Treecko(int level) {
      super(
              level,
              TypeMap.TypeEnum.GRASS,
              null,
              R.drawable.treecko,
              R.drawable.treecko_back,
              "Treecko",
              40,
              55,
              45,
              70,
              "quick",
              16);
  }
  /**
   * Get the profile ID of Treecko.
   *
   * @return an integer which is the profile ID of Treecko.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.treecko;
  }

  /**
   * Get the profile back ID of Treecko.
   *
   * @return an integer which is the profile ID of the back of Treecko.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.treecko_back;
  }
}
