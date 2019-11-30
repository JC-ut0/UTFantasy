package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Grovyle extends Pokemon {
  /** Constructor of a Grovyle. */
  public Grovyle() {
    super();
    setType1(TypeMap.type.GRASS);
    setProfileID(R.drawable.grovyle);
    setProfileBackID(R.drawable.grovyle_back);
    setPokemonName("Grovyle");
    setBaseHp(50);
    setBaseAttack(75);
    setBaseDefense(55);
    setBaseSpeed(95);
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
   * Get the profile ID of Grovyle.
   *
   * @return an integer which is the profile ID of Grovyle.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.grovyle;
  }

  /**
   * Get the profile back ID of Grovyle.
   *
   * @return an integer which is the profile ID of the back of Grovyle.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.grovyle_back;
  }
}
