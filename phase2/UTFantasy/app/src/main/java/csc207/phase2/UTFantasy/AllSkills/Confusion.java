package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Confusion extends Skill {
  /** Constructor of a Confusion Skill. */
  public Confusion() {
    name = "Confusion";
      type = TypeMap.type.PSYCHIC;
    power = 50;
    pp = 25;
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ":  psychic attack that may cause confusion.";
  }
}
