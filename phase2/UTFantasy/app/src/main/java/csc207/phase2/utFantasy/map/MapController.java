package csc207.phase2.utFantasy.map;

import csc207.phase2.utFantasy.character.NPC;
import csc207.phase2.utFantasy.character.Player;

public class MapController {
  private MainActivityModel mainActivityModel;
  private MapInteractor mapInteractor;

  public MapController(Player player, MainActivityModel mainActivityModel) {
    this.mainActivityModel = mainActivityModel;
    MapDirector director = new MapDirector(player);
    director.constructMap();
    this.mapInteractor = director.getMapInteractor();
  }

  public MapInteractor getMapInteractor() {
    return mapInteractor;
  }

  public void moveTouchDownAction(String direction) {
    if (mapInteractor.getProgress() == 0) {
      mapInteractor.startMove(direction);
    }
  }

  public void moveTouchUpAction() {
    mapInteractor.endMove();
  }

  public void moveClick(String direction) {
    mapInteractor.startMove(direction);
    mapInteractor.endMove();
    if (mapInteractor.getProgress() == 0) {
      mapInteractor.setProgress(1);
    }
  }

  public void buttonAClick() {
    NPC npc = mapInteractor.getFacingNpc();
    if (npc != null) {
      switch (npc.getDuty()) {
        case Fight:
          mainActivityModel.fight();
          break;
        case Seller:
          mainActivityModel.trade();
          break;
        case Healer:
          mapInteractor.getPlayer().heal();
          mainActivityModel.popText("You are healed!");
          break;
      }
    }
  }
}
