package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Golduck extends Pokemon {
  /** Constructor of a Golduck. */
  Golduck(int level) {
      super(
              level,
              TypeMap.TypeEnum.WATER,
              null,
              R.drawable.golduck,
              R.drawable.golduck_back,
              "Golduck",
              80,
              88,
              79,
              85,
              "slow");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Golduck.
   *
   * @return an integer which is the profile ID of Golduck.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.golduck;
  }

  /**
   * Get the profile back ID of Golduck.
   *
   * @return an integer which is the profile ID of the back of Golduck.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.golduck_back;
  }
}
