package csc207.phase2.utFantasy.map;

import csc207.phase2.utFantasy.character.Player;

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

  public String getPlayer(int progress) {
    String playerIcon = null;
    switch (player.getDirection()) {
      case ("down"):
        switch (progress) {
          case 0:
            playerIcon = "downPlayer0";
            break;
          case 1:
            playerIcon = "downPlayer1";
            break;
          case 2:
            playerIcon = "downPlayer2";
            break;
          case 3:
          case 4:
            playerIcon = "downPlayer3";
            break;
        }
        break;
      case ("up"):
        switch (progress) {
          case 0:
            playerIcon = "upPlayer0";
            break;
          case 1:
            playerIcon = "upPlayer1";
            break;
          case 2:
            playerIcon = "upPlayer2";
            break;
          case 3:
          case 4:
            playerIcon = "upPlayer3";
            break;
        }
        break;
      case ("left"):
        switch (progress) {
          case 0:
            playerIcon = "leftPlayer0";
            break;
          case 1:
            playerIcon = "leftPlayer1";
            break;
          case 2:
            playerIcon = "leftPlayer2";
            break;
          case 3:
          case 4:
            playerIcon = "leftPlayer3";
            break;
        }
        break;
      case ("right"):
        switch (progress) {
          case 0:
            playerIcon = "rightPlayer0";
            break;
          case 1:
            playerIcon = "rightPlayer1";
            break;
          case 2:
            playerIcon = "rightPlayer2";
            break;
          case 3:
          case 4:
            playerIcon = "rightPlayer3";
            break;
        }
        break;
    }
    return playerIcon;
  }
}
