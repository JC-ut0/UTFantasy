package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class Thunder extends Skill {
  /** Constructor of a Thunder Skill. */
  Thunder() {
    super(10, 120, TypeMap.TypeEnum.ELECTRIC, "Thunder");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A lightning attack that may cause paralysis.";
  }
}
