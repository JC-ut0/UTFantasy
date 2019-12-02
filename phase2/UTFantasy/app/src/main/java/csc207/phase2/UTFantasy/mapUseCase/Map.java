package csc207.phase2.UTFantasy.mapUseCase;

import java.io.Serializable;

import csc207.phase2.UTFantasy.npcUseCase.NPCRepository;

/** The entity that stores the data of this player's map */
public class Map implements Serializable {
  private int mapWidth;
  private int mapHeight;
  private UnitDraw[][] lowMap;
  private UnitDraw[][] highMap;
  private NPCRepository npcRepository;

  Map(int mapWidth, int mapHeight) {
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
    this.npcRepository = new NPCRepository();
  }

  // getters and setters for the field
  int getMapWidth() {
    return mapWidth;
  }

  int getMapHeight() {
    return mapHeight;
  }

  UnitDraw[][] getLowMap() {
    return lowMap;
  }

  void setLowMap(UnitDraw[][] lowMap) {
    this.lowMap = lowMap;
  }

  UnitDraw[][] getHighMap() {
    return highMap;
  }

  void setHighMap(UnitDraw[][] highMap) {
    this.highMap = highMap;
  }

  public NPCRepository getNpcRepository() {
    return npcRepository;
  }

  void setNpcRepository(NPCRepository npcRepository) {
    this.npcRepository = npcRepository;
  }
}
