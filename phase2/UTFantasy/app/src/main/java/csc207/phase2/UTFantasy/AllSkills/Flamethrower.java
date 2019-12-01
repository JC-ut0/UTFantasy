package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class Flamethrower extends Skill {
  /** Constructor of a Flamethrower Skill. */
  Flamethrower() {
    super(15, 95, TypeMap.TypeEnum.FIRE, "Flamethrower");
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
