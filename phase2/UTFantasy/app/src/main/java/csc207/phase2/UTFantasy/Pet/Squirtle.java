package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Tackle;
import csc207.phase2.UTFantasy.R;

public class Squirtle extends Pokemon {
  /** Constructor of a Squirtle. */
  public Squirtle() {
    super();
    setType1("water");
    setPokemonName("Squirtle");
    skills[0] = new Tackle();
    setProfileID(R.drawable.squirtle);
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
   * @return an integer which the profile ID of Squirtle.
   */
  @Override
  public int getProfileID() {
    return R.drawable.squirtle;
  }
}
