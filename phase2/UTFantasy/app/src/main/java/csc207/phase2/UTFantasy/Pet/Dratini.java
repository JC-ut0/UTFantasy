package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Dratini extends Pokemon {
  /** Constructor of a Dratini. */
  public Dratini() {
    super();
    setType1(TypeMap.type.DRAGON);
    setProfileID(R.drawable.dratini);
    setProfileBackID(R.drawable.dratini_back);
    setPokemonName("Dratini");
    setBaseHp(41);
    setBaseAttack(57);
    setBaseDefense(48);
    setBaseSpeed(50);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(30);
  }
  /**
   * Get the profile ID of Dratini.
   *
   * @return an integer which is the profile ID of Dratini.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dratini;
  }

  /**
   * Get the profile back ID of Dratini.
   *
   * @return an integer which is the profile ID of the back of Dratini.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dratini_back;
  }
}
