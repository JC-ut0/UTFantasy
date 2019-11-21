package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;

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
