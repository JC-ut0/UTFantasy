package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class Confusion extends Skill {
  /** Constructor of a Confusion Skill. */
  Confusion() {
    super(25, 50, TypeMap.TypeEnum.PSYCHIC, "Confusion");
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
