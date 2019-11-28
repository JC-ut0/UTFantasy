package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import csc207.phase2.UTFantasy.Battle.TypeMap;

public class DragonRage extends Skill {
  /** Constructor of a DragonRage Skill. */
  public DragonRage() {
    power = 40;
    pp = 10;
      type = TypeMap.type.DRAGON;
    name = "Dragon Rage";
  }

  /**
   * A description of the Skill.
   *
   * @return a String which is a short description of the Skill
   */
  @NonNull
  @Override
  public String toString() {
    return name + "Launches shock waves that always inflict 40 HP damage.";
  }
}
