package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.Pet.Pokemon;

public class FaintedChecker extends FightTurnNode {

    public FaintedChecker(BattleData battleData) {
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
