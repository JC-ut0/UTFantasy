package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Abra extends Pokemon {
  /** Constructor of a Abra. */
  public Abra(int level) {
    super(
            level,
            TypeMap.TypeEnum.PSYCHIC,
            null,
            R.drawable.abra,
            R.drawable.abra_back,
            "Abra",
            25,
            65,
            35,
            90,
            "quick",
            16);
  }
  /**
   * Get the profile ID of Abra.
   *
   * @return an integer which is the profile ID of Abra.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.abra;
  }

  /**
   * Get the profile back ID of Abra.
   *
   * @return an integer which is the profile ID of the back of Abra.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.abra_back;
  }
}
