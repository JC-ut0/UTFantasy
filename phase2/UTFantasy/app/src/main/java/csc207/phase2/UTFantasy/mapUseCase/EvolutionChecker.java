package csc207.phase2.UTFantasy.mapUseCase;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class EvolutionChecker {
    private Player player;
    private MapDrawer drawer;

    EvolutionChecker(Player player) {
        this.player = player;
    }

    public void setDrawer(MapDrawer drawer) {
        this.drawer = drawer;
    }

    public void checkEvolution() {
        for (int i = 0; i < player.getPokemonList().size(); i++) {
            Pokemon pokemon = player.getPokemonList().get(i);
            if (pokemon != null
                    && pokemon.getEvolution() != null
                    && pokemon.getLevelToEvolve() == pokemon.getLevel()) {
                drawer.goToEvolutionActivity(i);
            }
        }
    }
}
