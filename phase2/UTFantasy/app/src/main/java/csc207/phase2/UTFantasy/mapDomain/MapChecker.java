package csc207.phase2.UTFantasy.mapDomain;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.npcDomain.NPCRepository;
import csc207.phase2.UTFantasy.Character.Player;

public class MapChecker {
  private Player player;
  private Map map;
  private NPCRepository npcRepository;

  public MapChecker(Player player) {
    this.player = player;
    this.map = player.getPlayerMap();
    this.npcRepository = map.getNpcRepository();
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
    if (facingUnitDraw != null && facingUnitDraw.isNPC()) {
      String npcName = ((NPCDraw) facingUnitDraw).getNpcName();
      return npcRepository.getNPC(npcName);
    }
    return null;
  }

  public Player getPlayer() {
    return player;
  }
}
