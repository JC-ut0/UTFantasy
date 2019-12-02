package csc207.phase2.UTFantasy.Activities.evolutionUI;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class EvolutionPresenter {
  private EvolutionActivityModel activityModel;
  private Player player;
  private Pokemon pokemon;
  private int pokemonIndex;
  /** represents if the animation of evolution is displaying */
  private boolean isOnGoing;
  /** representes if this activity is supposed to be ended in next user's interaction */
  private boolean isEnding;

  EvolutionPresenter(EvolutionActivityModel activityModel, Player player) {
    this.activityModel = activityModel;
    this.player = player;
    isOnGoing = false;
  }

  /**
   * set the starting pokemon image and text to display.
   *
   * @param pokemonIndex the evolving pokemon is the pokemonIndex-th pokemon in the player's bag
   */
  public void setPokemon(int pokemonIndex) {
    this.pokemonIndex = pokemonIndex;
    pokemon = player.getPokemonList().get(pokemonIndex);
    String text = "Something is happening to " + pokemon.getPokemonName() + "!";
    activityModel.showText(text);
    activityModel.showImg(pokemon.getProfileID());
  }

  /**
   * confirm the animation to start or confirm the evolution to be done or confirm the activity is
   * finished depending on the progress of evolution
   */
  void confirm() {
    if (!isOnGoing && !isEnding) {
      activityModel.runAnimation(pokemon.getProfileID(), pokemon.getEvolution().getProfileID());
      isOnGoing = true;
    } else if (!isEnding) {
      activityModel.showImg(pokemon.getEvolution().getProfileID());
      player.getPokemonList().set(pokemonIndex, pokemon.getSelfEvolved());
      String text =
          "Congratulations! "
              + pokemon.getPokemonName()
              + " has evolved into "
              + pokemon.getEvolution().getPokemonName()
              + "!!!";
      activityModel.showText(text);
      isOnGoing = false;
      isEnding = true;
    } else {
      activityModel.end();
    }
  }

  /**
   * cancel the evolution and set this pokemon enable to evolve anymore or confirm the activity is
   * finished depending on the progress of evolution
   */
  void cancel() {
    if (isOnGoing) {
      activityModel.showImg(pokemon.getProfileID());
      String text = player.getPokemonList().get(pokemonIndex).getPokemonName() + " didn't evolved.";
      pokemon.deleteEvolution();
      activityModel.showText(text);
      isOnGoing = false;
      isEnding = true;
    } else if (isEnding) {
      activityModel.end();
    }
  }
}
