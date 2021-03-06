package csc207.phase2.UTFantasy.npcUseCase;

import java.util.List;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

/** Represents that this NPC will giveaway a Squirtle(Pokemon). */
class SquirtleInteraction extends Interaction {

  SquirtleInteraction(MapDrawer drawer, Player player) {
    super(drawer, player);
  }

  @Override
  public void openDialogue(NPC npc) {
    super.openDialogue(npc);
    drawer.display(R.drawable.squirtle);
  }

  @Override
  public void interact(NPC npc) {
    PokemonFactory pokemonFactory = new PokemonFactory();
    Pokemon squirtle = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.SQUIRTLE, 5);
    player.addPokemon(squirtle);
    List<NPC> beginningPokemonNPCs =
        player.getPlayerMap().getNpcRepository().getBeginningPokemonNPCs();
    for (NPC pokemonNPC : beginningPokemonNPCs) {
      pokemonNPC.setInteracted(true);
    }
    drawer.popText("Congratulations! You get a squirtle!!!");
  }
}
