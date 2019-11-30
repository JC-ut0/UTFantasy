package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Dragonite extends Pokemon {
  /** Constructor of a Dragonite */
  public Dragonite() {
    super();
    setType1(TypeMap.type.DRAGON);
    setType1(TypeMap.type.FLYING);
    setProfileID(R.drawable.dragonite);
    setProfileBackID(R.drawable.dragonite_back);
    setPokemonName("Dragonite");
    setBaseHp(91);
    setBaseAttack(117);
    setBaseDefense(98);
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
   * Get the profile ID of Dragonite.
   *
   * @return an integer which is the profile ID of Dragonite.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonite;
  }

  /**
   * Get the profile back ID of Dragonite.
   *
   * @return an integer which is the profile ID of the back of Dragonite.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.dragonite_back;
  }
}
