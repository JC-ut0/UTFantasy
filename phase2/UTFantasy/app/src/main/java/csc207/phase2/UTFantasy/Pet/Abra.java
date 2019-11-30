package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Abra extends Pokemon {
  /** Constructor of a Abra. */
  public Abra() {
    super();
    setType1(TypeMap.TypeEnum.PSYCHIC);
    setProfileID(R.drawable.abra);
    setProfileBackID(R.drawable.abra_back);
    setPokemonName("Abra");
    setBaseHp(25);
    setBaseAttack(65);
    setBaseDefense(35);
    setBaseSpeed(90);
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
   * Get the profile ID of Abra.
   *
   * @return an integer which is the profile ID of Abra.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.abra;
  }

  /**
   * Get the profile back ID of Abra.
   *
   * @return an integer which is the profile ID of the back of Abra.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.abra_back;
  }
}
