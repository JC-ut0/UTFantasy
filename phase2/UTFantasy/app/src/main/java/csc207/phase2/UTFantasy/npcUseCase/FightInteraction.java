package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

class FightInteraction extends Interaction {

    FightInteraction(MapDrawer drawer, Player player) {
        super(drawer, player);
    }

    @Override
    public void interact(NPC npc) {
        if (player.isFightAble()) {
            drawer.goToBattleActivity(npc.getName());
        } else {
            drawer.popText("You can't fight since you don't have an alive pokemon rn...");
        }
    }
}
