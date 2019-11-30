package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Kadabra extends Pokemon {
  /** Constructor of a Kadabra. */
  public Kadabra() {
    super();
    setType1(TypeMap.type.PSYCHIC);
    setProfileID(R.drawable.kadabra);
    setProfileBackID(R.drawable.kadabra_back);
    setPokemonName("Kadabra");
    setBaseHp(40);
    setBaseAttack(80);
    setBaseDefense(50);
    setBaseSpeed(105);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(40);
  }
  /**
   * Get the profile ID of Kadabra.
   *
   * @return an integer which is the profile ID of Kadabra.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.kadabra;
  }

  /**
   * Get the profile back ID of Kadabra.
   *
   * @return an integer which is the profile ID of the back of Kadabra.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.kadabra_back;
  }
}
