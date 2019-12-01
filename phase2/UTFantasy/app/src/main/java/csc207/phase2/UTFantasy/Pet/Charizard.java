package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.DragonRage;
import csc207.phase2.UTFantasy.AllSkills.Flamethrower;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Charizard extends Pokemon {
  /** Constructor of a Charizard. */
  Charizard(int level) {
      super(
              level,
              TypeMap.TypeEnum.FIRE,
              TypeMap.TypeEnum.FLYING,
              R.drawable.charizard,
              R.drawable.charizard_back,
              "Charizard",
              78,
              97,
              82,
              100,
              "slow",
              1000);
    skills[0] = new Flamethrower();
    skills[1] = new DragonRage();
  }

  /**
   * Get the profile ID of Charizard.
   *
   * @return an integer which is the profile ID of Charizard.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charizard;
  }

  /**
   * Get the profile back ID of Charizard.
   *
   * @return an integer which is the profile ID of the back of Charizard.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charizard_back;
  }
}
