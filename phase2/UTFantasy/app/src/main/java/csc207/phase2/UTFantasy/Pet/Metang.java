package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Metang extends Pokemon {
  /** Constructor of a Metang. */
  Metang(int level) {
    super(
            level,
            TypeMap.TypeEnum.STEEL,
            TypeMap.TypeEnum.PSYCHIC,
            R.drawable.metang,
            R.drawable.metang_back,
            "Metang",
            60,
            65,
            90,
            50,
            "slow",
            45);
  }
  /**
   * Get the profile ID of Metang.
   *
   * @return an integer which is the profile ID of Metang.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metang;
  }

  /**
   * Get the profile back ID of Metang.
   *
   * @return an integer which is the profile ID of the back of Metang.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metang_back;
  }
}
