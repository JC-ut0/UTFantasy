package csc207.phase2.UTFantasy.mapDomain;

import csc207.phase2.UTFantasy.Character.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.WildPokemonObserver;
import csc207.phase2.UTFantasy.Pet.Charmander;
import csc207.phase2.UTFantasy.Pet.Pikachu;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.npcDomain.NPCRepository;

public class WildPokemonChecker implements WildPokemonObserver {
    private Player player;
    private Map map;
    private MapDrawer drawer;

    public WildPokemonChecker(Player player, Map map, MapDrawer drawer) {
        this.player = player;
        this.map = map;
        this.drawer = drawer;
    }

    @Override
    public void checkWildPokeBattle() {
        int x = player.getX();
        int y = player.getY();
        Icon icon = map.getLowMap()[x][y].getIcon();
        double rate = 0;
        Pokemon pokemon = null;
        switch (icon) {
            case GRASS0:
                rate = 0.2;
                pokemon = new Pikachu();
                pokemon.setLevel(7);
                break;
            case GRASS1:
                rate = 0.01;
                pokemon = new Charmander();
                pokemon.setLevel(5);
        }
        if (rate != 0) {
            double r = Math.random();
            if (r <= rate) {
                NPC npc = new NPC("wild pokemon", Duty.FIGHT);
                npc.addPokemon(pokemon);
                NPCRepository npcRepository = player.getPlayerMap().getNpcRepository();
                npcRepository.addNPC(npc.getName(), npc);
                drawer.goToBattleActivity(npc.getName());
            }
        }
    }
}
