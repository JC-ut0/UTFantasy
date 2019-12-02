package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;

/**
 * the facade for MapChecker, ScreenUpdater, MovementManager and ScreenTranser
 */
public interface MapInteractor {
  /**
   * @return true iff there is no blocking in front of player currently
   */
  boolean checkMoveAble();

  /**
   * return null iff there is no available npc in front of player
   *
   * @return the facing npc in front of the player
   */
  NPC getFacingNpc();

  Player getPlayer();

  /**
   * @return the collection of unitDraws that is supposed to be drawn on the screen at a low height
   */
  UnitDraw[][] updateScreenOverLowMap();

  /**
   * @return the collection of unitDraws that is supposed to be drawn on the screen at a high height
   */
  UnitDraw[][] updateScreenOverHighMap();

  /**
   * @return the width of the drawn screen counted in units
   */
  int getScreenUnitWidth();

  /**
   * @return the height of the drawn screen counted in units
   */
  int getScreenUnitHeight();

  /**
   * extend width of drawn screen in case that some bitmap width get too big to be partly shown on
   * the screen when its actual position is not within the screen
   *
   * @return the extended width of the drawn screen counted in units
   */
  int getExtendedWidth();

  /**
   * extend height of drawn screen in case that some bitmap height get too big to be partly shown on
   * the screen when its actual position is not within the screen
   *
   * @return the extended height of the drawn screen counted in units
   */
  int getExtendedHeight();

  void startMove(String direction);

  void endMove();

  /**
   * use the progress to show the movement of player
   *
   * @param moveAble if this player is allowed on the current map
   */
  void updateProgress(boolean moveAble);

  int getProgress();

  void setProgress(int Progress);

  /**
   * translate the drawn screen by progress is movable
   *
   * @param map      the map that gets translated
   * @param progress the progress used to track and show player's movement
   * @param moveAble if this player is allowed to move on the current map
   */
  void transScreen(UnitDraw[][] map, int progress, boolean moveAble);

  /**
   * @param progress the progress used to track and show player's movement
   * @return the correct player image that is supposed to be drawn depending on the progress
   */
  Icon getPlayerIcon(int progress);
}
