package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;


public class Flamethrower extends Skill {
  /** Constructor of a Flamethrower Skill. */
  public Flamethrower() {
    power = 95;
    pp = 15;
      type = TypeMap.TypeEnum.FIRE;
    name = "Flamethrower";
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A powerful fire attack that may inflict a burn.";
  }
}
