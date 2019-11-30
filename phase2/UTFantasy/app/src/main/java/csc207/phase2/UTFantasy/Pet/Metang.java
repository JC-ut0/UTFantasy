package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Metang extends Pokemon {
  /** Constructor of a Metang. */
  public Metang() {
    super();
    setType1(TypeMap.type.STEEL);
    setType1(TypeMap.type.PSYCHIC);
    setProfileID(R.drawable.metang);
    setProfileBackID(R.drawable.metang_back);
    setPokemonName("Metang");
    setBaseHp(60);
    setBaseAttack(65);
    setBaseDefense(90);
    setBaseSpeed(50);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("slow");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(45);
  }
  /**
   * Get the profile ID of Metang.
   *
   * @return an integer which is the profile ID of Metang.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metang;
  }

  /**
   * Get the profile back ID of Metang.
   *
   * @return an integer which is the profile ID of the back of Metang.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metang_back;
  }
}
