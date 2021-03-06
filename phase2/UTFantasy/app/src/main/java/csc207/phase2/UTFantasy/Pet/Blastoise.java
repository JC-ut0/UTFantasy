package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.SkillFactory;
import csc207.phase2.UTFantasy.BattleUseCase.TypeMap;
import csc207.phase2.UTFantasy.R;

class Blastoise extends Pokemon {
  /** Constructor of a Blastoise. */
  Blastoise(int level) {
    super(
        level,
        TypeMap.TypeEnum.WATER,
        null,
        R.drawable.blastoise,
        R.drawable.blastoise_back,
        "Blastoise",
        79,
        85,
        105,
        78,
        "slow");
    setLevelToEvolve(maxLevel, null);
    SkillFactory sf = new SkillFactory();
    skills[0] = sf.getSkill(SkillFactory.SkillClass.BUBBLE);
    skills[1] = sf.getSkill(SkillFactory.SkillClass.HYDROPUMP);
  }
  /**
   * Get the profile ID of Blastoise.
   *
   * @return an integer which is the profile ID of Blastoise.
   */
  @Override
  public int getProfileID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blastoise;
  }

  /**
   * Get the profile back ID of Blastoise.
   *
   * @return an integer which is the profile ID of the back of Blastoise.
   */
  @Override
  public int getProfileBackID() {
    // The unique profile icon for each Pokemon. ID can be used to draw this Pokemon.
    return R.drawable.blastoise_back;
  }
}
