package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Scratch;
import csc207.phase2.UTFantasy.R;

public class Charmander extends Pokemon {
  /** Constructor of a Charmander. */
  public Charmander() {
    super();
    type = "fire";
    skills[0] = new Scratch();
    profileID = R.drawable.charmander;
    pokemonName = "Charmander";
    base_hp = 39;
    base_attack = 56;
    base_defense = 45;
    base_speed = 65;
    setHp(calculateStatistic("hp"));
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
  }

  /**
   * Get the profile ID of Charmander.
   *
   * @return an integer which the profile ID of Charmander.
   */
  @Override
  public int getProfileID() {
    return R.drawable.charmander;
  }
}
