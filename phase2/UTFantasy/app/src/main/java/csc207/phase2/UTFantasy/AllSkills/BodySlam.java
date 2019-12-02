package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

class BodySlam extends Skill {
  /** Constructor of a BodySlam Skill. */
  BodySlam() {
    super(15, 85, TypeMap.TypeEnum.NORMAL, "Body Slam");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A full-body slam that may cause paralysis.";
  }
}
