package csc207.phase2.utFantasy.pet;

import csc207.phase2.utFantasy.allSkills.Pound;
import csc207.phase2.utFantasy.R;

public class Jigglypuff extends Pokemon {
  /** Constructor of a Jigglypuff. */
  public Jigglypuff() {
    super();
    setType1("normal");
    skills[0] = new Pound();
    setProfileID(R.drawable.jigglypuff);
    setPokemonName("Jigglypuff");
    setBaseHp(115);
    setBaseAttack(45);
    setBaseDefense(25);
    setBaseSpeed(20);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
  }

  /**
   * Get the profile ID of Jigglypuff.
   *
   * @return an integer which the profile ID of Jigglypuff.
   */
  @Override
  public int getProfileID() {
    return R.drawable.jigglypuff;
  }
}
