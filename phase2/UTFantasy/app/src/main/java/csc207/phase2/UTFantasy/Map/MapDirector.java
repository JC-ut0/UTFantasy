package csc207.phase2.UTFantasy.Map;

import csc207.phase2.UTFantasy.Character.Player;

public class MapDirector {
  private Map map;
  private Player player;
  private MapInteractor mapInteractor;

  public MapDirector(Player player) {
    this.player = player;
  }

  public void constructMap() {
    MapBuilder mapBuilder = new MapBuilder();
    mapBuilder.buildLawn();
    mapBuilder.buildTree();
    mapBuilder.buildRoad();
    mapBuilder.buildWater();
    mapBuilder.buildNpc();
    map = mapBuilder.getProduct();
    player.setPlayerMap(map);
    constructMapFacade();
  }

  private void constructMapFacade() {
    MapChecker mapChecker = new MapChecker(player);
    ScreenUpdater screenUpdater = new ScreenUpdater(player);
    MovementManager movementManager = new MovementManager(player);
    ScreenTranser screenTranser = new ScreenTranser(player);
    mapInteractor = new MapFacade(mapChecker, screenUpdater, movementManager, screenTranser);
  }

  public MapInteractor getMapInteractor() {
    return mapInteractor;
  }

    public NPCInteractor getNPCInteractor() {
        return new NPCInteractor(player);
    }
}
