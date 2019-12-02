package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class Scratch extends Skill {
  /** Constructor of a Scratch Skill. */
  Scratch() {
    super(35, 40, TypeMap.TypeEnum.NORMAL, "Scratch");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": Scratches the foe with sharp claws.";
  }
}
