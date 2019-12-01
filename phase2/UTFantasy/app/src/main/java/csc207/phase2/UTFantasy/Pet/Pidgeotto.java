package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Pidgeotto extends Pokemon {
  /** Constructor of a Pidgeotto. */
  Pidgeotto(int level) {
      super(
              level,
              TypeMap.TypeEnum.NORMAL,
              TypeMap.TypeEnum.FLYING,
              R.drawable.pidgeotto,
              R.drawable.pidgeotto_back,
              "Pidgeotto",
              63,
              55,
              50,
              71,
              "quick");
    setLevelToEvolve(36, new Pidgeot(36));
  }
  /**
   * Get the profile ID of Pidgeotto.
   *
   * @return an integer which is the profile ID of Pidgeotto.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeotto;
  }

  /**
   * Get the profile back ID of Pidgeotto.
   *
   * @return an integer which is the profile ID of the back of Pidgeotto.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeotto_back;
  }
}
