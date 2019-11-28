package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Thunderblot extends Skill {
  /** Constructor of a Thunderblot Skill. */
  public Thunderblot() {
    power = 95;
    pp = 15;
      type = TypeMap.type.ELECTRIC;
    name = "Thunder Blot";
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": A strong electrical attack that may paralyze the foe.";
  }
}
