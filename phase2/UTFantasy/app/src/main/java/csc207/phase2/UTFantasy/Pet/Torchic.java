package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Torchic extends Pokemon {
  /** Constructor of a Torchic. */
  Torchic(int level) {
      super(
              level,
              TypeMap.TypeEnum.FIRE,
              null,
              R.drawable.torchic,
              R.drawable.torchic_back,
              "Torchic",
              45,
              65,
              45,
              45,
              "quick");
    setLevelToEvolve(16, new Combusken(16));
  }
  /**
   * Get the profile ID of Torchic.
   *
   * @return an integer which is the profile ID of Torchic.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.torchic;
  }

  /**
   * Get the profile back ID of Torchic.
   *
   * @return an integer which is the profile ID of the back of Torchic.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.torchic_back;
  }
}
