package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

class WaterGun extends Skill {
  /** Constructor of a WaterGun Skill. */
  WaterGun() {
    super(25, 40, TypeMap.TypeEnum.WATER, "Water Gun");
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
