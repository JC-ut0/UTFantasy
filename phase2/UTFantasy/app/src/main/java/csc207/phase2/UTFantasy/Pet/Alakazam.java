package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Alakazam extends Pokemon {
  /** Constructor of a Alakazam. */
  Alakazam(int level) {
    super(
        level,
        TypeMap.TypeEnum.PSYCHIC,
        null,
        R.drawable.alakazam,
        R.drawable.alakazam_back,
        "Alakazam",
        55,
        110,
        75,
        120,
        "slow");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Alakazam.
   *
   * @return an integer which is the profile ID of Alakazam.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.alakazam;
  }

  /**
   * Get the profile back ID of Alakazam.
   *
   * @return an integer which is the profile ID of the back of Alakazam.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.alakazam_back;
  }
}
