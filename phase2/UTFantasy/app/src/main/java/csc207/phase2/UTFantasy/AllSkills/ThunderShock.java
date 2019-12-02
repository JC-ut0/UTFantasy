package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class ThunderShock extends Skill {
  /** Constructor of a ThunderShock Skill. */
  ThunderShock() {
    super(30, 40, TypeMap.TypeEnum.ELECTRIC, "Thunder Shock");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": An electrical attack that may paralyze the foe.";
  }
}
