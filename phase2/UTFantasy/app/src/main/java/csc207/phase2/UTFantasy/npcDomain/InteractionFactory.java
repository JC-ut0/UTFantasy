package csc207.phase2.UTFantasy.npcDomain;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

public class InteractionFactory {

    public Interaction getFightInteraction(MapDrawer drawer, Player player) {
        return new FightInteraction(drawer, player);
    }

    public Interaction getSaleInteraction(MapDrawer drawer, Player player) {
        return new SaleInteraction(drawer, player);
    }

    public Interaction getHealInteraction(MapDrawer drawer, Player player) {
        return new HealInteraction(drawer, player);
    }

    public Interaction getCharmanderInteraction(MapDrawer drawer, Player player) {
        return new CharmanderInteraction(drawer, player);
    }

    public Interaction getSquirtleInteraction(MapDrawer drawer, Player player) {
        return new SquirtleInteraction(drawer, player);
    }
}
