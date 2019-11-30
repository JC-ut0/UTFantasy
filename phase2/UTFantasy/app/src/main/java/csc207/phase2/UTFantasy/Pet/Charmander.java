package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Scratch;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Charmander extends Pokemon {
  /** Constructor of a Charmander. */
  public Charmander() {
    super();
    setType1(TypeMap.TypeEnum.FIRE);
    skills[0] = new Scratch();
    setProfileID(R.drawable.charmander);
    setProfileBackID(R.drawable.charmander_back);
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
   * @return an integer which is the profile ID of Charmander.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmander;
  }

  /**
   * Get the profile back ID of Charmander.
   *
   * @return an integer which is the profile ID of the back of Charmander.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmander_back;
  }
}
