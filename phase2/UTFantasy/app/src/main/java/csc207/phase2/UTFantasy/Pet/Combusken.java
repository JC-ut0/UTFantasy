package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Combusken extends Pokemon {
  /** Constructor of a Combusken. */
  public Combusken() {
    super();
      setType1(TypeMap.TypeEnum.FIRE);
      setType2(TypeMap.TypeEnum.FIGHT);
    setProfileID(R.drawable.combusken);
    setProfileBackID(R.drawable.combusken_back);
    setPokemonName("Combusken");
    setBaseHp(60);
    setBaseAttack(85);
    setBaseDefense(60);
    setBaseSpeed(55);
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
   * Get the profile ID of Combusken.
   *
   * @return an integer which is the profile ID of Combusken.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.combusken;
  }

  /**
   * Get the profile back ID of Combusken.
   *
   * @return an integer which is the profile ID of the back of Combusken.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.combusken_back;
  }
}
