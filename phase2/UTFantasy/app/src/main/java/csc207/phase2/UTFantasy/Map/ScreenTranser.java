package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.Player;

public class ScreenTranser {
  private Player player;

  public ScreenTranser(Player player) {
    this.player = player;
  }

  public void transScreen(UnitDraw[][] map, int progress, boolean moveAble) {
    for (UnitDraw[] unitDraws : map) {
      for (UnitDraw unit : unitDraws) {
        if (unit != null) {
          float trans = (float) 0.0;
          if (moveAble) {
            trans = (float) (progress / 4.0);
          }
          switch ((player.getDirection())) {
            case "left":
              unit.setScreenX(unit.getScreenX() + trans);
              break;
            case "right":
              unit.setScreenX(unit.getScreenX() - trans);
              break;
            case "up":
              unit.setScreenY(unit.getScreenY() + trans);
              break;
            case "down":
              unit.setScreenY(unit.getScreenY() - trans);
              break;
          }
        }
      }
    }
  }

  public Icon getPlayer(int progress) {
    Icon playerIcon = null;
    switch (player.getDirection()) {
      case ("down"):
        switch (progress) {
          case 0:
            playerIcon = Icon.DOWNPLAYER0;
            break;
          case 1:
            playerIcon = Icon.DOWNPLAYER1;
            break;
          case 2:
            playerIcon = Icon.DOWNPLAYER2;
            break;
          case 3:
          case 4:
            playerIcon = Icon.DOWNPLAYER3;
            break;
        }
        break;
      case ("up"):
        switch (progress) {
          case 0:
            playerIcon = Icon.UPPLAYER0;
            break;
          case 1:
            playerIcon = Icon.UPPLAYER1;
            break;
          case 2:
            playerIcon = Icon.UPPLAYER2;
            break;
          case 3:
          case 4:
            playerIcon = Icon.UPPLAYER3;
            break;
        }
        break;
      case ("left"):
        switch (progress) {
          case 0:
            playerIcon = Icon.LEFTPLAYER0;
            break;
          case 1:
            playerIcon = Icon.LEFTPLAYER1;
            break;
          case 2:
            playerIcon = Icon.LEFTPLAYER2;
            break;
          case 3:
          case 4:
            playerIcon = Icon.LEFTPLAYER3;
            break;
        }
        break;
      case ("right"):
        switch (progress) {
          case 0:
            playerIcon = Icon.RIGHTPLAYER0;
            break;
          case 1:
            playerIcon = Icon.RIGHTPLAYER1;
            break;
          case 2:
            playerIcon = Icon.RIGHTPLAYER2;
            break;
          case 3:
          case 4:
            playerIcon = Icon.RIGHTPLAYER3;
            break;
        }
        break;
    }
    return playerIcon;
  }
}
