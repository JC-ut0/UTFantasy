package csc207.phase2.UTFantasy.npcDomain;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

public class HealInteraction extends Interaction {

    public HealInteraction(MapDrawer drawer, Player player) {
        super(drawer, player);
    }

    @Override
    public void interact(NPC npc) {
        player.heal();
        drawer.popText("You are healed.");
    }
}
