package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.NPCManager;

public class MapBuilder {
  private Map product;
  private NPCManager npcManager;
  private int mapWidth = 40;
  private int mapHeight = 111;
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
      for (int y = 1; y < mapHeight; y += 1) {
        lowMap[x][y] = new UnitDraw("lawn");
      }
    }
  }

  public void buildTree() {
    for (int y = 0; y < mapHeight-2; y++) { // left vertical border of the map
      int x = 0;
        if (y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
    }
    for (int x = 0; x < mapWidth; x++) { // top horizontal border
      int y = 0;
        if (x % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
        highMap[18][1] = new UnitDraw("treeImage");
    }
    for (int y = 0; y < mapHeight-2; y++) { // right vertical border
      int x = 38;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 0; x < mapWidth; x++) { // bottom horizontal border
      int y = 108;
        if (x % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
    }
    for (int y = 2; y < 21; y++) { // tree block No.1 x: 18, y: 2-21, ten trees
      int x = 18;
        if (y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
    }
    for (int x = 6; x < 18; x++) { // tree block No.2 x: 5-17, y: 12, six trees
      int y = 12;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[6][13] = new UnitDraw("treeImage");
    }
    for (int y = 14; y < 25; y++) { // tree block No.3 x: 6, y: 14-25, six trees
      int x = 6;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 2; x < 25; x++) { // tree block No.4 x: 2-25, y: 30-33, 12*2 trees
      for (int y = 30; y < 33; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
      highMap[1][30] = new UnitDraw("treeImage");
      highMap[1][32] = new UnitDraw("treeImage");
    }
    for (int y = 18; y < 30; y++) { // block No.5 x: 12, y: 18-29, six trees
      int x = 12;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int y = 26; y < 30; y++) { // block No.6 x: 18, y: 26-29, two tress
      int x = 18;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int y = 18; y < 30; y++) { // block No.7 x: 24, y: 18-29, six trees
      int x = 24;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 30; x < 38; x++) { // block No.8 x: 30-37, y: 12-31, 10*2 trees
      for (int y = 12; y < 31; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
    }
    for (int y = 6; y < 13; y++) { // block No.9 x: 24, y: 6-13, four tress
      int x = 24;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 2; x < 25; x++) { // block No.10 x: 2-25, y = 46, 12 tress
      int y = 46;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[1][46] = new UnitDraw("treeImage");
    }
    for (int y = 48; y < 53; y++) { // block No.11 x: 16, y: 48-53, three trees
      int x = 16;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[16][47] = new UnitDraw("treeImage");
    }
    for (int y = 52; y < 58; y++) { // block No.13 x: 8, y: 52-57, three trees
      int x = 8;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 8; x < 32; x++) { // block No.14 x: 8-31, y: 58, 12 trees
      int y = 58;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 8; x < 15; x++) { // block No.15 x: 8-15, y: 60, four trees
      int y = 60;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[8][59] = new UnitDraw("treeImage");
      highMap[14][59] = new UnitDraw("treeImage");
    }
    for (int x = 4; x < 25; x++) { // block No.17 x: 4-27, y = 66, 12 trees
      int y = 66;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[3][66] = new UnitDraw("treeImage");
    }
    for (int y = 52; y < 75; y++) { // block No.16 x: 2, y: 52-75, 12 trees
      int x = 2;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[1][52] = new UnitDraw("treeImage");
    }
    for (int y = 38; y < 75; y++) { // block No.12 x: 32, y: 38-75, 19 trees
      int x = 32;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int y = 38; y < 55; y++) { // block No.24 x: 36, y: 38-55, nine trees
      int x = 36;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[37][38] = new UnitDraw("treeImage");
      highMap[37][54] = new UnitDraw("treeImage");
    }
    for (int y = 62; y < 71; y++) { // block No.27 x: 36, y: 62-71, five trees
      int x = 36;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[37][62] = new UnitDraw("treeImage");
      highMap[37][70] = new UnitDraw("treeImage");
    }
    for (int x = 8; x < 32; x++) { // block No.18 x: 8-31, y: 72, 12 trees
      int y = 72;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int y = 74; y < 81; y++) { // block No.19 x: 8, y: 74-81, four trees
      int x = 8;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[8][73] = new UnitDraw("treeImage");
    }
    for (int y = 76; y < 93; y++) { // block No.29 x: 2-5, y: 76-93, 9*2 trees
      for (int x = 2; x < 5; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
        highMap[2][75] = new UnitDraw("treeImage");
      }
      highMap[1][92] = new UnitDraw("treeImage");
    }
    for (int y = 78; y < 88; y++) { // block No.23 x: 32, y: 78-87, five trees
      int x = 32;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 6; x < 33; x++) { // block No.22 x: 6-33, y: 88-93, 14*3 trees
      for (int y = 88; y < 93; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
      highMap[5][88] = new UnitDraw("treeImage");
      highMap[5][92] = new UnitDraw("treeImage");
    }
    for (int y = 74; y < 83; y++) { // block No.20 x: 24, y: 74-83, four trees
      int x = 24;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[24][73] = new UnitDraw("treeImage");
    }
    for (int y = 84; y < 88; y++) { // block No.21 x: 16, y: 84-87 two trees
      int x = 16;
      if (y % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
    }
    for (int x = 2; x < 38; x++) { // block No.28 bottom block
      int y = 106;
      if (x % 2 == 0) {
        highMap[x][y] = new UnitDraw("tree");
      } else {
        highMap[x][y] = new UnitDraw("treeImage");
      }
      highMap[1][106] = new UnitDraw("treeImage");
    }
    for (int x = 20; x < 33; x++) { // block No.25 stack of trees
      for (int y = 94; y < 99; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw("tree");
        } else {
          highMap[x][y] = new UnitDraw("treeImage");
        }
      }
      highMap[32][93] = new UnitDraw("treeImage");
      highMap[20][93] = new UnitDraw("treeImage");
    }

















  }

  public void buildRoad() {}

  public void buildWater() {}

  public void buildNpc() {
    buildSingleNpc("Professor.P", Duty.Fight, 7, 7);
    buildSingleNpc("Alice", Duty.Seller, 12, 7);
    buildSingleNpc("SecondCup", Duty.Healer, 17, 7);
  }

  private void buildSingleNpc(String name, Duty duty, int x, int y) {
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
