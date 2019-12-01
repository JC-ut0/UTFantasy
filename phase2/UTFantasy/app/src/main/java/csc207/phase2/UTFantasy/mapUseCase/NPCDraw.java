package csc207.phase2.UTFantasy.mapUseCase;

public class NPCDraw extends UnitDraw {
    private String npcName;

    NPCDraw(Icon icon, String npcName) {
        this.icon = icon;
        this.npcName = npcName;
    }

    public String getNpcName() {
        return npcName;
    }

    @Override
    public boolean isNPC() {
        System.out.println("im");
        return true;
    }
}
