package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class HyperVoice extends Skill {
  /** Constructor of a HyperVoice Skill. */
  public HyperVoice() {
    name = "Hyper Voice";
    power = 90;
    pp = 10;
    type = "normal";
    effect = "";
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A loud attack that uses sound waves to injure.";
  }
}
