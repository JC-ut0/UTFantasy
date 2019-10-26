package csc207.phase1.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

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
     * gender of this person
     */
    protected String gender;
    /**
     * objects in this person's bag
     */
    protected ArrayList<String> bag;
    /**
     * pokemons that this person has
     */
    // todo: change name to pokemonList
    protected ArrayList<Pokemon> pokemon;
    /**
     * pokemons that this person has
     */
    protected int maxSizeOfPokmonList = 6;

    Person() {
    }

    Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.bag = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public String getGender() {
        return gender;
    }


    ArrayList<String> getBag() {
        return bag;
    }

    public void setBag(String item) {
        bag.add(item);
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
