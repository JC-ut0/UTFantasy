package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Pidgeotto extends Pokemon {
  /** Constructor of a Pidgeotto. */
  public Pidgeotto() {
    super();
      setType1(TypeMap.TypeEnum.NORMAL);
      setType2(TypeMap.TypeEnum.FLYING);
    setProfileID(R.drawable.pidgeotto);
    setProfileBackID(R.drawable.pidgeotto_back);
    setPokemonName("Pidgeotto");
    setBaseHp(63);
    setBaseAttack(55);
    setBaseDefense(50);
    setBaseSpeed(71);
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
   * Get the profile ID of Pidgeotto.
   *
   * @return an integer which is the profile ID of Pidgeotto.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeotto;
  }

  /**
   * Get the profile back ID of Pidgeotto.
   *
   * @return an integer which is the profile ID of the back of Pidgeotto.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pidgeotto_back;
  }
}
