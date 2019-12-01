package csc207.phase2.UTFantasy.mapUseCase;

import java.io.Serializable;

import csc207.phase2.UTFantasy.npcDomain.NPCRepository;

public class Map implements Serializable {
    private int mapWidth;
    private int mapHeight;
    private UnitDraw[][] lowMap;
    private UnitDraw[][] highMap;
    private NPCRepository npcRepository;

    public Map(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.npcRepository = new NPCRepository();
    }

    // getters and setters for the field
    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public UnitDraw[][] getLowMap() {
        return lowMap;
    }

    public UnitDraw[][] getHighMap() {
        return highMap;
    }

    public void setLowMap(UnitDraw[][] lowMap) {
        this.lowMap = lowMap;
    }

    public void setHighMap(UnitDraw[][] highMap) {
        this.highMap = highMap;
    }

    public NPCRepository getNpcRepository() {
        return npcRepository;
    }

    public void setNpcRepository(NPCRepository npcRepository) {
        this.npcRepository = npcRepository;
    }
}
