package csc207.phase2.UTFantasy.Battle;

public class SkillCaller extends FightTurnNode {
    private BattleData battleData;

    public SkillCaller(BattleData battleData) {
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
