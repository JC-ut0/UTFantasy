package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Bulbasaur extends Pokemon {
  /** Constructor of a Bulbasaur. */
  public Bulbasaur() {
    super();
      setType1(TypeMap.TypeEnum.GRASS);
      setType2(TypeMap.TypeEnum.POISON);
    setProfileID(R.drawable.bulbasaur);
    setProfileBackID(R.drawable.bulbasaur_back);
    setPokemonName("Bulbasaur");
    setBaseHp(45);
    setBaseAttack(57);
    setBaseDefense(57);
    setBaseSpeed(45);
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setGrowType("quick");
    setExpToLevelUp(calculateExpToLevelUp());
    setExpAtCurrentLevel(calculateExpAtCurrentLevel());
    setLevelToEvolve(16);
  }

  /**
   * Get the profile ID of Bulbasaur.
   *
   * @return an integer which is the profile ID of Bulbasaur.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.bulbasaur;
  }

  /**
   * Get the profile back ID of Bulbasaur.
   *
   * @return an integer which is the profile ID of the back of Bulbasaur.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.bulbasaur_back;
  }
}
