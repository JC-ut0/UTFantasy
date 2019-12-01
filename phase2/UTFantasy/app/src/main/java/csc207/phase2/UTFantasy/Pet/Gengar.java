package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Gengar extends Pokemon {
  /** Constructor of a Gengar. */
  Gengar(int level) {
    super(
            level,
            TypeMap.TypeEnum.GHOST,
            TypeMap.TypeEnum.POISON,
            R.drawable.genger,
            R.drawable.gengar_back,
            "Gengar",
            60,
            100,
            70,
            110,
            "slow");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Gengar.
   *
   * @return an integer which is the profile ID of Gengar.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.genger;
  }

  /**
   * Get the profile back ID of Gengar.
   *
   * @return an integer which is the profile ID of the back of Gengar.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.gengar_back;
  }
}
