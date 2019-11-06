package csc207.phase1.UTFantasy.Character;

import java.util.HashMap;

import csc207.phase1.UTFantasy.AllSkills.Flamethrower;
import csc207.phase1.UTFantasy.Interface.Fighter;
import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.NPCManager;
import csc207.phase1.UTFantasy.Pet.Charmander;
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
    /** objects in this person's bag */

    /**
     * a RedPotion
     */
    RedPotion redPotion = RedPotion.getRed();

    protected HashMap<Product, Integer> bag;


    // =======================================================================

    /**
     * construct a new player
     *
     * @param name   the name of the player
     * @param gender the gender of the player
     */
    public Player(String name, String gender) {
        super(name);
        this.gender = gender;
        this.money = 1000;
        this.bag = new HashMap<>();
        this.npcManager = new NPCManager();
        this.setLocation(10, 10);
        Pokemon pokemon = new Pikachu();
        pokemon.setLevel(5);
        addPokemon(pokemon);
        pokemon = new Charmander();
        pokemon.setLevel(5);
        pokemon.updateSkills(new Flamethrower(), pokemon.getSkills()[1]);
        addPokemon(pokemon);
        addItem(redPotion, 1);
    }

    /**
     * @return the bag of this player
     */
    public HashMap<Product, Integer> getBag() {
        return bag;
    }

    /**
     * @param item the product that is gonna be added to this player's bag
     * @param num  the number of item that is added to this player's bag
     */
    public void addItem(Product item, int num) {
        if (bag.containsKey(item)) {
            try {
                //noinspection ConstantConditions
                bag.put(item, bag.get(item) + num);
            } catch (NullPointerException e) {
                System.out.println("bag does not contain");
            }
        } else {
            bag.put(item, num);
        }
    }

//  /**
//   * @param product the product that is used
//   * @param num the number of product that is used
//   */
//  public void use(Product product, int num) throws ProductNotEnoughException {
//    try {
//      bag.put(product, bag.get(product) - num);
//    } catch (NullPointerException e) {
//      System.out.println("bag does not contain this product");
//    }
//    // make sure you have enough products
//
//    if (bag.get(product) < 0) {
//      throw new ProductNotEnoughException("number of item is negative");
//    } else if (bag.get(product) == 0) {
//      bag.remove(product);
//    }
//  }

    public String getGender() {
        return gender;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public NPCManager getNpcManager() {
        return npcManager;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void addPokemon(Pokemon pokemon) {
        if (this.pokemon.size() >= maxSizeOfPokemonList) {
            return;
        }
        this.pokemon.add(pokemon);
        pokemon.setMaster(this);
    }

    /**
     * @return true iff there is at least one non-fainted pokemon.
     */
    public boolean isFightAble() {
        for (Pokemon pokemon : getPokemonList()) {
            if (pokemon.isAlive()) return true;
        }
        return false;
    }
}
