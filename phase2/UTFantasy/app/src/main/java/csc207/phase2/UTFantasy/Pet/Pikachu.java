package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Pikachu extends Pokemon {
  /** Constructor of a Pikachu. */
  Pikachu(int level) {
    super(
        level,
        TypeMap.TypeEnum.ELECTRIC,
        null,
        R.drawable.pikachu,
        R.drawable.pikachu_back,
        "Pikachu",
        35,
        55,
        30,
        90,
        "quick");
    setLevelToEvolve(32, new Raichu(32));
    SkillFactory skillFactory = new SkillFactory();
    skills[0] = skillFactory.getSkill(SkillFactory.SkillClass.QUICKATTACK);
  }

  /**
   * Get the profile ID of Pikachu.
   *
   * @return an integer which is the profile ID of Pikachu.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pikachu;
  }

  /**
   * Get the profile back ID of Pikachu.
   *
   * @return an integer which is the profile ID of the back.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.pikachu_back;
  }
}
