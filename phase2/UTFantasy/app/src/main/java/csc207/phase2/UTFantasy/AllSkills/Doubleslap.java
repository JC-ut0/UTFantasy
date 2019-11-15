package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Doubleslap extends Skill {
  /** Constructor of a DoubleSlap Skill. */
  public Doubleslap() {
    name = "Doubleslap";
    power = 35;
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
    return name + ": Repeatedly slaps the foe 2 to 5 times.";
  }
}
