package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class ThunderWave extends Skill {
  /** Constructor of a ThunderWave Skill. */
  ThunderWave() {
    super(20, 15, TypeMap.TypeEnum.ELECTRIC, "Thunder Wave");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A weak jolt of electricity that paralyzes the foe.";
  }
}
