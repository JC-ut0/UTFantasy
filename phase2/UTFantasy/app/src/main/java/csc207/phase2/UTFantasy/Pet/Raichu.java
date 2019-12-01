package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Raichu extends Pokemon {
  /** Constructor of a Raichu. */
  Raichu(int level) {
      super(
              level,
              TypeMap.TypeEnum.ELECTRIC,
              null,
              R.drawable.raichu,
              R.drawable.raichu_back,
              "Raichu",
              60,
              90,
              67,
              110,
              "slow",
              1000);
  }
  /**
   * Get the profile ID of Raichu.
   *
   * @return an integer which is the profile ID of Raichu.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.raichu;
  }

  /**
   * Get the profile back ID of Raichu.
   *
   * @return an integer which is the profile ID of the back of Raichu.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.raichu_back;
  }
}
