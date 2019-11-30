package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Wartortle extends Pokemon {
  /** Constructor of a Wartortle. */
  public Wartortle() {
    super();
    setType1(TypeMap.type.WATER);
    setProfileID(R.drawable.wartortle);
    setProfileBackID(R.drawable.wartortle_back);
    setPokemonName("Wartortle");
    setBaseHp(59);
    setBaseAttack(64);
    setBaseDefense(80);
    setBaseSpeed(58);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(36);
  }

  /**
   * Get the profile ID of Wartortle.
   *
   * @return an integer which is the profile ID of Wartotle.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.wartortle;
  }

  /**
   * Get the profile back ID of Wartortle.
   *
   * @return an integer which is the profile ID of the back of Wartortle.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.wartortle_back;
  }
}
