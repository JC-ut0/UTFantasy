package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;

public class MapController {
  private MapInteractor mapInteractor;
  private NPCInteractor npcInteractor;
  private boolean dialogueFinished;
  private NPC interactingNpc;

  public MapController(Player player) {
    MapDirector director = new MapDirector(player);
    director.constructMap();
    this.mapInteractor = director.getMapInteractor();
    this.npcInteractor = director.getNPCInteractor();
  }

  public MapInteractor getMapInteractor() {
    return mapInteractor;
  }

  public NPCInteractor getNpcInteractor() {
    return npcInteractor;
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
    if (!dialogueFinished) {
      NPC npc = mapInteractor.getFacingNpc();
      if (npc != null) {
        interactingNpc = npc;
        npcInteractor.openDialogue(npc);
        dialogueFinished = true;
      }
    } else {
      npcInteractor.interact(interactingNpc);
      interactingNpc = null;
      dialogueFinished = false;
    }
  }
}