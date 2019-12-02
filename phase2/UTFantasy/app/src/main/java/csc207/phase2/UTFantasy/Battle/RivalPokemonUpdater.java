package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Pet.Pokemon;

/**
 * A fightTurnNode that is responsible for updating the current rival pokemon Return text informing
 * that rival update pokemon
 */
class RivalPokemonUpdater extends FightTurnNode {

  RivalPokemonUpdater(BattleData battleData) {
    this.battleData = battleData;
  }

  @Override
  public String getText() {
    NPC rival = battleData.getRival();
    if (!battleData.getCurrRivalPoke().isAlive() && rival.isFightAble()) {
      Pokemon rivalPoke = rival.getFirstAlivePoke();
      battleData.setCurrRivalPoke(rivalPoke);
      text = rival.getName() + " sent out " + rivalPoke.getPokemonName() + ".";
    }
    return text;
  }
}
