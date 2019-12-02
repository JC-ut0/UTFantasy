package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

/** The factory that creates Interaction strategy and solves dependency injection. */
class InteractionFactory {

  Interaction getFightInteraction(MapDrawer drawer, Player player) {
    return new FightInteraction(drawer, player);
  }

  Interaction getSaleInteraction(MapDrawer drawer, Player player) {
    return new SaleInteraction(drawer, player);
  }

  Interaction getHealInteraction(MapDrawer drawer, Player player) {
    return new HealInteraction(drawer, player);
  }

  Interaction getCharmanderInteraction(MapDrawer drawer, Player player) {
    return new CharmanderInteraction(drawer, player);
  }

  Interaction getSquirtleInteraction(MapDrawer drawer, Player player) {
    return new SquirtleInteraction(drawer, player);
  }

  Interaction getBulbasaurInteraction(MapDrawer drawer, Player player) {
    return new BulbasaurInteraction(drawer, player);
  }
}
