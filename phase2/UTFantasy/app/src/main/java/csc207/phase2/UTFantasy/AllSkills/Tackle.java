package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Tackle extends Skill {
  /** Constructor of a Tackle Skill. */
  public Tackle() {
    name = "Tackle";
    power = 35;
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
    return name + ": Charges the foe with a full- body tackle.";
  }
}
