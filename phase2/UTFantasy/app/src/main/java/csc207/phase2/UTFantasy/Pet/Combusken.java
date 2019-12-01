package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Combusken extends Pokemon {
  /** Constructor of a Combusken. */
  Combusken(int level) {
      super(
              level,
              TypeMap.TypeEnum.STEEL,
              TypeMap.TypeEnum.PSYCHIC,
              R.drawable.combusken,
              R.drawable.combusken_back,
              "Combusken",
              60,
              85,
              60,
              55,
              "quick");
    setLevelToEvolve(36, new Blaziken(36));
  }
  /**
   * Get the profile ID of Combusken.
   *
   * @return an integer which is the profile ID of Combusken.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.combusken;
  }

  /**
   * Get the profile back ID of Combusken.
   *
   * @return an integer which is the profile ID of the back of Combusken.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.combusken_back;
  }
}
