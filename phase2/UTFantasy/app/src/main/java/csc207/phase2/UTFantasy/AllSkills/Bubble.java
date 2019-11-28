package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Bubble extends Skill {
  /** Constructor of a Bubble Skill. */
  public Bubble() {
    name = "Bubble";
      type = TypeMap.type.WATER;
    power = 20;
    pp = 30;
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": An attack using bubbles. May lower the foe's SPEED.";
  }
}
