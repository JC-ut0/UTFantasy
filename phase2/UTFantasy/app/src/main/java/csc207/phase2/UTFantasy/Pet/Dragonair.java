package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Dragonair extends Pokemon {
  /** Constructor of a Dragonair. */
  public Dragonair() {
    super();
    setType1(TypeMap.type.DRAGON);
    setProfileID(R.drawable.dragonair);
    setProfileBackID(R.drawable.dragonair_back);
    setPokemonName("Dragonair");
    setBaseHp(61);
    setBaseAttack(77);
    setBaseDefense(68);
    setBaseSpeed(70);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("slow");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(55);
  }
  /**
   * Get the profile ID of Dragonair.
   *
   * @return an integer which is the profile ID of Dragonair.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonair;
  }

  /**
   * Get the profile back ID of Dragonair.
   *
   * @return an integer which is the profile ID of the back of Dragonair.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonair_back;
  }
}
