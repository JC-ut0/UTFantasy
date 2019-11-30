package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Golduck extends Pokemon {
  /** Constructor of a Golduck. */
  public Golduck() {
    super();
    setType1(TypeMap.type.WATER);
    setProfileID(R.drawable.golduck);
    setProfileBackID(R.drawable.golduck_back);
    setPokemonName("Golduck");
    setBaseHp(80);
    setBaseAttack(88);
    setBaseDefense(79);
    setBaseSpeed(85);
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
   * Get the profile ID of Golduck.
   *
   * @return an integer which is the profile ID of Golduck.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.golduck;
  }

  /**
   * Get the profile back ID of Golduck.
   *
   * @return an integer which is the profile ID of the back of Golduck.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.golduck_back;
  }
}
