package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Pidgeot extends Pokemon {
  /** Constructor of a Pidgeot. */
  Pidgeot(int level) {
      super(
              level,
              TypeMap.TypeEnum.NORMAL,
              TypeMap.TypeEnum.FLYING,
              R.drawable.pidgeot,
              R.drawable.pidgeot_back,
              "Pidgeot",
              83,
              75,
              75,
              101,
              "slow");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Pidgeot.
   *
   * @return an integer which is the profile ID of Pidgeot.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeot;
  }

  /**
   * Get the profile back ID of Pidgeot.
   *
   * @return an integer which is the profile ID of the back of Pidgeot.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeot_back;
  }
}
