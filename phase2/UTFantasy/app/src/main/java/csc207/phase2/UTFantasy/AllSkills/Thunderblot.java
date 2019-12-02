package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class Thunderblot extends Skill {
  /** Constructor of a Thunderblot Skill. */
  Thunderblot() {
    super(15, 95, TypeMap.TypeEnum.ELECTRIC, "Thunder Bolt");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A strong electrical attack that may paralyze the foe.";
  }
}
