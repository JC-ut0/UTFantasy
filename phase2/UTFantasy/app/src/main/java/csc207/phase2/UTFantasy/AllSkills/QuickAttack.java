package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class QuickAttack extends Skill {
  /** Constructor of a QuickAttack Skill. */
  public QuickAttack() {
    power = 40;
    pp = 30;
      type = TypeMap.type.NORMAL;
    name = "Quick Attack";
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
