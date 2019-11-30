package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Mew extends Pokemon {
  /** Constructor of a Mew */
  public Mew() {
    super();
    setType1(TypeMap.type.PSYCHIC);
    setProfileID(R.drawable.mew);
    setProfileBackID(R.drawable.mew);
    setPokemonName("Mew");
    setBaseHp(100);
    setBaseAttack(100);
    setBaseDefense(100);
    setBaseSpeed(100);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(1000);
  }
  /**
   * Get the profile ID of Mew.
   *
   * @return an integer which is the profile ID of Mew.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mew;
  }

  /**
   * Get the profile back ID of Mewtwo.
   *
   * @return an integer which is the profile ID of the back of Mewtwo.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mew;
  }
}
