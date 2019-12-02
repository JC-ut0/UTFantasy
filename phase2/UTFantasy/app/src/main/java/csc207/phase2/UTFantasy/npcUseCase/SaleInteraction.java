package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

/** Represents that the user is able to buy goods from this NPC. */
public class SaleInteraction extends Interaction {

  public SaleInteraction(MapDrawer drawer, Player player) {
    super(drawer, player);
  }

  @Override
  public void interact(NPC npc) {
    drawer.goToShopActivity(npc.getName());
  }
}
