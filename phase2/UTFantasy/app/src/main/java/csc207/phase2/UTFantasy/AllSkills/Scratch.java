package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Scratch extends Skill {
  /** Constructor of a Scratch Skill. */
  public Scratch() {
    power = 40;
    pp = 35;
    effect = "";
    type = "normal";
    name = "Scratch";
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
