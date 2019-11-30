package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Venusaur extends Pokemon {
  /** Constructor of a Venusaur. */
  public Venusaur() {
    super();
      setType1(TypeMap.TypeEnum.GRASS);
      setType2(TypeMap.TypeEnum.POISON);
    setProfileID(R.drawable.venusaur);
    setProfileBackID(R.drawable.venusaur_back);
    setPokemonName("Venusaur");
    setBaseHp(80);
    setBaseAttack(91);
    setBaseDefense(92);
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
   * Get the profile ID of Venusaur.
   *
   * @return an integer which is the profile ID of Venusaur.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.venusaur;
  }

  /**
   * Get the profile back ID of Venusaur.
   *
   * @return an integer which is the profile ID of the back of Venusaur.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.venusaur_back;
  }
}
