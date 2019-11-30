package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class WaterGun extends Skill {
  /** Constructor of a WaterGun Skill. */
  public WaterGun() {
    name = "Water Gun";
      type = TypeMap.TypeEnum.WATER;
    power = 40;
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
    return name + ": Squirts water to attack the foe.";
  }
}
