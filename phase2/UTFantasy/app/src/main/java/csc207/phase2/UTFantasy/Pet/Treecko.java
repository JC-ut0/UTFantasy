package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Treecko extends Pokemon {
  /** Constructor of a Treecko. */
  public Treecko() {
    super();
    setType1(TypeMap.type.GRASS);
    setProfileID(R.drawable.treecko);
    setProfileBackID(R.drawable.treecko_back);
    setPokemonName("Treecko");
    setBaseHp(40);
    setBaseAttack(55);
    setBaseDefense(45);
    setBaseSpeed(70);
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
   * Get the profile ID of Treecko.
   *
   * @return an integer which is the profile ID of Treecko.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.treecko;
  }

  /**
   * Get the profile back ID of Treecko.
   *
   * @return an integer which is the profile ID of the back of Treecko.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.treecko_back;
  }
}
