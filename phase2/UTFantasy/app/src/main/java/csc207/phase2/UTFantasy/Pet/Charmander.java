package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Charmander extends Pokemon {
  /** Constructor of a Charmander. */
  Charmander(int level) {
    super(
            level,
            TypeMap.TypeEnum.FIRE,
            null,
            R.drawable.charmander,
            R.drawable.charmander_back,
            "Charmander",
            39,
            56,
            45,
            65,
            "quick");
    setLevelToEvolve(16, new Charmeleon(16));
    SkillFactory factory = new SkillFactory();
    skills[0] = factory.getSkill(SkillFactory.SkillClass.SCARTCH);
  }

  /**
   * Get the profile ID of Charmander.
   *
   * @return an integer which is the profile ID of Charmander.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmander;
  }

  /**
   * Get the profile back ID of Charmander.
   *
   * @return an integer which is the profile ID of the back of Charmander.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.charmander_back;
  }
}
