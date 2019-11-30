package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Onix extends Pokemon {
  /** Constructor of a Onix. */
  public Onix() {
    super();
    setType1(TypeMap.type.ROCK);
    setType2(TypeMap.type.GROUND);
    setProfileID(R.drawable.onix);
    setProfileBackID(R.drawable.onix_back);
    setPokemonName("Onix");
    setBaseHp(35);
    setBaseAttack(45);
    setBaseDefense(110);
    setBaseSpeed(70);
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
   * Get the profile ID of Onix.
   *
   * @return an integer which is the profile ID of Onix.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.onix;
  }

  /**
   * Get the profile back ID of Onix.
   *
   * @return an integer which is the profile ID of the back of Onix.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.onix_back;
  }
}
