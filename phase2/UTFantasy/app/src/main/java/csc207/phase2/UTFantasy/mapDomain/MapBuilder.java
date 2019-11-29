package csc207.phase2.UTFantasy.mapDomain;

import csc207.phase2.UTFantasy.Character.PlayerComparator.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.npcDomain.NPCRepository;
import csc207.phase2.UTFantasy.Pet.Pikachu;

public class MapBuilder {
  private Map product;
  private NPCRepository npcRepository;
  private int mapWidth = 40;
  private int mapHeight = 112;
  private UnitDraw[][] lowMap;
  private UnitDraw[][] highMap;

  public MapBuilder() {
    product = new Map(mapWidth, mapHeight);
    lowMap = new UnitDraw[mapWidth][mapHeight];
    highMap = new UnitDraw[mapWidth][mapHeight];
    npcRepository = product.getNpcRepository();
  }

  public void buildLawn() {
    for (int x = 0; x < mapWidth; x += 1) {
      for (int y = 1; y < mapHeight - 1; y += 1) {
        lowMap[x][y] = new UnitDraw(Icon.LAWN);
      }
    }
  }

  public void buildTree() {
    for (int y = 0; y < mapHeight - 2; y++) { // left vertical border of the map
      for (int x = 0; x < 2; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 0; x < mapWidth; x++) { // top horizontal border
      for (int y = 0; y < 2; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
      highMap[18][1] = new UnitDraw(Icon.TREEIMAGE);
    }
    for (int y = 0; y < mapHeight - 2; y++) { // right vertical border
      for (int x = 38; x < 40; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 0; x < mapWidth; x++) { // bottom horizontal border
      for (int y = 108; y < 110; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }

    for (int y = 2; y < 22; y++) { // tree block No.1 x: 18, y: 2-21, ten trees
      for (int x = 18; x < 20; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 6; x < 18; x++) { // tree block No.2 x: 5-17, y: 12, six trees
      for (int y = 12; y < 14; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 14; y < 26; y++) { // tree block No.3 x: 6, y: 14-25, six trees
      for (int x = 6; x < 8; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 2; x < 26; x++) { // tree block No.4 x: 2-25, y: 30-33, 12*2 trees
      for (int y = 30; y < 34; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 18; y < 30; y++) { // block No.5 x: 12, y: 18-29, six trees
      for (int x = 12; x < 14; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 26; y < 30; y++) { // block No.6 x: 18, y: 26-29, two tress
      for (int x = 18; x < 20; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 18; y < 30; y++) { // block No.7 x: 24, y: 18-29, six trees
      for (int x = 24; x < 26; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 30; x < 38; x++) { // block No.8 x: 30-37, y: 12-31, 10*2 trees
      for (int y = 12; y < 32; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 6; y < 14; y++) { // block No.9 x: 24, y: 6-13, four tress
      for (int x = 24; x < 26; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 2; x < 26; x++) { // block No.10 x: 2-25, y = 46, 12 tress
      for (int y = 46; y < 48; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 48; y < 54; y++) { // block No.11 x: 16, y: 48-53, three trees
      for (int x = 16; x < 18; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 52; y < 58; y++) { // block No.13 x: 8, y: 52-57, three trees
      for (int x = 8; x < 10; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 8; x < 32; x++) { // block No.14 x: 8-31, y: 58, 12 trees
      for (int y = 58; y < 60; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 8; x < 16; x++) { // block No.15 x: 8-15, y: 60, four trees
      for (int y = 60; y < 62; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 4; x < 26; x++) { // block No.17 x: 4-27, y = 66, 12 trees
      for (int y = 66; y < 68; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 52; y < 76; y++) { // block No.16 x: 2, y: 52-75, 12 trees
      for (int x = 2; x < 4; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 38; y < 76; y++) { // block No.12 x: 32, y: 38-75, 19 trees
      for (int x = 32; x < 34; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 38; y < 56; y++) { // block No.24 x: 36, y: 38-55, nine trees
      for (int x = 36; x < 38; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 62; y < 72; y++) { // block No.27 x: 36, y: 62-71, five trees
      for (int x = 36; x < 38; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 8; x < 32; x++) { // block No.18 x: 8-31, y: 72, 12 trees
      for (int y = 72; y < 74; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 74; y < 82; y++) { // block No.19 x: 8, y: 74-81, four trees
      for (int x = 8; x < 10; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 76; y < 94; y++) { // block No.29 x: 2-5, y: 76-93, 9*2 trees
      for (int x = 2; x < 6; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 78; y < 88; y++) { // block No.23 x: 32, y: 78-87, five trees
      for (int x = 32; x < 34; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 6; x < 34; x++) { // block No.22 x: 6-33, y: 88-93, 14*3 trees
      for (int y = 88; y < 94; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 74; y < 84; y++) { // block No.20 x: 24, y: 74-83, four trees
      for (int x = 24; x < 26; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int y = 84; y < 88; y++) { // block No.21 x: 16, y: 84-87 two trees
      for (int x = 16; x < 18; x++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 2; x < 38; x++) { // block No.28 bottom block
      for (int y = 106; y < 108; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
    for (int x = 20; x < 34; x++) { // block No.25 stack of trees
      for (int y = 94; y < 100; y++) {
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(Icon.TREE);
        } else {
          highMap[x][y] = new UnitDraw(Icon.TREEIMAGE);
        }
      }
    }
  }

  public void buildRoad() {}

  public void buildWater() {}

  public void buildNpc() {
    NPC npc;

    npc = new NPC("Professor.P", Duty.FIGHT);
    npc.setDialog("ready for your final exam? great!");
    npc.setInteractedDialogue("Good job!");
    npc.addPokemon(new Pikachu());
    buildSingleNpc(npc, Icon.PROFESSOR, 4, 7);

    npc = new NPC("Alice", Duty.SALE);
    npc.setDialog("How may I help you?");
    buildSingleNpc(npc, Icon.ALICE, 9, 7);

    npc = new NPC("Joy", Duty.HEAL);
    npc.setDialog("welcome to hospital????");
    buildSingleNpc(npc, Icon.JOY, 14, 7);

    npc = new NPC("charmander", Duty.CHARMANDER);
    npc.setDialog("This is a charmander, do you wanna choose it?");
    npc.setInteractedDialogue("A charmander...");
    buildSingleNpc(npc, Icon.POKEMONBALL, 3, 3);
    npcRepository.addBeginningPokemonNPC(npc);

    npc = new NPC("squirtle", Duty.SQUIRTLE);
    npc.setDialog("This is a squirtle, do you wanna choose it?");
    npc.setInteractedDialogue("A squirtle...");
    buildSingleNpc(npc, Icon.POKEMONBALL, 6, 3);
    npcRepository.addBeginningPokemonNPC(npc);
  }

  private void buildSingleNpc(NPC npc, Icon icon, int x, int y) {
    highMap[x][y] = new NPCDraw(icon, npc.getName());
    npcRepository.addNPC(npc.getName(), npc);
  }

  public Map getProduct() {
    product.setHighMap(highMap);
    product.setLowMap(lowMap);
    product.setNpcRepository(npcRepository);
    return product;
  }
}
