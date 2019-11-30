package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Ivysaur extends Pokemon {
  /** Constructor of a Ivysaur. */
  public Ivysaur() {
    super();
    setType1(TypeMap.type.GRASS);
    setType2(TypeMap.type.POISON);
    setProfileID(R.drawable.ivysaur);
    setProfileBackID(R.drawable.ivysaur_back);
    setPokemonName("Ivysaur");
    setBaseHp(60);
    setBaseAttack(71);
    setBaseDefense(72);
    setBaseSpeed(60);
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
   * Get the profile ID of Ivysaur.
   *
   * @return an integer which is the profile ID of Ivysaur.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.ivysaur;
  }

  /**
   * Get the profile back ID of Ivysaur.
   *
   * @return an integer which is the profile ID of the back of Ivysaur.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.ivysaur_back;
  }
}
