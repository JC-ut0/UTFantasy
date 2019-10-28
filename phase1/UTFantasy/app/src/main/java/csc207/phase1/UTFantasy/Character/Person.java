package csc207.phase1.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;

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
     * objects in this person's bag
     */
    protected ArrayList<Product> bag;
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

    Person(String name) {
        this.name = name;
        this.bag = new ArrayList<>();
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

    public ArrayList<Product> getBag() {
        return bag;
    }

    public void setBag(Product item) {
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
