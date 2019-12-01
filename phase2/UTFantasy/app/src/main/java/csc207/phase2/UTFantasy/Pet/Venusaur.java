package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Venusaur extends Pokemon {
  /** Constructor of a Venusaur. */
  Venusaur(int level) {
      super(
              level,
              TypeMap.TypeEnum.GRASS,
              TypeMap.TypeEnum.POISON,
              R.drawable.venusaur,
              R.drawable.venusaur_back,
              "Venusaur",
              80,
              91,
              92,
              80,
              "slow");
    setLevelToEvolve(maxLevel, null);
  }

  /**
   * Get the profile ID of Venusaur.
   *
   * @return an integer which is the profile ID of Venusaur.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.venusaur;
  }

  /**
   * Get the profile back ID of Venusaur.
   *
   * @return an integer which is the profile ID of the back of Venusaur.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.venusaur_back;
  }
}
