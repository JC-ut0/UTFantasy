package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Beldum extends Pokemon {
  /** Constructor of a Beldum. */
  Beldum(int level) {
      super(
              level,
              TypeMap.TypeEnum.STEEL,
              TypeMap.TypeEnum.PSYCHIC,
              R.drawable.beldum,
              R.drawable.beldum_back,
              "Beldum",
              40,
              45,
              70,
              30,
              "quick");
    setLevelToEvolve(20, new Metang(20));
  }
  /**
   * Get the profile ID of Beldum.
   *
   * @return an integer which is the profile ID of Beldum.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.beldum;
  }

  /**
   * Get the profile back ID of
   *
   * @return an integer which is the profile ID of the back of Beldum.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.beldum_back;
  }
}
