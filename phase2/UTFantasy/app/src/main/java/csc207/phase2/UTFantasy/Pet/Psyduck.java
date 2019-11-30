package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.HydroPump;
import csc207.phase2.UTFantasy.AllSkills.Scratch;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Psyduck extends Pokemon {
  /** Constructor of a Psyduck. */
  public Psyduck() {
    super();
    setType1(TypeMap.TypeEnum.WATER);
    setPokemonName("Psyduck");
    skills[0] = new Scratch();
    skills[1] = new HydroPump();
    setProfileID(R.drawable.psyduck);
    setProfileBackID(R.drawable.psyduck_back);
    setBaseHp(50);
    setBaseAttack(58);
    setBaseDefense(48);
    setBaseSpeed(55);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(100);
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(33);
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
