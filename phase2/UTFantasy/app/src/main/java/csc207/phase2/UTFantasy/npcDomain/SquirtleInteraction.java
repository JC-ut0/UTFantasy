package csc207.phase2.UTFantasy.npcDomain;

import java.util.List;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Charmander;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.Squirtle;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapDomain.MapDrawer;

public class SquirtleInteraction extends Interaction {

    public SquirtleInteraction(MapDrawer drawer, Player player) {
        super(drawer, player);
    }

    @Override
    public void openDialogue(NPC npc) {
        super.openDialogue(npc);
        drawer.display(R.drawable.squirtle);
    }

    @Override
    public void interact(NPC npc) {
        Pokemon squirtle = new Squirtle();
        squirtle.setLevel(5);
        player.addPokemon(squirtle);
        List<NPC> beginningPokemonNPCs =
                player.getPlayerMap().getNpcRepository().getBeginningPokemonNPCs();
        for (NPC pokemonNPC : beginningPokemonNPCs) {
            pokemonNPC.setInteracted(true);
        }
        drawer.popText("Congratulations! You get a charmander!!!");
    }
}
