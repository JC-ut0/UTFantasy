package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Dragonite extends Pokemon {
  /** Constructor of a Dragonite */
  Dragonite(int level) {
      super(
              level,
              TypeMap.TypeEnum.DRAGON,
              TypeMap.TypeEnum.FLYING,
              R.drawable.dragonite,
              R.drawable.dragonite_back,
              "Dragonite",
              91,
              117,
              98,
              80,
              "slow",
              1000);
  }
  /**
   * Get the profile ID of Dragonite.
   *
   * @return an integer which is the profile ID of Dragonite.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonite;
  }

  /**
   * Get the profile back ID of Dragonite.
   *
   * @return an integer which is the profile ID of the back of Dragonite.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonite_back;
  }
}
