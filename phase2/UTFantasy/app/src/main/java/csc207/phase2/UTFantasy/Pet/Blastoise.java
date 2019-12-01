package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Blastoise extends Pokemon {
  /** Constructor of a Blastoise. */
  Blastoise(int level) {
      super(
              level,
              TypeMap.TypeEnum.WATER,
              null,
              R.drawable.blastoise,
              R.drawable.blastoise_back,
              "Blastoise",
              79,
              85,
              105,
              78,
              "slow",
              1000);
  }
  /**
   * Get the profile ID of Blastoise.
   *
   * @return an integer which is the profile ID of Blastoise.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blastoise;
  }

  /**
   * Get the profile back ID of Blastoise.
   *
   * @return an integer which is the profile ID of the back of Blastoise.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blastoise_back;
  }
}
