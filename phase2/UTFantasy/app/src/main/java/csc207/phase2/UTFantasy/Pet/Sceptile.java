package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Sceptile extends Pokemon {
  /** Constructor of a Sceptile.*/
  public Sceptile() {
    super();
      setType1(TypeMap.TypeEnum.GRASS);
    setProfileID(R.drawable.sceptile);
    setProfileBackID(R.drawable.sceptile_back);
    setPokemonName("Sceptile");
    setBaseHp(70);
    setBaseAttack(95);
    setBaseDefense(75);
    setBaseSpeed(120);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("slow");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(1000);
  }
  /**
   * Get the profile ID of Sceptile.
   *
   * @return an integer which is the profile ID of Sceptile.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.sceptile;
  }

  /**
   * Get the profile back ID of Sceptile.
   *
   * @return an integer which is the profile ID of the back of Sceptile.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.sceptile_back;
  }
}
