package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Gastly extends Pokemon {
  /** Constructor of a Gastly. */
  Gastly(int level) {
    super(
        level,
        TypeMap.TypeEnum.GHOST,
        TypeMap.TypeEnum.POISON,
        R.drawable.gastly,
        R.drawable.gastly_back,
        "Gastly",
        30,
        65,
        30,
        80,
        "quick");
    setLevelToEvolve(25, new Haunter(25));
  }
  /**
   * Get the profile ID of Gastly.
   *
   * @return an integer which is the profile ID of Gastly.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.gastly;
  }

  /**
   * Get the profile back ID of Gastly.
   *
   * @return an integer which is the profile ID of the back of Gastly.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.gastly_back;
  }
}
