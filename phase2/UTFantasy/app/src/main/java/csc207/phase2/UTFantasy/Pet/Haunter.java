package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Haunter extends Pokemon {
  /** Constructor of a Haunter. */
  public Haunter() {
    super();
      setType1(TypeMap.TypeEnum.GHOST);
      setType2(TypeMap.TypeEnum.POISON);
    setProfileID(R.drawable.haunter);
    setProfileBackID(R.drawable.haunter_back);
    setPokemonName("Haunter");
    setBaseHp(45);
    setBaseAttack(75);
    setBaseDefense(50);
    setBaseSpeed(95);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(40);
  }
  /**
   * Get the profile ID of Haunter.
   *
   * @return an integer which is the profile ID of Haunter.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.haunter;
  }

  /**
   * Get the profile back ID of Haunter.
   *
   * @return an integer which is the profile ID of the back of Haunter.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.haunter_back;
  }
}
