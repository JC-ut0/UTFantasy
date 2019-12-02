package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Pidgey extends Pokemon {
  /** Constructor of a Pidgey. */
  Pidgey(int level) {
    super(
        level,
        TypeMap.TypeEnum.NORMAL,
        TypeMap.TypeEnum.FLYING,
        R.drawable.pidgey,
        R.drawable.pidgey_back,
        "Pidgey",
        40,
        40,
        35,
        56,
        "quick");
    setLevelToEvolve(18, new Pidgeotto(18));
  }
  /**
   * Get the profile ID of Pidgey.
   *
   * @return an integer which is the profile ID of Pidgey.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgey;
  }

  /**
   * Get the profile back ID of Pidgey.
   *
   * @return an integer which is the profile ID of the back of Pidgey.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgey_back;
  }
}
