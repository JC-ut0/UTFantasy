package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Metagross extends Pokemon {
  /** Constructor of a Metagross. */
  Metagross(int level) {
    super(
        level,
        TypeMap.TypeEnum.STEEL,
        TypeMap.TypeEnum.PSYCHIC,
        R.drawable.metagross,
        R.drawable.metagross_back,
        "Metagross",
        80,
        115,
        110,
        70,
        "slow");
    setLevelToEvolve(maxLevel, null);
  }
  /**
   * Get the profile ID of Metagross.
   *
   * @return an integer which is the profile ID of Metagross.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metagross;
  }

  /**
   * Get the profile back ID of
   *
   * @return an integer which is the profile ID of the back of
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metagross_back;
  }
}
