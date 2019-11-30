package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Blastoise extends Pokemon {
  /** Constructor of a Blastoise. */
  public Blastoise() {
    super();
    setType1(TypeMap.type.WATER);
    setProfileID(R.drawable.blastoise);
    setProfileBackID(R.drawable.blastoise_back);
    setPokemonName("Blastoise");
    setBaseHp(79);
    setBaseAttack(85);
    setBaseDefense(105);
    setBaseSpeed(78);
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
   * Get the profile ID of Blastoise.
   *
   * @return an integer which is the profile ID of Blastoise.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blastoise;
  }

  /**
   * Get the profile back ID of Blastoise.
   *
   * @return an integer which is the profile ID of the back of Blastoise.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blastoise_back;
  }
}
