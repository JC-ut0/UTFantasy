package csc207.phase2.utFantasy.map;

import csc207.phase2.utFantasy.character.NPC;
import csc207.phase2.utFantasy.character.NPCManager;
import csc207.phase2.utFantasy.character.Player;

public class MapChecker {
  private Player player;
  private Map map;
  private NPCManager npcManager;

  public MapChecker(Player player) {
    this.player = player;
    this.map = player.getPlayerMap();
    this.npcManager = map.getNpcManager();
  }

  private UnitDraw getFacingUnitDraw() {
    int playerX = player.getX();
    int playerY = player.getY();
    UnitDraw frontObject = null;
    switch (player.getDirection()) {
      case "up":
        frontObject = map.getHighMap()[playerX][playerY - 1];
        break;
      case "down":
        frontObject = map.getHighMap()[playerX][playerY + 1];
        break;
      case "left":
        frontObject = map.getHighMap()[playerX - 1][playerY];
        break;
      case "right":
        frontObject = map.getHighMap()[playerX + 1][playerY];
        break;
    }
    return frontObject;
  }

  public boolean checkMoveAble() {
    return getFacingUnitDraw() == null;
  }

  public NPC getFacingNpc() {
    UnitDraw facingUnitDraw = getFacingUnitDraw();
    if (facingUnitDraw != null) {
      String npcName = facingUnitDraw.getDraw();
      return npcManager.getNPC(npcName);
    }
    return null;
  }

  public Player getPlayer() {
    return player;
  }
}
