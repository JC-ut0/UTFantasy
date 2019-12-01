package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Blaziken extends Pokemon {
  /** Constructor of a Blaziken. */
  Blaziken(int level) {
    super(
            level,
            TypeMap.TypeEnum.FIRE,
            TypeMap.TypeEnum.FIGHT,
            R.drawable.blaziken,
            R.drawable.blaziken_back,
            "Blaziken",
            80,
            105,
            70,
            80,
            "slow",
            1000);
  }
  /**
   * Get the profile ID of Blaziken.
   *
   * @return an integer which is the profile ID of Blaziken.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blaziken;
  }

  /**
   * Get the profile back ID of Blaziken.
   *
   * @return an integer which is the profile ID of the back of Blaziken.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blaziken_back;
  }
}
