package csc207.phase2.UTFantasy.mapUI;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.EvolutionChecker;
import csc207.phase2.UTFantasy.mapUseCase.MapDirector;
import csc207.phase2.UTFantasy.mapUseCase.MapInteractor;
import csc207.phase2.UTFantasy.npcUseCase.NPCInteractor;

public class MapController {
  private MapInteractor mapInteractor;
  private NPCInteractor npcInteractor;
  private EvolutionChecker evolutionChecker;
  private boolean dialogueOnGoing;
  private NPC interactingNpc;

  public MapController(Player player) {
    MapDirector director = new MapDirector(player);
    director.constructMap();
    this.mapInteractor = director.getMapInteractor();
    this.npcInteractor = director.getNPCInteractor();
    this.evolutionChecker = director.getEvolutionChecker();
  }

  public MapInteractor getMapInteractor() {
    return mapInteractor;
  }

  public NPCInteractor getNpcInteractor() {
    return npcInteractor;
  }

  public EvolutionChecker getEvolutionChecker() {
    return evolutionChecker;
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
    if (!dialogueOnGoing) {
      NPC npc = mapInteractor.getFacingNpc();
      if (npc != null) {
        interactingNpc = npc;
        dialogueOnGoing = true;
        // player is not yet done interacting with this npc
        if (!npc.isInteracted()) npcInteractor.openDialogue(npc);
          // player already finished interacting with this npc before
        else npcInteractor.openInteractedDialogue(npc);
      }
    } else {
      npcInteractor.closeDialogue();
      if (!interactingNpc.isInteracted()) npcInteractor.interact(interactingNpc);
      interactingNpc = null;
      dialogueOnGoing = false;
    }
  }

  public void buttonBClick() {
    npcInteractor.closeDialogue();
    dialogueOnGoing = false;
    interactingNpc = null;
  }

  public void checkEvolution() {
    evolutionChecker.checkEvolution();
  }
}
