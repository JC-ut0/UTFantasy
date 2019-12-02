package csc207.phase2.UTFantasy.Battle;

/**
 * A fightTurnNode that is responsible for checking if the battle should end after current turn end
 * Return text informing if player wins or not
 */
class EndChecker extends FightTurnNode {

    EndChecker(BattleData battleData) {
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
