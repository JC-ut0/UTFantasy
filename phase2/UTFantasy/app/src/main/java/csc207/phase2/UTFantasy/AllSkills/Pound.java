package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class Pound extends Skill {
  /** Constructor of a Pound Skill. */
  Pound() {
    super(35, 40, TypeMap.TypeEnum.NORMAL, "Pound");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": Pounds the foe with forelegs or tail.";
  }
}
