package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

/**
 * Represent the strategy used by NPCInteractor. Containing the actual implementation of interaction
 * with NPCs.
 */
public abstract class Interaction {
  protected MapDrawer drawer;
  protected Player player;

  public Interaction(MapDrawer drawer, Player player) {
    this.drawer = drawer;
    this.player = player;
  }

  public void openDialogue(NPC npc) {
    drawer.openDialogue(npc.getDialogue());
  }

  public abstract void interact(NPC npc);
}
