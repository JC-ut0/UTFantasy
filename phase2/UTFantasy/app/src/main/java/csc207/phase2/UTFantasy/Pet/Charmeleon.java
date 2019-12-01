package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Ember;
import csc207.phase2.UTFantasy.AllSkills.Flamethrower;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Charmeleon extends Pokemon {
  /** Constructor of a Charmeleon. */
  Charmeleon(int level) {
      super(
              level,
              TypeMap.TypeEnum.FIRE,
              null,
              R.drawable.charmeleon,
              R.drawable.charmeleon_back,
              "Charmeleon",
              58,
              72,
              62,
              80,
              "quick",
              36);
    skills[0] = new Ember();
    skills[1] = new Flamethrower();
  }

  /**
   * Get the profile ID of Charmeleon.
   *
   * @return an integer which is the profile ID of Charmeleon.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmeleon;
  }

  /**
   * Get the profile back ID of Charmeleon.
   *
   * @return an integer which is the profile ID of the back of Charmeleon.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmeleon_back;
  }
}
