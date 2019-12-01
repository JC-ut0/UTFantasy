package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Grovyle extends Pokemon {
  /** Constructor of a Grovyle. */
  Grovyle(int level) {
      super(
              level,
              TypeMap.TypeEnum.GRASS,
              null,
              R.drawable.grovyle,
              R.drawable.grovyle_back,
              "Grovyle",
              50,
              75,
              55,
              95,
              "quick",
              36);
  }
  /**
   * Get the profile ID of Grovyle.
   *
   * @return an integer which is the profile ID of Grovyle.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.grovyle;
  }

  /**
   * Get the profile back ID of Grovyle.
   *
   * @return an integer which is the profile ID of the back of Grovyle.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.grovyle_back;
  }
}
