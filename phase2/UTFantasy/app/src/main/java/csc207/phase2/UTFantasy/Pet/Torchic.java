package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Torchic extends Pokemon {
  /** Constructor of a Torchic. */
  public Torchic() {
    super();
      setType1(TypeMap.TypeEnum.FIRE);
    setProfileID(R.drawable.torchic);
    setProfileBackID(R.drawable.torchic_back);
    setPokemonName("Torchic");
    setBaseHp(45);
    setBaseAttack(65);
    setBaseDefense(45);
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
   * Get the profile ID of Torchic.
   *
   * @return an integer which is the profile ID of Torchic.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.torchic;
  }

  /**
   * Get the profile back ID of Torchic.
   *
   * @return an integer which is the profile ID of the back of Torchic.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.torchic_back;
  }
}
