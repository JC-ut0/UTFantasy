package csc207.phase2.UTFantasy.BattleUseCase;

import csc207.phase2.UTFantasy.Pet.Pokemon;

/**
 * A fightTurnNode that is responsible for checking if the current attacker has leveled up Return
 * text informing if attacker leveled up
 */
class LevelUpChecker extends FightTurnNode {

  LevelUpChecker(BattleData battleData) {
    this.battleData = battleData;
  }

  @Override
  public String getText() {
    if (!battleData.getDefender().isAlive()) {
      Pokemon attacker = battleData.getAttacker();
      attacker.addExp(75);
      if (attacker.getExpAtCurrentLevel() >= attacker.getExpToLevelUp()) {
        attacker.setLevel(attacker.getLevel() + 1);
        attacker.setExpAtCurrentLevel(attacker.calculateExpAtCurrentLevel());
        text = attacker.getPokemonName() + " leveled up!";
      }
    }
    return text;
  }
}
