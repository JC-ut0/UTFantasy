package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Dragonair extends Pokemon {
  /** Constructor of a Dragonair. */
  Dragonair(int level) {
      super(
              level,
              TypeMap.TypeEnum.DRAGON,
              null,
              R.drawable.dragonair,
              R.drawable.dragonair_back,
              "Dragonair",
              61,
              77,
              68,
              70,
              "slow",
              55);
  }
  /**
   * Get the profile ID of Dragonair.
   *
   * @return an integer which is the profile ID of Dragonair.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonair;
  }

  /**
   * Get the profile back ID of Dragonair.
   *
   * @return an integer which is the profile ID of the back of Dragonair.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonair_back;
  }
}
