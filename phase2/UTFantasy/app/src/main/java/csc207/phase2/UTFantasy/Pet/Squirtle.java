package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Tackle;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Squirtle extends Pokemon {
  /** Constructor of a Squirtle. */
  public Squirtle() {
    super();
    setType1(TypeMap.TypeEnum.WATER);
    setPokemonName("Squirtle");
    skills[0] = new Tackle();
    setProfileID(R.drawable.squirtle);
    setProfileID(R.drawable.squirtle_back);
    setBaseHp(44);
    setBaseAttack(48);
    setBaseDefense(65);
    setBaseSpeed(43);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(16);
  }

  /**
   * Get the profile ID of Squirtle.
   *
   * @return an integer which is the profile ID of Squirtle.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.squirtle;
  }

  /**
   * Get the profile back ID of Squirtle.
   *
   * @return an integer which is the profile ID of the back of Squirtle.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.squirtle_back;
  }
}
