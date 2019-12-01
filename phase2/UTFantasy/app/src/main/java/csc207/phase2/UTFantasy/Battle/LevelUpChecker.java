package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.Pet.Pokemon;

public class LevelUpChecker extends FightTurnNode {

  public LevelUpChecker(BattleData battleData) {
    this.battleData = battleData;
  }

  @Override
  public String getText() {
    if (!battleData.getDefender().isAlive()) {
      Pokemon attacker = battleData.getAttacker();
      attacker.addExp(75);
      if (attacker.getExpAtCurrentLevel() >= attacker.getExpToLevelUp()) {
        attacker.setLevel(attacker.getLevel() + 1);
        attacker.setExpAtCurrentLevel(attacker.getExpAtCurrentLevel() - attacker.getExpToLevelUp());
        text = attacker.getPokemonName() + "level up!";
        attacker.notifyObserverExpChange();
      }
      // check if player's pokemon evolves
      Pokemon playerPoke = battleData.getCurrPlayerPoke();
      if (playerPoke.getEvolution() != null
              && playerPoke.getLevelToEvolve() == playerPoke.getLevel()) {
        battleData.setEvolving(true);
        text = "Hmmm???";
      }
    }
    return text;
  }
}
