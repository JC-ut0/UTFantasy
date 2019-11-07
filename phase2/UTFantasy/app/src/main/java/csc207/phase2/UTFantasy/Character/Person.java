package csc207.phase2.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase2.UTFantasy.Pet.Pokemon;

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
    protected int maxSizeOfPokemonList = 6;


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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemon;
    }

    // TODO; set to boolean?
    public void addPokemon(Pokemon pokemon) {
        if (this.pokemon.size() >= maxSizeOfPokemonList) {
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
