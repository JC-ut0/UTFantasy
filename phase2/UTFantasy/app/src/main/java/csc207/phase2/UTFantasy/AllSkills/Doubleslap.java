package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class Doubleslap extends Skill {
  /** Constructor of a DoubleSlap Skill. */
  public Doubleslap() {
    name = "Doubleslap";
    power = 35;
    pp = 10;
      type = TypeMap.type.NORMAL;
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
