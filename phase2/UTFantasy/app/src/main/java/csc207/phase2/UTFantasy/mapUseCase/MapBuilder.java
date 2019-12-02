package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
import csc207.phase2.UTFantasy.npcUseCase.NPCRepository;

/**
 * The builder that builds the map
 */
public class MapBuilder {
  private Map product;
  private NPCRepository npcRepository;
  private int mapWidth = 40;
  private int mapHeight = 112;
  private UnitDraw[][] lowMap;
  private UnitDraw[][] highMap;

  MapBuilder() {
    product = new Map(mapWidth, mapHeight);
    lowMap = new UnitDraw[mapWidth][mapHeight];
    highMap = new UnitDraw[mapWidth][mapHeight];
    npcRepository = product.getNpcRepository();
  }

  void buildLawn() {
    for (int x = 0; x < mapWidth; x += 1) {
      for (int y = 1; y < mapHeight - 1; y += 1) {
        lowMap[x][y] = new UnitDraw(Icon.LAWN);
      }
    }
  }

  void buildGrass() {
    for (int x = 2; x < 6; x += 1) {
      for (int y = 13; y < 16; y += 1) {
        lowMap[x][y] = new UnitDraw(Icon.GRASS0);
      }
    }
    for (int x = 2; x < 6; x += 1) {
      for (int y = 18; y < 21; y += 1) {
        lowMap[x][y] = new UnitDraw(Icon.GRASS1);
      }
    }
  }

  void buildTree() {
    buildRectangleTree(0, 2, 0, mapHeight - 2, Icon.TREE);
    buildRectangleTree(0, mapWidth, 0, 2, Icon.TREE);
    buildRectangleTree(38, 40, 0, mapHeight - 2, Icon.TREE);
    buildRectangleTree(0, mapWidth, 108, 110, Icon.TREE);
    buildRectangleTree(18, 20, 2, 22, Icon.TREE);
    buildRectangleTree(6, 18, 12, 14, Icon.TREE);
    buildRectangleTree(6, 8, 14, 26, Icon.TREE);
    buildRectangleTree(2, 26, 30, 34, Icon.TREE);
    buildRectangleTree(12, 14, 18, 30, Icon.TREE);
    buildRectangleTree(18, 20, 26, 30, Icon.TREE);
    buildRectangleTree(24, 26, 18, 30, Icon.TREE);
    buildRectangleTree(30, 38, 12, 32, Icon.TREE);
    buildRectangleTree(24, 26, 6, 14, Icon.TREE);
    buildRectangleTree(2, 26, 46, 48, Icon.TREE);
    buildRectangleTree(16, 18, 48, 54, Icon.TREE);
    buildRectangleTree(8, 10, 52, 58, Icon.TREE);
    buildRectangleTree(8, 32, 58, 60, Icon.TREE);
    buildRectangleTree(8, 16, 60, 62, Icon.TREE);
    buildRectangleTree(4, 26, 66, 68, Icon.TREE);
    buildRectangleTree(2, 4, 52, 76, Icon.TREE);
    buildRectangleTree(32, 34, 38, 76, Icon.TREE);
    buildRectangleTree(36, 38, 38, 56, Icon.TREE);
    buildRectangleTree(36, 38, 62, 72, Icon.TREE);
    buildRectangleTree(8, 32, 72, 74, Icon.TREE);
    buildRectangleTree(8, 10, 74, 82, Icon.TREE);
    buildRectangleTree(2, 6, 76, 94, Icon.TREE);
    buildRectangleTree(32, 34, 78, 88, Icon.TREE);
    buildRectangleTree(6, 34, 88, 94, Icon.TREE);
    buildRectangleTree(24, 26, 74, 84, Icon.TREE);
    buildRectangleTree(16, 18, 84, 88, Icon.TREE);
    buildRectangleTree(2, 38, 106, 108, Icon.TREE);
    buildRectangleTree(20, 34, 94, 100, Icon.TREE);
    buildRectangleTree(36, 38, 76, 78, Icon.REDTREE);
    buildRectangleTree(32, 34, 6, 8, Icon.REDTREE);
    buildRectangleTree(34, 36, 34, 36, Icon.REDTREE);
  }

  // build trees within the specified rectangle
  private void buildRectangleTree(int left, int right, int top, int bottom, Icon tree) {
    for (int x = left; x < right; x++) {
      for (int y = top; y < bottom; y++) { // block No.5 x: 12, y: 18-29, six trees
        if (x % 2 == 0 && y % 2 == 0) {
          highMap[x][y] = new UnitDraw(tree);
        } else {
          highMap[x][y] = new UnitDraw(Icon.BLOCK);
        }
      }
    }
  }

  void buildRoad() {
  }

  void buildWater() {
  }

  void buildBuilding() {
    buildSingleBuilding(2, 14, 95, 101, 2, 95, Icon.HALLOFFAME);
    highMap[13][94] = new UnitDraw(Icon.BLOCK);
    buildSingleBuilding(10, 18, 2, 10, 10, 3, Icon.LIBRARY);
    buildSingleBuilding(2, 8, 34, 39, 2, 35, Icon.HOUSEWODOOR);
    buildSingleBuilding(8, 14, 34, 39, 8, 35, Icon.POKEMONCENTER);
    buildSingleBuilding(14, 19, 34, 39, 14, 35, Icon.HOUSEWDOOR);
    buildSingleBuilding(26, 32, 53, 57, 26, 53, Icon.HOUSEWDOOR);
  }

  private void buildSingleBuilding(
          int left, int right, int top, int bottom, int buildingX, int buildingY, Icon icon) {
    for (int x = left; x < right; x++) {
      for (int y = top; y < bottom; y++) {
        if (x == buildingX && y == buildingY) {
          highMap[x][y] = new UnitDraw(icon);
        } else {
          highMap[x][y] = new UnitDraw(Icon.BLOCK);
        }
      }
    }
  }

  void buildNpc() {
    NPC npc;

    PokemonFactory pokemonFactory = new PokemonFactory();

    npc = new NPC("Professor.P", Duty.FIGHT);
    npc.setDialog("ready for your final exam? great!");
    npc.setInteractedDialogue("Good job!");
    npc.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.CHARIZARDSHINY, 50));
    buildSingleNpc(npc, Icon.PROFESSOR, 3, 10);

    npc = new NPC("Seller", Duty.SALE);
    npc.setDialog("How may I help you?");
    buildSingleNpc(npc, Icon.SELLER, 5, 10);

    npc = new NPC("Healer", Duty.HEAL);
    npc.setDialog("welcome to hospital????");
    buildSingleNpc(npc, Icon.HEALER, 7, 10);

        npc = new NPC("Charmander", Duty.CHARMANDER);
        npc.setDialog("This is a Charmander, do you wanna choose it?");
        npc.setInteractedDialogue("A Charmander...");
        buildSingleNpc(npc, Icon.POKEMONBALLONMAP, 5, 3);
        npcRepository.addBeginningPokemonNPC(npc);

        npc = new NPC("Squirtle", Duty.SQUIRTLE);
        npc.setDialog("This is a Squirtle, do you wanna choose it?");
        npc.setInteractedDialogue("A Squirtle...");
        buildSingleNpc(npc, Icon.POKEMONBALLONMAP, 8, 3);
        npcRepository.addBeginningPokemonNPC(npc);

        npc = new NPC("Bulbasaur", Duty.BULBASAUR);
        npc.setDialog("This is a Bulbasaur, do you wanna choose it?");
        npc.setInteractedDialogue("A Bulbasaur...");
        buildSingleNpc(npc, Icon.POKEMONBALLONMAP, 3, 3);
        npcRepository.addBeginningPokemonNPC(npc);

        npc = new NPC("JC", Duty.FIGHT);
        npc.setDialog("Ready for lose? Hummm...............");
        npc.setInteractedDialogue("That's a lucky shoot.........");
        npc.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.MEWTWO, 50));
        buildSingleNpc(npc, Icon.JESSE, 3, 6);

    npc = new NPC("Quincy", Duty.FIGHT);
    npc.setDialog("Pick the duck, lost the luck!!!");
    npc.setInteractedDialogue("psyduck...");
    npc.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PSYDUCK, 50));
    buildSingleNpc(npc, Icon.QUINCY, 4, 6);

    npc = new NPC("Deniska", Duty.FIGHT);
    npc.setDialog("Do. Or do not. There is no try.");
    npc.setInteractedDialogue("I am your father!");
    npc.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.CHARIZARDSHINY, 50));
    buildSingleNpc(npc, Icon.DENISKA, 5, 6);

    npc = new NPC("Joy", Duty.FIGHT);
    npc.setDialog("You are a loser!!");
    npc.setInteractedDialogue("I will be back!");
    npc.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 50));
    buildSingleNpc(npc, Icon.JOY, 6, 6);

    npc = new NPC("Yimi", Duty.FIGHT);
    npc.setDialog("Pikapika,Pikapika!! >w<");
    npc.setInteractedDialogue("Pikachu......");
    npc.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 50));
    buildSingleNpc(npc, Icon.YIMI, 7, 6);
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
