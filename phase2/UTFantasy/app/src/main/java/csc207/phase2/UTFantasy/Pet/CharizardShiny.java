package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class CharizardShiny extends Pokemon {
  /** Constructor of a Shiny Charizard. */
  CharizardShiny(int level) {
      super(
              level,
              TypeMap.TypeEnum.FIRE,
              TypeMap.TypeEnum.FLYING,
              R.drawable.charizard_shiny,
              R.drawable.charizard_shiny_back,
              "Charizard",
              78,
              97,
              82,
              100,
              "slow");
    setLevelToEvolve(maxLevel, null);
    SkillFactory factory = new SkillFactory();
    skills[0] = factory.getSkill(SkillFactory.SkillClass.FLAMETHROWER);
    skills[1] = factory.getSkill(SkillFactory.SkillClass.DRAGONRAGE);
  }
  /**
   * Get the profile ID of Shiny Charizard.
   *
   * @return an integer which is the profile ID of Shiny Charizard.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charizard_shiny;
  }

  /**
   * Get the profile back ID of Shiny Charizard.
   *
   * @return an integer which is the profile ID of the back of Shiny Charizard.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charizard_shiny_back;
  }
}
