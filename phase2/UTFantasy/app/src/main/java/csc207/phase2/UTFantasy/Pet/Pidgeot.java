package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Pidgeot extends Pokemon {
  /** Constructor of a Pidgeot. */
  public Pidgeot() {
    super();
    setType1(TypeMap.type.NORMAL);
    setType2(TypeMap.type.FLYING);
    setProfileID(R.drawable.pidgeot);
    setProfileBackID(R.drawable.pidgeot_back);
    setPokemonName("Pidgeot");
    setBaseHp(83);
    setBaseAttack(75);
    setBaseDefense(75);
    setBaseSpeed(101);
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
   * Get the profile ID of Pidgeot.
   *
   * @return an integer which is the profile ID of Pidgeot.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeot;
  }

  /**
   * Get the profile back ID of Pidgeot.
   *
   * @return an integer which is the profile ID of the back of Pidgeot.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeot_back;
  }
}
