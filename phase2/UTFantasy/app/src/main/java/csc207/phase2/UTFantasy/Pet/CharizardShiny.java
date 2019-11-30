package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class CharizardShiny extends Pokemon {
  /** Constructor of a Shiny Charizard. */
  public CharizardShiny() {
    super();
    setType1(TypeMap.type.FIRE);
    setType2(TypeMap.type.FLYING);
    setProfileID(R.drawable.charizard_shiny);
    setProfileBackID(R.drawable.charizard_shiny_back);
    setPokemonName("Charizard");
    setBaseHp(78);
    setBaseAttack(97);
    setBaseDefense(82);
    setBaseSpeed(100);
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
   * Get the profile ID of Shiny Charizard.
   *
   * @return an integer which is the profile ID of Shiny Charizard.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charizard_shiny;
  }

  /**
   * Get the profile back ID of Shiny Charizard.
   *
   * @return an integer which is the profile ID of the back of Shiny Charizard.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charizard_shiny_back;
  }
}
