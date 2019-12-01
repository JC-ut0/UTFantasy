package csc207.phase2.UTFantasy.npcDomain;

import java.util.List;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapDomain.MapDrawer;

public class CharmanderInteraction extends Interaction {

    public CharmanderInteraction(MapDrawer drawer, Player player) {
        super(drawer, player);
    }

    @Override
    public void openDialogue(NPC npc) {
        super.openDialogue(npc);
        drawer.display(R.drawable.charmander);
    }

    @Override
    public void interact(NPC npc) {
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon charmander = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.CHARMANDER, 5);
        player.addPokemon(charmander);
        List<NPC> beginningPokemonNPCs =
                player.getPlayerMap().getNpcRepository().getBeginningPokemonNPCs();
        for (NPC pokemonNPC : beginningPokemonNPCs) {
            pokemonNPC.setInteracted(true);
        }
        drawer.popText("Congratulations! You get a charmander!!!");
    }
}
