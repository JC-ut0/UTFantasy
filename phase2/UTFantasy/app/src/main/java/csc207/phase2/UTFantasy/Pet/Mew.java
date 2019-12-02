package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Mew extends Pokemon {
  /** Constructor of a Mew */
  Mew(int level) {
    super(
        level,
        TypeMap.TypeEnum.PSYCHIC,
        null,
        R.drawable.mew,
        R.drawable.mew,
        "Mew",
        100,
        100,
        100,
        100,
        "quick");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Mew.
   *
   * @return an integer which is the profile ID of Mew.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mew;
  }

  /**
   * Get the profile back ID of Mewtwo.
   *
   * @return an integer which is the profile ID of the back of Mewtwo.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mew;
  }
}
