package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Alakazam extends Pokemon {
  /** Constructor of a Alakazam. */
  public Alakazam() {
    super();
    setType1(TypeMap.type.PSYCHIC);
    setProfileID(R.drawable.alakazam);
    setProfileBackID(R.drawable.alakazam_back);
    setPokemonName("Alakazam");
    setBaseHp(55);
    setBaseAttack(110);
    setBaseDefense(75);
    setBaseSpeed(120);
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
   * Get the profile ID of Alakazam.
   *
   * @return an integer which is the profile ID of Alakazam.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.alakazam;
  }

  /**
   * Get the profile back ID of Alakazam.
   *
   * @return an integer which is the profile ID of the back of Alakazam.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.alakazam_back;
  }
}
