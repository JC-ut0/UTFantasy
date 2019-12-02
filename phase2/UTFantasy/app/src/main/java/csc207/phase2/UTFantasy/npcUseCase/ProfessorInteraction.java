package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

/**
 * The interaction that represents the professor who is gonna give the final exam
 */
public class ProfessorInteraction extends Interaction {

    ProfessorInteraction(MapDrawer drawer, Player player) {
        super(drawer, player);
    }

    @Override
    public void openDialogue(NPC npc) {
        super.openDialogue(npc);
        drawer.display(R.drawable.professor_oak);
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
