package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class Ember extends Skill {
  /** Constructor of an Ember Skill. */
  Ember() {
    super(25, 40, TypeMap.TypeEnum.FIRE, "Ember");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A weak fire attack that may inflict a burn.";
  }
}
