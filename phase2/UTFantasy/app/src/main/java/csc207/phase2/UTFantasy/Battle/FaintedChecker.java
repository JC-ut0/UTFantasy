package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.Pet.Pokemon;

/**
 * A fightTurnNode that is responsible for checking if the current defender pokemon is fainted
 * Return text informing if defender is fainted
 */
class FaintedChecker extends FightTurnNode {

    FaintedChecker(BattleData battleData) {
        this.battleData = battleData;
    }

    @Override
    public String getText() {
        Pokemon defender = battleData.getDefender();
        if (!defender.isAlive()) {
            text = defender.getPokemonName() + " fainted.";
            battleData.setSecondSkillUsed(true);
        }
        return text;
    }
}
