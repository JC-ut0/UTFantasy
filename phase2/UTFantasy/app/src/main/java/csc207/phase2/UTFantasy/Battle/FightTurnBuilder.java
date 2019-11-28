package csc207.phase2.UTFantasy.Battle;

import java.util.LinkedList;

public class FightTurnBuilder {
    private LinkedList<FightTurnNode> product;
    private BattleData battleData;

    public FightTurnBuilder(BattleData battleData) {
        this.product = new LinkedList<>();
        this.battleData = battleData;
    }

    public FightTurnBuilder buildSkillCaller() {
        SkillCaller skillCaller = new SkillCaller(battleData);
        product.addFirst(skillCaller);
        return this;
    }

    public FightTurnBuilder buildDMGCalculator() {
        DMGCalculator dmgCalculator = new DMGCalculator(battleData);
        product.getLast().setNext(dmgCalculator);
        product.addLast(dmgCalculator);
        return this;
    }

    public FightTurnBuilder buildFaintedChecker() {
        FaintedChecker faintedChecker = new FaintedChecker(battleData);
        product.getLast().setNext(faintedChecker);
        product.addLast(faintedChecker);
        return this;
    }

    public FightTurnBuilder buildLevelUPChecker() {
        LevelUpChecker levelUpChecker = new LevelUpChecker(battleData);
        product.getLast().setNext(levelUpChecker);
        product.addLast(levelUpChecker);
        return this;
    }

    public FightTurnBuilder buildEndChecker() {
        EndChecker endChecker = new EndChecker(battleData);
        product.getLast().setNext(endChecker);
        product.addLast(endChecker);
        return this;
    }

    public FightTurnBuilder buildRivalPokemonUpdater() {
        RivalPokemonUpdater rivalPokemonUpdater = new RivalPokemonUpdater(battleData);
        product.getLast().setNext(rivalPokemonUpdater);
        product.addLast(rivalPokemonUpdater);
        return this;
    }

    public LinkedList<FightTurnNode> getProduct() {
        return product;
    }
}
