package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Pidgey extends Pokemon {
  /** Constructor of a Pidgey. */
  public Pidgey() {
    super();
      setType1(TypeMap.TypeEnum.NORMAL);
      setType2(TypeMap.TypeEnum.FLYING);
    setProfileID(R.drawable.pidgey);
    setProfileBackID(R.drawable.pidgey_back);
    setPokemonName("Pidgey");
    setBaseHp(40);
    setBaseAttack(40);
    setBaseDefense(35);
    setBaseSpeed(56);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(18);
  }
  /**
   * Get the profile ID of Pidgey.
   *
   * @return an integer which is the profile ID of Pidgey.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgey;
  }

  /**
   * Get the profile back ID of Pidgey.
   *
   * @return an integer which is the profile ID of the back of Pidgey.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgey_back;
  }
}
