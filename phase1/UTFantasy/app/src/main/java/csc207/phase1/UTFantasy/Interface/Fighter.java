package csc207.phase1.UTFantasy.Interface;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

/**
 * All objects which are able to fight.
 */
public interface Fighter {

    /**
     * @return the name of this fighter
     */
    String getName();

    /**
     * add this pokemon to this fighter's pokemon list
     * @param pokemon the pokemon to this fighter's pokemon list
     */
    void addPokemon(Pokemon pokemon);

    /**
     * @return the pokemon list of this fighter
     */
    ArrayList<Pokemon> getPokemonList();

    /**
     * @return true iff this fighter has at least one non-fainted pokemon
     */
    boolean isFightAble();
}
