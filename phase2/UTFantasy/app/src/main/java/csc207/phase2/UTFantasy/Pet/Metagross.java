package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Metagross extends Pokemon {
  /** Constructor of a Metagross. */
  public Metagross() {
    super();
    setType1(TypeMap.type.STEEL);
    setType1(TypeMap.type.PSYCHIC);
    setProfileID(R.drawable.metagross);
    setProfileBackID(R.drawable.metagross_back);
    setPokemonName("Metagross");
    setBaseHp(80);
    setBaseAttack(115);
    setBaseDefense(110);
    setBaseSpeed(70);
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
   * Get the profile ID of Metagross.
   *
   * @return an integer which is the profile ID of Metagross.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metagross;
  }

  /**
   * Get the profile back ID of
   *
   * @return an integer which is the profile ID of the back of
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.metagross_back;
  }
}
