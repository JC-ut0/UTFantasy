package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Lapras extends Pokemon {
  /** Constructor of a Lapras. */
  Lapras(int level) {
    super(
        level,
        TypeMap.TypeEnum.WATER,
        TypeMap.TypeEnum.ICE,
        R.drawable.lapras,
        R.drawable.lapras_back,
        "Lapras",
        130,
        85,
        90,
        60,
        "quick");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Lapras.
   *
   * @return an integer which is the profile ID of Lapras.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.lapras;
  }

  /**
   * Get the profile back ID of Lapras.
   *
   * @return an integer which is the profile ID of the back of Lapras.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.lapras_back;
  }
}
