package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class QuickAttack extends Skill {
  /** Constructor of a QuickAttack Skill. */
  QuickAttack() {
    super(30, 40, TypeMap.TypeEnum.NORMAL, "Quick Attack");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": An extremely fast attack that always strikes first.";
  }
}
