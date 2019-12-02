package csc207.phase2.UTFantasy.mapUI;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.EvolutionChecker;
import csc207.phase2.UTFantasy.mapUseCase.MapDirector;
import csc207.phase2.UTFantasy.mapUseCase.MapInteractor;
import csc207.phase2.UTFantasy.npcUseCase.NPCInteractor;

class MapController {
  private MapInteractor mapInteractor;
  private NPCInteractor npcInteractor;
  private EvolutionChecker evolutionChecker;
  /**
   * represents if the player is currently talking with any npc
   */
  private boolean dialogueOnGoing;
  private NPC interactingNpc;

  MapController(Player player) {
    MapDirector director = new MapDirector(player);
    director.constructMap();
    this.mapInteractor = director.getMapInteractor();
    this.npcInteractor = director.getNPCInteractor();
    this.evolutionChecker = director.getEvolutionChecker();
  }

  MapInteractor getMapInteractor() {
    return mapInteractor;
  }

  NPCInteractor getNpcInteractor() {
    return npcInteractor;
  }

  EvolutionChecker getEvolutionChecker() {
    return evolutionChecker;
  }

  /**
   * called when moving buttons kept being touched
   *
   * @param direction the direction that the player is moving towards
   */
  void moveTouchDownAction(String direction) {
    if (mapInteractor.getProgress() == 0) {
      mapInteractor.startMove(direction);
    }
  }

  /**
   * called when moving buttons stop being touched
   */
  void moveTouchUpAction() {
    mapInteractor.endMove();
  }

  /**
   * called when moving buttons is clicked once
   *
   * @param direction the direction that the player is moving towards
   */
  void moveClick(String direction) {
    mapInteractor.startMove(direction);
    mapInteractor.endMove();
    if (mapInteractor.getProgress() == 0) {
      mapInteractor.setProgress(1);
    }
  }

  /**
   * try to interact with a npc
   * either open an dialogue or executes the interaction depending on the situation
   */
  void buttonAClick() {
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

  /**
   * try to cancel the interaction with the npc that player is currently talking with
   */
  void buttonBClick() {
    npcInteractor.closeDialogue();
    dialogueOnGoing = false;
    interactingNpc = null;
  }

  /**
   * check if the player has any pokemon that needs to evolve
   */
  void checkEvolution() {
    evolutionChecker.checkEvolution();
  }
}
