package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

class HealInteraction extends Interaction {

  HealInteraction(MapDrawer drawer, Player player) {
    super(drawer, player);
  }

  @Override
  public void interact(NPC npc) {
    player.heal();
    drawer.popText("You are healed.");
  }
}
