package csc207.phase2.UTFantasy.Activities.evolutionUI;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class EvolutionPresenter {
    private EvolutionActivityModel activityModel;
    private Player player;
    private int pokemonIndex;
    /**
     * represents if the animation of evolution is displaying
     */
    private boolean isOnGoing;
    private boolean isEnding;


    public EvolutionPresenter(EvolutionActivityModel activityModel, Player player) {
        this.activityModel = activityModel;
        this.player = player;
        isOnGoing = false;
    }

    public void setPokemon(int pokemonIndex) {
        this.pokemonIndex = pokemonIndex;
    }

    public void confirm() {
        Pokemon pokemon = player.getPokemonList().get(pokemonIndex);
        if (!isOnGoing && !isEnding) {
            activityModel.runAnimation(pokemon.getProfileID(), pokemon.getEvolution().getProfileID()
            );
            isOnGoing = true;
        } else if (!isEnding) {
            player.getPokemonList().set(pokemonIndex, pokemon.getSelfEvolved());
            String text = "Congratulations! " + pokemon.getPokemonName() + " has evolved into " + pokemon.getEvolution().getPokemonName() + "!!!";
            activityModel.showText(text);
            isOnGoing = false;
            isEnding = true;
        } else {
            activityModel.end();
        }
    }

    public void cancel() {
        if (isOnGoing) {
            String text = player.getPokemonList().get(pokemonIndex).getPokemonName() + " didn't evolved.";
            activityModel.showText(text);
            isOnGoing = false;
            isEnding = true;
        } else if (isEnding) {
            activityModel.end();
        }
    }
}
