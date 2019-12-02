package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Sceptile extends Pokemon {
  /** Constructor of a Sceptile. */
  Sceptile(int level) {
    super(
        level,
        TypeMap.TypeEnum.GRASS,
        null,
        R.drawable.sceptile,
        R.drawable.sceptile_back,
        "Sceptile",
        70,
        95,
        75,
        120,
        "slow");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Sceptile.
   *
   * @return an integer which is the profile ID of Sceptile.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.sceptile;
  }

  /**
   * Get the profile back ID of Sceptile.
   *
   * @return an integer which is the profile ID of the back of Sceptile.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.sceptile_back;
  }
}
