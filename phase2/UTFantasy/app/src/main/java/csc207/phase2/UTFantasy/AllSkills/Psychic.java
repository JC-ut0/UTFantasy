package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Psychic extends Skill {
  /** Constructor of a Psychic Skill. */
  Psychic() {
    super(10, 90, TypeMap.TypeEnum.PSYCHIC, "Psychic");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": The foe is hit by a strong telekinetic force. ";
  }
}
