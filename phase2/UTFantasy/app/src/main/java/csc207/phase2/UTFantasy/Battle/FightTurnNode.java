package csc207.phase2.UTFantasy.Battle;

/**
 * A Node that is returning one text message about its specified responsibility
 * Update corresponding battle data
 */
abstract class FightTurnNode {

  protected BattleData battleData;
  protected String text;
  private FightTurnNode next;

  FightTurnNode next() {
    return next;
  }

  void setNext(FightTurnNode next) {
    this.next = next;
  }

  public abstract String getText();
}
