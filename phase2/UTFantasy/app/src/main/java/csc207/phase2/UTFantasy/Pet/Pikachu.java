package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.QuickAttack;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Pikachu extends Pokemon {
  /** Constructor of a Pikachu. */
  public Pikachu() {
    // set its first skill to be QuickAttack
    super();
    setType1(TypeMap.TypeEnum.ELECTRIC);
    skills[0] = new QuickAttack();
    setProfileID(R.drawable.pikachu);
    setProfileBackID(R.drawable.pikachu_back);
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
    setLevelToEvolve(32);
  }

  /**
   * Get the profile ID of Pikachu.
   *
   * @return an integer which is the profile ID of Pikachu.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pikachu;
  }

  /**
   * Get the profile back ID of Pikachu.
   *
   * @return an integer which is the profile ID of the back.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pikachu_back;
  }
}
