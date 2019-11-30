package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Gengar extends Pokemon {
  /** Constructor of a Gengar. */
  public Gengar() {
    super();
    setType1(TypeMap.type.GHOST);
    setType2(TypeMap.type.POISON);
    setProfileID(R.drawable.genger);
    setProfileBackID(R.drawable.gengar_back);
    setPokemonName("Gengar");
    setBaseHp(60);
    setBaseAttack(100);
    setBaseDefense(70);
    setBaseSpeed(110);
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
   * Get the profile ID of Gengar.
   *
   * @return an integer which is the profile ID of Gengar.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.genger;
  }

  /**
   * Get the profile back ID of Gengar.
   *
   * @return an integer which is the profile ID of the back of Gengar.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.gengar_back;
  }
}
