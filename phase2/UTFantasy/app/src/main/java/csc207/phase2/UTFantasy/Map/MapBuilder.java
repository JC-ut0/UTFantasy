package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.NPCManager;

public class MapBuilder {
  private Map product;
  private NPCManager npcManager;
  private int mapWidth = 104;
  private int mapHeight = 102;
  private UnitDraw[][] lowMap;
  private UnitDraw[][] highMap;

  public MapBuilder() {
    product = new Map(mapWidth, mapHeight);
    lowMap = new UnitDraw[mapWidth][mapHeight];
    highMap = new UnitDraw[mapWidth][mapHeight];
    npcManager = product.getNpcManager();
  }

  public void buildLawn() {
    for (int x = 0; x < mapWidth; x += 1) {
      for (int y = 0; y < mapHeight; y += 1) {
        lowMap[x][y] = new UnitDraw("lawn");
      }
    }
  }

  public void buildTree() {
    for (int x = 0; x < mapWidth; x++) {
      for (int y = 0; y <= 5; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
      for (int y = 96; y <= 100; y++) {
        if (x % 2.0 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
    }
    for (int y = 6; y <= 95; y++) {
      for (int x = 0; x <= 4; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
      for (int x = 22; x <= 26; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
      for (int x = 98; x < 104; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
    }
  }

  public void buildRoad() {}

  public void buildWater() {}

  public void buildNpc() {
    buildSingleNpc("Professor.P", "fighter", 7, 7);
    buildSingleNpc("Alice", "seller", 12, 7);
    buildSingleNpc("SecondCup", "healer", 17, 7);
  }

  private void buildSingleNpc(String name, String duty, int x, int y) {
    highMap[x][y] = new UnitDraw(name);
    npcManager.addNPC(name, new NPC(name, duty));
  }

  public Map getProduct() {
    product.setHighMap(highMap);
    product.setLowMap(lowMap);
    product.setNpcManager(npcManager);
    return product;
  }
}