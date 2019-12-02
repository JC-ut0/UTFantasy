package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

class Bulbasaur extends Pokemon {
  /** Constructor of a Bulbasaur. */
  Bulbasaur(int level) {
    super(
        level,
        TypeMap.TypeEnum.GRASS,
        TypeMap.TypeEnum.POISON,
        R.drawable.bulbasaur,
        R.drawable.bulbasaur_back,
        "Bulbasaur",
        45,
        57,
        57,
        45,
        "quick");
    setLevelToEvolve(16, new Ivysaur(16));
    SkillFactory sf = new SkillFactory();
    skills[0] = sf.getSkill(SkillFactory.SkillClass.TACKLE);
    skills[1] = sf.getSkill(SkillFactory.SkillClass.VINEWHIP);
  }

  /**
   * Get the profile ID of Bulbasaur.
   *
   * @return an integer which is the profile ID of Bulbasaur.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.bulbasaur;
  }

  /**
   * Get the profile back ID of Bulbasaur.
   *
   * @return an integer which is the profile ID of the back of Bulbasaur.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.bulbasaur_back;
  }
}
