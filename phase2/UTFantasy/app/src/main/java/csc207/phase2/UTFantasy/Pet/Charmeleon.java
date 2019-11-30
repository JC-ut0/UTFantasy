package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Ember;
import csc207.phase2.UTFantasy.AllSkills.Flamethrower;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Charmeleon extends Pokemon {
  /** Constructor of a Charmeleon. */
  public Charmeleon() {
    super();
    setType1(TypeMap.TypeEnum.FIRE);
    skills[0] = new Ember();
    skills[1] = new Flamethrower();
    setProfileID(R.drawable.charmeleon);
    setProfileBackID(R.drawable.charmeleon_back);
    setPokemonName("Charmeleon");
    setBaseHp(58);
    setBaseAttack(72);
    setBaseDefense(62);
    setBaseSpeed(80);
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
   * Get the profile ID of Charmeleon.
   *
   * @return an integer which is the profile ID of Charmeleon.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmeleon;
  }

  /**
   * Get the profile back ID of Charmeleon.
   *
   * @return an integer which is the profile ID of the back of Charmeleon.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmeleon_back;
  }
}
