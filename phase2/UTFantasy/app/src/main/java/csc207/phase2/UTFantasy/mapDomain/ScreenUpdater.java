package csc207.phase2.UTFantasy.mapDomain;

import android.content.res.Resources;

import csc207.phase2.UTFantasy.Character.Player;

public class ScreenUpdater {
  private Player player;
  private Map map;

  public ScreenUpdater(Player player) {
    this.player = player;
    this.map = player.getPlayerMap();
  }

  private UnitDraw[][] updateScreenOverMap(UnitDraw[][] map) {
    int screenWidthUnit = getScreenUnitWidth();
    int screenHeightUnit =getScreenUnitHeight();
    UnitDraw[][] result = new UnitDraw[screenWidthUnit][screenHeightUnit];
    int playerX = player.getX();
    int playerY = player.getY();
    for (int x = 0; x < screenWidthUnit; x++) {
      for (int y = 0; y < screenHeightUnit; y++) {
        int mapWidth = player.getPlayerMap().getMapWidth();
        int mapHeight = player.getPlayerMap().getMapHeight();
        if (playerX + x - screenWidthUnit / 2 >= 0
            && playerX + x - screenWidthUnit / 2 < mapWidth
            && playerY + y - screenHeightUnit / 2 >= 0
            && playerY + y - screenHeightUnit / 2 < mapHeight) {
          UnitDraw unit =
              map[playerX + x - screenWidthUnit / 2][playerY + y - screenHeightUnit / 2];
          result[x][y] = unit;
          if (unit != null) {
            unit.setScreenX(x);
            unit.setScreenY(y);
          }
        }
      }
    }
    return result;
  }

  public UnitDraw[][] updateScreenOverLowMap() {
    return updateScreenOverMap(map.getLowMap());
  }

  public UnitDraw[][] updateScreenOverHighMap() {
    return updateScreenOverMap(map.getHighMap());
  }

  public int getScreenUnitWidth(){
    int screenWidthPixel = Resources.getSystem().getDisplayMetrics().widthPixels;
    int unitWidth = new UnitDraw().getUnitWidth();
    return screenWidthPixel / unitWidth + 4;
  }

  public int getScreenUnitHeight(){
    int screenHeightPixel = Resources.getSystem().getDisplayMetrics().heightPixels;
    int unitHeight = new UnitDraw().getUnitHeight();
    return screenHeightPixel / unitHeight + 4;
  }
}
