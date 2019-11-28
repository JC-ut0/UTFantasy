package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;


public class HydroPump extends Skill {
  /** Constructor of a HydroPump Skill. */
  public HydroPump() {
    name = "Hydro Pump";
      type = TypeMap.type.WATER;
    power = 120;
    pp = 5;
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": Blasts water at high power to strike the foe.";
  }
}
