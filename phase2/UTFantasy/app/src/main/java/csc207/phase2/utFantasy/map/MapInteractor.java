package csc207.phase2.utFantasy.map;

import csc207.phase2.utFantasy.character.NPC;
import csc207.phase2.utFantasy.character.Player;

public interface MapInteractor {
  boolean checkMoveAble();

  NPC getFacingNpc();

  Player getPlayer();

  UnitDraw[][] updateScreenOverLowMap();

  UnitDraw[][] updateScreenOverHighMap();

  int getScreenUnitWidth();

  int getScreenUnitHeight();

  void startMove(String direction);

  void endMove();

  void updateProgress(boolean moveAble);

  int getProgress();

  void setProgress(int Progress);

  void transScreen(UnitDraw[][] map, int progress,boolean moveAble);

  String getPlayerIcon(int progress);
}
