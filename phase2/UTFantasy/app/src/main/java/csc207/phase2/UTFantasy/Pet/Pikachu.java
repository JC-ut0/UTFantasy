package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.QuickAttack;
import csc207.phase2.UTFantasy.AllSkills.Thunder;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Pikachu extends Pokemon {
  /** Constructor of a Pikachu. */
  public Pikachu() {
    // set its first skill to be QuickAttack
    super();
      setType1(TypeMap.type.ELECTRIC);
    skills[0] = new QuickAttack();
    skills[1] = new Thunder();
    setProfileID(R.drawable.pikachu1);
    setPokemonName("Pikachu");
    setBaseHp(35);
    setBaseAttack(55);
    setBaseDefense(30);
    setBaseSpeed(90);
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setHp(calculateStatistic("hp"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
  }

  /**
   * Get the profile ID of Pikachu.
   *
   * @return an integer which the profile ID of Pikachu.
   */
  @Override
  public int getProfileID() {
      // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pikachu1;
  }
}
