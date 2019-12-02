package csc207.phase2.UTFantasy.mapUseCase;

import java.io.Serializable;

import csc207.phase2.UTFantasy.Character.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.WildPokemonObserver;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
import csc207.phase2.UTFantasy.npcUseCase.NPCRepository;

/**
 * Responsible for determine if the player encounters a wild pokemon
 * Player encounters wild pokemon iff he or she is walking in the grass
 */
public class WildPokemonChecker implements WildPokemonObserver, Serializable {
    private Player player;
    private Map map;
    private MapDrawer drawer;
    private PokemonFactory pokemonFactory;

    public WildPokemonChecker(Player player, MapDrawer drawer) {
        this.player = player;
        this.drawer = drawer;
        pokemonFactory = new PokemonFactory();
        this.map = player.getPlayerMap();
    }

    @Override
    public void checkWildPokeBattle() {
        int x = player.getX();
        int y = player.getY();
        Icon icon = map.getLowMap()[x][y].getIcon();
        double rate = 0;
        Pokemon pokemon = null;
        // check if the player is standing on some grass
        switch (icon) {
            case GRASS0:
                rate = 0.2;
                pokemon = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 7);
                break;
            case GRASS1:
                rate = 0.5;
                pokemon = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.CHARIZARD, 5);
                break;
        }
        // determine if the player encounters the pokemon
        if (rate != 0) {
            double r = Math.random();
            if (r <= rate && player.isFightAble()) {
                pokemon.setWild(true);
                NPC npc = new NPC("wild pokemon", Duty.FIGHT);
                npc.addPokemon(pokemon);
                NPCRepository npcRepository = player.getPlayerMap().getNpcRepository();
                npcRepository.addNPC(npc.getName(), npc);
                drawer.goToBattleActivity(npc.getName());
            }
        }
    }
}
