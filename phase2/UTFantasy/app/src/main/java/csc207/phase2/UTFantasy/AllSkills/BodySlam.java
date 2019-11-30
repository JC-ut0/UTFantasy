package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class BodySlam extends Skill {
  /** Constructor of a BodySlam Skill. */
  public BodySlam() {
    name = "Body Slam";
    type = TypeMap.TypeEnum.NORMAL;
    power = 85;
    pp = 15;
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
