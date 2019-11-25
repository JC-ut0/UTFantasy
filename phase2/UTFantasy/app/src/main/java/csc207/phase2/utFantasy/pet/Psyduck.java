package csc207.phase2.utFantasy.pet;

import csc207.phase2.utFantasy.allSkills.HydroPump;
import csc207.phase2.utFantasy.allSkills.Scratch;
import csc207.phase2.utFantasy.R;

public class Psyduck extends Pokemon {
  /** Constructor of a Psyduck. */
  public Psyduck() {
    super();
    setType1("water");
    setPokemonName("Psyduck");
    skills[0] = new Scratch();
    skills[1] = new HydroPump();
    setProfileID(R.drawable.psyduck);
    setBaseHp(50);
    setBaseAttack(58);
    setBaseDefense(48);
    setBaseSpeed(55);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(33);
  }

  /**
   * Get the profile ID of Psyduck.
   *
   * @return an integer which the profile ID of Psyduck.
   */
  @Override
  public int getProfileID() {
    return R.drawable.psyduck;
  }
}
