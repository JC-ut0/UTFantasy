package csc207.phase1.UTFantasy.Character;

import java.util.HashMap;

import csc207.phase1.UTFantasy.Interface.Fighter;
import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Products.Product;

public class Player extends Person implements Fighter {
    /**
     * the map manager this player belongs to
     */
    public MapManager mapManager;
    /**
     * the amount this player has
     */
    private int money;

    /**
     * gender of this person
     */
    protected String gender;

    /**
     * the direction that the player is facing to
     */
    public String direction = "down";
    /**
     * objects in this person's bag
     */
    protected HashMap<Product, Integer> bag;

    public HashMap<Product, Integer> getBag() {
        return bag;
    }

    public void setBag(Product item, int num) {
        if (bag.containsKey(item)){
            bag.put(item, bag.get(item) + num);
        }else{
            bag.put(item, num);
        }

    }

    public void use(Product product, int num){
        bag.put(product, bag.get(product) - num);
        //make sure you have enough products
    }


    public Player(String name, String gender) {
        super(name);
        this.gender = gender;
        this.money = 0;
        this.bag = new HashMap<>();
    }

    public String getGender() {
        return gender;
    }

    public void move(String direction) {
        switch (direction) {
            case ("left"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() - 1 && getX() - 1 <
                            block[1] + 1 && block[2] - 0.75 < getY() && getY() < block[3] + 2) {
                        x += 1;
                        break;
                    }
                }
                x -= 1;
                break;
            case ("right"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() + 1 && getX() + 1 <
                            block[1] + 1 && block[2] - 0.75 < getY() && getY() < block[3] + 2) {
                        x -= 1;
                    }
                }
                x += 1;
                break;
            case ("up"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() && getX() <
                            block[1] + 1 && block[2] - 0.75 < getY() - 1 && getY() - 1 < block[3] + 2) {
                        y += 1;
                    }
                }
                y -= 1;
                break;
            case ("down"):
                for (double[] block : mapManager.blockMap) {
                    if (block[0] - 0.5 < getX() - 1 && getX() <
                            block[1] + 1 && block[2] - 0.75 < getY() + 1 && getY() + 1 < block[3] + 2) {
                        y -= 1;
                    }
                }
                y += 1;
                break;
        }
        this.direction = direction;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    /**
     * Fight,
     * 1. choose pokemonList,
     * 2. choose skill want to use or item want to use,
     * 3. wait for opponent,
     * 4. start this round, check for speed of the pokemonList, start attack with the higher one.
     * 5. hp get reduced
     * 6. check whether the blood == 0 ,
     * 7. exp
     */
    void fight(Pokemon pokemon) {

    }

    public void addPokemon(Pokemon pokemon) {
        if (this.pokemon.size() >= maxSizeOfPokmonList) {
            return;
        }
        this.pokemon.add(pokemon);
        pokemon.setMaster(this);
    }
}
