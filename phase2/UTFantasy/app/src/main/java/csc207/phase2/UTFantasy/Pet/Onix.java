package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Onix extends Pokemon {
  /** Constructor of a Onix. */
  Onix(int level) {
    super(
        level,
        TypeMap.TypeEnum.ROCK,
        TypeMap.TypeEnum.GROUND,
        R.drawable.onix,
        R.drawable.onix_back,
        "Onix",
        35,
        45,
        110,
        70,
        "quick");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Onix.
   *
   * @return an integer which is the profile ID of Onix.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.onix;
  }

  /**
   * Get the profile back ID of Onix.
   *
   * @return an integer which is the profile ID of the back of Onix.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.onix_back;
  }
}
