package csc207.phase2.UTFantasy.Battle;

import java.util.LinkedList;

/**
 * the builder that builds a linked list of fightTurnNode that is responsible for updating messages
 * of one skill usage
 */
class FightTurnBuilder {
    private LinkedList<FightTurnNode> product;
    private BattleData battleData;

    FightTurnBuilder(BattleData battleData) {
        this.product = new LinkedList<>();
        this.battleData = battleData;
    }

    FightTurnBuilder buildSkillCaller() {
        SkillCaller skillCaller = new SkillCaller(battleData);
        product.addFirst(skillCaller);
        return this;
    }

    FightTurnBuilder buildDMGCalculator() {
        DMGCalculator dmgCalculator = new DMGCalculator(battleData);
        product.getLast().setNext(dmgCalculator);
        product.addLast(dmgCalculator);
        return this;
    }

    FightTurnBuilder buildFaintedChecker() {
        FaintedChecker faintedChecker = new FaintedChecker(battleData);
        product.getLast().setNext(faintedChecker);
        product.addLast(faintedChecker);
        return this;
    }

    FightTurnBuilder buildLevelUPChecker() {
        LevelUpChecker levelUpChecker = new LevelUpChecker(battleData);
        product.getLast().setNext(levelUpChecker);
        product.addLast(levelUpChecker);
        return this;
    }

    FightTurnBuilder buildEndChecker() {
        EndChecker endChecker = new EndChecker(battleData);
        product.getLast().setNext(endChecker);
        product.addLast(endChecker);
        return this;
    }

    FightTurnBuilder buildRivalPokemonUpdater() {
        RivalPokemonUpdater rivalPokemonUpdater = new RivalPokemonUpdater(battleData);
        product.getLast().setNext(rivalPokemonUpdater);
        product.addLast(rivalPokemonUpdater);
        return this;
    }

    LinkedList<FightTurnNode> getProduct() {
        return product;
    }
}
