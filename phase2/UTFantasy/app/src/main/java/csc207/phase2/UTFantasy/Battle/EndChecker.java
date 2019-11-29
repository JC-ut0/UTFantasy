package csc207.phase2.UTFantasy.Battle;

public class EndChecker extends FightTurnNode {

    public EndChecker(BattleData battleData) {
        this.battleData = battleData;
    }

    @Override
    public String getText() {
        String text = null;
        if (!battleData.getPlayer().isFightAble()) {
            text = "You lost...";
            battleData.setAction(BattleData.Action.END);
        } else if (!battleData.getRival().isFightAble()) {
            battleData.getRival().setInteracted(true);
            text = "You win!!!";
            battleData.setAction(BattleData.Action.END);
        }
        return text;
    }
}
