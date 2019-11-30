package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Mewtwo extends Pokemon {
  /** Constructor of a Mewtwo. */
  public Mewtwo() {
    super();
      setType1(TypeMap.TypeEnum.PSYCHIC);
    setProfileID(R.drawable.mewtwo);
    setProfileBackID(R.drawable.mewtwo);
    setPokemonName("Mewtwo");
    setBaseHp(106);
    setBaseAttack(134);
    setBaseDefense(90);
    setBaseSpeed(130);
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
   * Get the profile ID of Mewtwo.
   *
   * @return an integer which is the profile ID of Mewtwo.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mewtwo;
  }

  /**
   * Get the profile back ID of Mewtwo.
   *
   * @return an integer which is the profile ID of the back of Mewtwo.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mewtwo;
  }
}
