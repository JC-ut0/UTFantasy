package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;

public class VineWhip extends Skill {
  /** Constructor of a VineWhip Skill. */
  VineWhip() {
    super(25, 45, TypeMap.TypeEnum.GRASS, "Vine Whip");
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + ": The foe is struck with slender, whip-like vines.";
  }
}
