package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Wartortle extends Pokemon {
  /** Constructor of a Wartortle. */
  Wartortle(int level) {
    super(
        level,
        TypeMap.TypeEnum.WATER,
        null,
        R.drawable.wartortle,
        R.drawable.wartortle_back,
        "Wartortle",
        59,
        64,
        80,
        58,
        "quick");
    setLevelToEvolve(36, new Blastoise(36));
  }

  /**
   * Get the profile ID of Wartortle.
   *
   * @return an integer which is the profile ID of Wartotle.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.wartortle;
  }

  /**
   * Get the profile back ID of Wartortle.
   *
   * @return an integer which is the profile ID of the back of Wartortle.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.wartortle_back;
  }
}
