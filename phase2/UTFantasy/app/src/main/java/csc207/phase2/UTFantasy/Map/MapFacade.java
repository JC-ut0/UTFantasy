package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;

public class MapFacade implements MapInteractor {
  private MapChecker mapChecker;
  private ScreenUpdater screenUpdater;
  private MovementManager movementManager;
  private ScreenTranser screenTranser;

  public MapFacade(
      MapChecker checker, ScreenUpdater updater, MovementManager manager, ScreenTranser transer) {
    this.mapChecker = checker;
    this.screenUpdater = updater;
    this.movementManager = manager;
    this.screenTranser = transer;
  }

  @Override
  public boolean checkMoveAble() {
    return mapChecker.checkMoveAble();
  }

  @Override
  public NPC getFacingNpc() {
    return mapChecker.getFacingNpc();
  }

  @Override
  public Player getPlayer(){
    return mapChecker.getPlayer();
  }

  @Override
  public UnitDraw[][] updateScreenOverLowMap() {
    return screenUpdater.updateScreenOverLowMap();
  }

  @Override
  public UnitDraw[][] updateScreenOverHighMap() {
    return screenUpdater.updateScreenOverHighMap();
  }

  @Override
  public int getScreenUnitWidth() {
    return screenUpdater.getScreenUnitWidth();
  }

  @Override
  public int getScreenUnitHeight() {
    return screenUpdater.getScreenUnitHeight();
  }

  @Override
  public void startMove(String direction) {
    movementManager.startMove(direction);
  }

  @Override
  public void endMove() {
    movementManager.endMoving();
  }

  @Override
  public void updateProgress(boolean moveAble) {
    movementManager.updateProgress(moveAble);
  }

  @Override
  public int getProgress() {
    return movementManager.getProgress();
  }

  @Override
  public void setProgress(int progress) {
    movementManager.setProgress(progress);
  }

  @Override
  public void transScreen(UnitDraw[][] map, int progress, boolean moveAble) {
    screenTranser.transScreen(map, progress, moveAble);
  }

  @Override
  public String getPlayerIcon(int progress) {
    return screenTranser.getPlayer(progress);
  }
}
