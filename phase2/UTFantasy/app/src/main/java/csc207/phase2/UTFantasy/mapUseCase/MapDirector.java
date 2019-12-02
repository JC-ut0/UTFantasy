package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.npcDomain.NPCInteractor;

/**
 * The director that uses MapBuilder to build the map
 */
public class MapDirector {
    private Player player;
    private MapInteractor mapInteractor;

    public MapDirector(Player player) {
        this.player = player;
    }

    public void constructMap() {
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.buildLawn();
        mapBuilder.buildGrass();
        mapBuilder.buildTree();
        mapBuilder.buildRoad();
        mapBuilder.buildWater();
        mapBuilder.buildBuilding();
        mapBuilder.buildNpc();
        Map map = mapBuilder.getProduct();
        player.setPlayerMap(map);
        constructMapFacade();
    }

    private void constructMapFacade() {
        MapChecker mapChecker = new MapChecker(player);
        ScreenUpdater screenUpdater = new ScreenUpdater(player);
        MovementManager movementManager = new MovementManager(player);
        ScreenTranser screenTranser = new ScreenTranser(player);
        mapInteractor = new MapFacadeInteractor(mapChecker, screenUpdater, movementManager, screenTranser);
    }

    public MapInteractor getMapInteractor() {
        return mapInteractor;
    }

    public NPCInteractor getNPCInteractor() {
        return new NPCInteractor(player);
    }

    public EvolutionChecker getEvolutionChecker() {
        return new EvolutionChecker(player);
    }
}
