package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Dratini extends Pokemon {
  /** Constructor of a Dratini. */
  Dratini(int level) {
    super(
        level,
        TypeMap.TypeEnum.DRAGON,
        null,
        R.drawable.dratini,
        R.drawable.dratini_back,
        "Dratini",
        41,
        57,
        48,
        50,
        "quick");
    setLevelToEvolve(30, new Dragonair(30));
  }
  /**
   * Get the profile ID of Dratini.
   *
   * @return an integer which is the profile ID of Dratini.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dratini;
  }

  /**
   * Get the profile back ID of Dratini.
   *
   * @return an integer which is the profile ID of the back of Dratini.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dratini_back;
  }
}
