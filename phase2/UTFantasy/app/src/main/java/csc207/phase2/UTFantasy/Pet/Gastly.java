package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Gastly extends Pokemon {
  /** Constructor of a Gastly. */
  public Gastly() {
    super();
      setType1(TypeMap.TypeEnum.GHOST);
      setType2(TypeMap.TypeEnum.POISON);
    setProfileID(R.drawable.gastly);
    setProfileBackID(R.drawable.gastly_back);
    setPokemonName("Gastly");
    setBaseHp(30);
    setBaseAttack(65);
    setBaseDefense(30);
    setBaseSpeed(80);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(25);
  }
  /**
   * Get the profile ID of Gastly.
   *
   * @return an integer which is the profile ID of Gastly.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.gastly;
  }

  /**
   * Get the profile back ID of Gastly.
   *
   * @return an integer which is the profile ID of the back of Gastly.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.gastly_back;
  }
}
