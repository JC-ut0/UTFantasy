package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class HydroPump extends Skill {
  /** Constructor of a HydroPump Skill. */
  HydroPump() {
    super(5, 120, TypeMap.TypeEnum.WATER, "Hydro Pump");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": Blasts water at high power to strike the foe.";
  }
}
