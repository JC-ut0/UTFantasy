package csc207.phase2.UTFantasy.BattleUseCase;

/**
 * A fightTurnNode that is responsible for getting name of attacker and skill name Return text
 * informing the usage of skill
 */
public class SkillCaller extends FightTurnNode {
  private BattleData battleData;

  SkillCaller(BattleData battleData) {
    this.battleData = battleData;
  }

  @Override
  public String getText() {
    return battleData.getAttacker().getPokemonName()
        + " used "
        + battleData.getSkill().getName()
        + ".";
  }
}
