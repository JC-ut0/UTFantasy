package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Blaziken extends Pokemon {
  /** Constructor of a Blaziken. */
  public Blaziken() {
    super();
      setType1(TypeMap.TypeEnum.FIRE);
      setType2(TypeMap.TypeEnum.FIGHT);
    setProfileID(R.drawable.blaziken);
    setProfileBackID(R.drawable.blaziken_back);
    setPokemonName("Blaziken");
    setBaseHp(80);
    setBaseAttack(105);
    setBaseDefense(70);
    setBaseSpeed(80);
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
   * Get the profile ID of Blaziken.
   *
   * @return an integer which is the profile ID of Blaziken.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blaziken;
  }

  /**
   * Get the profile back ID of Blaziken.
   *
   * @return an integer which is the profile ID of the back of Blaziken.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blaziken_back;
  }
}
