package csc207.phase1.UTFantasy.Interface;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

/**
 * All objects which are able to fight.
 */
public interface Fighter {
    String getName();
    void addPokemon(Pokemon pokemon);
    ArrayList<Pokemon> getPokemonList();
}
