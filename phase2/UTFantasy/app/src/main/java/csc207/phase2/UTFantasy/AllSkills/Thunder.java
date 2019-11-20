package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Thunder extends Skill {
  /** Constructor of a Thunder Skill. */
  public Thunder() {
    power = 120;
    pp = 10;
    type = "electric";
    name = "Thunder";
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A lightning attack that may cause paralysis.";
  }
}
