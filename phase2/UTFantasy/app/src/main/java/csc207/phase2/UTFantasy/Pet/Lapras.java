package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Lapras extends Pokemon {
  /** Constructor of a Lapras. */
  public Lapras() {
    super();
      setType1(TypeMap.TypeEnum.WATER);
      setType2(TypeMap.TypeEnum.ICE);
    setProfileID(R.drawable.lapras);
    setProfileBackID(R.drawable.lapras_back);
    setPokemonName("Lapras");
    setBaseHp(130);
    setBaseAttack(85);
    setBaseDefense(90);
    setBaseSpeed(60);
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
   * Get the profile ID of Lapras.
   *
   * @return an integer which is the profile ID of Lapras.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.lapras;
  }

  /**
   * Get the profile back ID of Lapras.
   *
   * @return an integer which is the profile ID of the back of Lapras.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.lapras_back;
  }
}
