package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Squirtle extends Pokemon {
  /** Constructor of a Squirtle. */
  Squirtle(int level) {
    super(
        level,
        TypeMap.TypeEnum.WATER,
        null,
        R.drawable.squirtle,
        R.drawable.squirtle_back,
        "Squirtle",
        44,
        48,
        65,
        43,
        "quick");
    setLevelToEvolve(16, new Wartortle(16));
    SkillFactory sf = new SkillFactory();
    skills[0] = sf.getSkill(SkillFactory.SkillClass.BUBBLE);
    skills[1] = sf.getSkill(SkillFactory.SkillClass.TACKLE);
  }

  /**
   * Get the profile ID of Squirtle.
   *
   * @return an integer which is the profile ID of Squirtle.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.squirtle;
  }

  /**
   * Get the profile back ID of Squirtle.
   *
   * @return an integer which is the profile ID of the back of Squirtle.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.squirtle_back;
  }
}
