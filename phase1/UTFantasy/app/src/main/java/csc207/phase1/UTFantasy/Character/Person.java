package csc207.phase1.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

class Person implements Serializable {
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
    protected ArrayList<Pokemon> pokemon;

    Person() {
    }

    Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.bag = new ArrayList<>();
        this.pokemon = new ArrayList<Pokemon>();
    }

    String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    void set(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public String getGender() {
        return gender;
    }


    public ArrayList<String> getBag() {
        return bag;
    }

    public void setBag(String item) {
        bag.add(item);
    }


    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }


    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
