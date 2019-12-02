package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class Bubble extends Skill {
  /** Constructor of a Bubble Skill. */
  Bubble() {
    super(30, 20, TypeMap.TypeEnum.WATER, "Bubble");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": An attack using bubbles. May lower the foe's SPEED.";
  }
}
