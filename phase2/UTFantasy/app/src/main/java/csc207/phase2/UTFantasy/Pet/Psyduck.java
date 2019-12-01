package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.HydroPump;
import csc207.phase2.UTFantasy.AllSkills.Scratch;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Psyduck extends Pokemon {
  /** Constructor of a Psyduck. */
  Psyduck(int level) {
      super(
              level,
              TypeMap.TypeEnum.WATER,
              null,
              R.drawable.psyduck,
              R.drawable.psyduck_back,
              "Psyduck",
              50,
              58,
              48,
              55,
              "quick",
              33);
    skills[0] = new Scratch();
    skills[1] = new HydroPump();
    setExpToLevelUp(100);
  }

  /**
   * Get the profile ID of Psyduck.
   *
   * @return an integer which is the profile ID of Psyduck.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.psyduck;
  }

  /**
   * Get the profile back ID of Psyduck.
   *
   * @return an integer which is the profile ID of the back of Psyduck.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.psyduck_back;
  }
}
