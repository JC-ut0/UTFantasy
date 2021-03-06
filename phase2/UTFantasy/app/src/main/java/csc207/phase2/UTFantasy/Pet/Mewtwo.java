package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Mewtwo extends Pokemon {
  /** Constructor of a Mewtwo. */
  Mewtwo(int level) {
    super(
        level,
        TypeMap.TypeEnum.PSYCHIC,
        null,
        R.drawable.mewtwo,
        R.drawable.mewtwo,
        "Mewtwo",
        106,
        134,
        90,
        130,
        "slow");
    setLevelToEvolve(maxLevel, null);
    SkillFactory factory = new SkillFactory();
    skills[0] = factory.getSkill(SkillFactory.SkillClass.BODYSLAM);
  }
  /**
   * Get the profile ID of Mewtwo.
   *
   * @return an integer which is the profile ID of Mewtwo.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mewtwo;
  }

  /**
   * Get the profile back ID of Mewtwo.
   *
   * @return an integer which is the profile ID of the back of Mewtwo.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.mewtwo;
  }
}
