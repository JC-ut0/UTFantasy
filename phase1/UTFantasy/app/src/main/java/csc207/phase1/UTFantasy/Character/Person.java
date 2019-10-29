package csc207.phase1.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Products.Product;

public class Person implements Serializable {
    /**
     * name of this person
     */
    protected String name;
    /**
     * first coordinate
     */
    protected int x;
    /**
     * second coordinate
     */
    protected int y;

    /**
     * pokemons that this person has
     */
    // todo: change name to pokemonList
    protected ArrayList<Pokemon> pokemon;
    /**
     * pokemons that this person has
     */
    protected int maxSizeOfPokmonList = 6;


    Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public ArrayList<Pokemon> getPokemonList() {
        return pokemon;
    }

    // TODO; set to boolean?
    public void addPokemon(Pokemon pokemon) {
        if (this.pokemon.size() >= maxSizeOfPokmonList) {
            return;
        }
        this.pokemon.add(pokemon);
        pokemon.setMaster(this);
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
