package csc207.phase2.utFantasy.allSkills;

import androidx.annotation.NonNull;

public class Flamethrower extends Skill {
  /** Constructor of a Flamethrower Skill. */
  public Flamethrower() {
    power = 95;
    pp = 15;
    type = "fire";
    name = "Flamethrower";
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A powerful fire attack that may inflict a burn.";
  }
}
