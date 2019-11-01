package csc207.phase1.UTFantasy.Interface;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

public interface Fighter {
    public String getName();
    public void addPokemon(Pokemon pokemon);
    public ArrayList<Pokemon> getPokemonList();
}
