package csc207.phase1.UTFantasy;


import java.util.ArrayList;

class Person {
    /**
     * name of this person*/
    private String name;
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

    private String gender;
    private ArrayList<String> bag;

    ArrayList<String> getBag(){
        return bag;
    }

    void setBag(String item){
        bag.add(item);
    }


    private ArrayList<Pokemon> pokemon;
    ArrayList<Pokemon> getPokemon(){
        return pokemon;
    }

    void setPokemon(Pokemon pokemon){
        this.pokemon.add(pokemon);
    }

}
