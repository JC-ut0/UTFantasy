package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Beldum extends Pokemon {
  /** Constructor of a Beldum. */
  public Beldum() {
    super();
      setType1(TypeMap.TypeEnum.STEEL);
      setType1(TypeMap.TypeEnum.PSYCHIC);
    setProfileID(R.drawable.beldum);
    setProfileBackID(R.drawable.beldum_back);
    setPokemonName("Beldum");
    setBaseHp(40);
    setBaseAttack(45);
    setBaseDefense(70);
    setBaseSpeed(30);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(20);
  }
  /**
   * Get the profile ID of Beldum.
   *
   * @return an integer which is the profile ID of Beldum.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.beldum;
  }

  /**
   * Get the profile back ID of
   *
   * @return an integer which is the profile ID of the back of Beldum.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.beldum_back;
  }
}
