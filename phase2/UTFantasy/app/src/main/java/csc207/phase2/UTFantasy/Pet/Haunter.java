package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Haunter extends Pokemon {
  /** Constructor of a Haunter. */
  Haunter(int level) {
    super(
        level,
        TypeMap.TypeEnum.GHOST,
        TypeMap.TypeEnum.POISON,
        R.drawable.haunter,
        R.drawable.haunter_back,
        "Haunter",
        45,
        75,
        50,
        95,
        "quick");
    setLevelToEvolve(40, new Gengar(40));
  }
  /**
   * Get the profile ID of Haunter.
   *
   * @return an integer which is the profile ID of Haunter.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.haunter;
  }

  /**
   * Get the profile back ID of Haunter.
   *
   * @return an integer which is the profile ID of the back of Haunter.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.haunter_back;
  }
}
