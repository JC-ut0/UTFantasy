package csc207.phase2.utFantasy.map;

import java.io.Serializable;

import csc207.phase2.utFantasy.character.NPCManager;

public class Map implements Serializable {
  private int mapWidth;
  private int mapHeight;
  private UnitDraw[][] lowMap;
  private UnitDraw[][] highMap;
  private NPCManager npcManager;

  public Map(int mapWidth, int mapHeight) {
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    this.npcManager = new NPCManager();
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

  public NPCManager getNpcManager() {
    return npcManager;
  }

  public void setNpcManager(NPCManager npcManager) {
    this.npcManager = npcManager;
  }
}
