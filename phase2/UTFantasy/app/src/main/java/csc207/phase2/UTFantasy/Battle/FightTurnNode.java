package csc207.phase2.UTFantasy.Battle;

abstract class FightTurnNode {

    protected BattleData battleData;
    protected String text;
    protected FightTurnNode next;

    public boolean hasNext() {
        return next != null;
    }

    public FightTurnNode next() {
        return next;
    }

    public void setNext(FightTurnNode next) {
        this.next = next;
    }

    abstract public String getText();
}
