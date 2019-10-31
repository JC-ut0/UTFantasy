package csc207.phase1.UTFantasy.Character;

import java.util.HashMap;

import csc207.phase1.UTFantasy.Interface.Fighter;
import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.NPCManager;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.Products.RedPotion;

public class Player extends Person implements Fighter {


    /**
     * the npc manager this player belongs to
     */
    public NPCManager npcManager;

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

    public Player(String name, String gender) {
        super(name);
        this.gender = gender;
        this.money = 1000;
        this.bag = new HashMap<>();
        this.npcManager = new NPCManager();
        this.setLocation(5, 5);
        Pokemon pokemon = new Pikachu();
        pokemon.setLevel(1);
        addPokemon(pokemon);
        addItem(new RedPotion(), 1);
    }

    public HashMap<Product, Integer> getBag() {
        return bag;
    }

    public void addItem(Product item, int num) {
        if (bag.containsKey(item)) {
            bag.put(item, bag.get(item) + num);
        } else {
            bag.put(item, num);
        }

    }

    public void use(Product product, int num) {
        bag.put(product, bag.get(product) - num);
        //make sure you have enough products
    }


    public String getGender() {
        return gender;
    }

    public void move(String direction, MapManager mapManager) {
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

    public NPCManager getNpcManager() {
        return npcManager;
    }

    public String getDirection() {
        return direction;
    }

    public void addPokemon(Pokemon pokemon) {
        if (this.pokemon.size() >= maxSizeOfPokmonList) {
            return;
        }
        this.pokemon.add(pokemon);
        pokemon.setMaster(this);
    }
}
