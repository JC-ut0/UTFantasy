package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Scratch;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Charmander extends Pokemon {
  /** Constructor of a Charmander. */
  public Charmander() {
    super();
      setType1(TypeMap.type.FIRE);
    skills[0] = new Scratch();
    setProfileID(R.drawable.charmander);
    setPokemonName("Charmander");
    setBaseHp(39);
    setBaseAttack(56);
    setBaseDefense(45);
    setBaseSpeed(65);
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
   * Get the profile ID of Charmander.
   *
   * @return an integer which the profile ID of Charmander.
   */
  @Override
  public int getProfileID() {
    return R.drawable.charmander;
  }
}
