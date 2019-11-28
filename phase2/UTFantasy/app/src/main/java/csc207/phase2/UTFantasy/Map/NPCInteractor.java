package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.Psyduck;

public class NPCInteractor {
    private Player player;
    private MapDrawer drawer;

    NPCInteractor(Player player) {
        this.player = player;
    }

    public void setDrawer(MapDrawer drawer) {
        this.drawer = drawer;
    }

    public void openDialogue(NPC npc) {
        String dialogue = npc.getDialogu();
        drawer.openDialogue(dialogue);
    }

    public void interact(NPC npc) {
        drawer.hideDialogue();
        Duty duty = npc.getDuty();
        switch (duty) {
            case FIGHT:
                if (player.isFightAble()) {
                    drawer.goToBattleActivity(npc.getName());
                } else {
                    drawer.popText("You can't fight since you don't have an alive pokemon rn...");
                }
                break;
            case SALE:
                drawer.goToShopActivity(npc.getName());
                break;
            case HEAL:
                player.heal();
                drawer.popText("You are healed!");
                break;
            case PSYDUCK:
                Pokemon psyduck = new Psyduck();
                psyduck.setLevel(10);
                player.addPokemon(psyduck);
        }
    }
}
