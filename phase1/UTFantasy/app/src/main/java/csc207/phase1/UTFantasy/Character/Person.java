package csc207.phase1.UTFantasy.Character;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Pet.Pokemon;

class Person {

    Person(String name, String gender){
        this.name = name;
        this.gender = gender;
        this.bag = new ArrayList<>();
        this.pokemon = new ArrayList<Pokemon>();
    }
    /**
     * name of this person*/
    private String name;

    String getName(){
        return name;
    }

    /**
     * first coordinate*/
    private int x;

    int getX(){
        return x;
    }
    void set(int x){
        this.x = x;
    }
    /**
     * second coordinate*/
    private int y;

    int getY(){
        return y;
    }
    void setY(int y){
        this.y = y;
    }
    /**
     * gender of this person*/
    private String gender;

    String getGender(){
        return gender;
    }

    /**
     * objects in this person's bag*/
    private ArrayList<String> bag;

    ArrayList<String> getBag(){
        return bag;
    }

    void setBag(String item){
        bag.add(item);
    }

    /**
     * pokemons this person has*/
    private ArrayList<Pokemon> pokemon;

    ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }

    void setPokemon(Pokemon pokemon){
        this.pokemon.add(pokemon);
    }


    void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
