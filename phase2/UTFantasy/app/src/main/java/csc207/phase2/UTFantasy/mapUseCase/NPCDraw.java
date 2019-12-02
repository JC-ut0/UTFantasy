package csc207.phase2.UTFantasy.mapUseCase;

/**
 * represents one npc
 * contains the name of the npc
 */
class NPCDraw extends UnitDraw {
    private String npcName;

    NPCDraw(Icon icon, String npcName) {
        this.icon = icon;
        this.npcName = npcName;
    }

    String getNpcName() {
        return npcName;
    }
}
