package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Ivysaur extends Pokemon {
  /** Constructor of a Ivysaur. */
  Ivysaur(int level) {
    super(
        level,
        TypeMap.TypeEnum.GRASS,
        TypeMap.TypeEnum.POISON,
        R.drawable.ivysaur,
        R.drawable.ivysaur_back,
        "Ivysaur",
        60,
        71,
        72,
        60,
        "quick");
    setLevelToEvolve(36, new Venusaur(36));
  }
  /**
   * Get the profile ID of Ivysaur.
   *
   * @return an integer which is the profile ID of Ivysaur.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.ivysaur;
  }

  /**
   * Get the profile back ID of Ivysaur.
   *
   * @return an integer which is the profile ID of the back of Ivysaur.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.ivysaur_back;
  }
}
