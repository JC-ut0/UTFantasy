package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class Tackle extends Skill {
  /** Constructor of a Tackle Skill. */
  Tackle() {
    super(35, 35, TypeMap.TypeEnum.NORMAL, "Tackle");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": Charges the foe with a full- body tackle.";
  }
}
