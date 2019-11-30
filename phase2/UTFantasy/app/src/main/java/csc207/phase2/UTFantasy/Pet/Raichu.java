package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Raichu extends Pokemon {
  /** Constructor of a Raichu. */
  public Raichu() {
    super();
      setType1(TypeMap.TypeEnum.ELECTRIC);
    setProfileID(R.drawable.raichu);
    setProfileBackID(R.drawable.raichu_back);
    setPokemonName("Raichu");
    setBaseHp(60);
    setBaseAttack(90);
    setBaseDefense(67);
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
   * Get the profile ID of Raichu.
   *
   * @return an integer which is the profile ID of Raichu.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.raichu;
  }

  /**
   * Get the profile back ID of Raichu.
   *
   * @return an integer which is the profile ID of the back of Raichu.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.raichu_back;
  }
}
