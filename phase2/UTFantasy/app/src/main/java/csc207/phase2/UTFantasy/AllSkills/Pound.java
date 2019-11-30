package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Pound extends Skill {
  /** Constructor of a Pound Skill. */
  public Pound() {
    name = "Pound";
    power = 40;
    pp = 35;
      type = TypeMap.TypeEnum.NORMAL;
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
