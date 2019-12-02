package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.npcUseCase.NPCRepository;

/**
 * Responsible for check if the player is movable on the map and return the facing unitDraw of this
 * player
 */
public class MapChecker {
  private Player player;
  private Map map;
  private NPCRepository npcRepository;

  MapChecker(Player player) {
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

  boolean checkMoveAble() {
    return getFacingUnitDraw() == null;
  }

  NPC getFacingNpc() {
    UnitDraw facingUnitDraw = getFacingUnitDraw();
    if (facingUnitDraw instanceof NPCDraw) {
      String npcName = ((NPCDraw) facingUnitDraw).getNpcName();
      return npcRepository.getNPC(npcName);
    }
    return null;
  }

  public Player getPlayer() {
    return player;
  }
}
