package csc207.phase2.UTFantasy.npcUseCase;

import java.util.List;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

class BulbasaurInteraction extends Interaction {

  BulbasaurInteraction(MapDrawer drawer, Player player) {
    super(drawer, player);
  }

  @Override
  public void openDialogue(NPC npc) {
    super.openDialogue(npc);
    drawer.display(R.drawable.bulbasaur);
  }

  @Override
  public void interact(NPC npc) {
    PokemonFactory pokemonFactory = new PokemonFactory();
    Pokemon bulbasaur = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.BULBASAUR, 5);
    player.addPokemon(bulbasaur);
    List<NPC> beginningPokemonNPCs =
        player.getPlayerMap().getNpcRepository().getBeginningPokemonNPCs();
    for (NPC pokemonNPC : beginningPokemonNPCs) {
      pokemonNPC.setInteracted(true);
    }
    drawer.popText("Congratulations! You get a Bulbasaur!!!");
  }
}
