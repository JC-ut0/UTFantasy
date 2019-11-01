package csc207.phase1.UTFantasy.Character;

import java.util.HashMap;

import csc207.phase1.UTFantasy.Interface.Fighter;
import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.NPCManager;
import csc207.phase1.UTFantasy.Pet.Charmander;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.Products.RedPotion;

public class Player extends Person implements Fighter {

  /** the npc manager this player belongs to */
  public NPCManager npcManager;

  /** the amount this player has */
  private int money;

  /** gender of this person */
  protected String gender;

  /** the direction that the player is facing to */
  public String direction = "down";
  /** objects in this person's bag */

  /** a RedPotion */
  RedPotion redPotion = RedPotion.getRed();

  protected HashMap<Product, Integer> bag;

  /**
   * construct a new player
   *
   * @param name the name of the player
   * @param gender the gender of the player
   */
  public Player(String name, String gender) {
    super(name);
    this.gender = gender;
    this.money = 1000;
    this.bag = new HashMap<>();
    this.npcManager = new NPCManager();
    this.setLocation(5, 5);
    Pokemon pokemon = new Pikachu();
    pokemon.setLevel(5);
    addPokemon(pokemon);
    pokemon = new Charmander();
    pokemon.setLevel(5);
    addPokemon(pokemon);
    addItem(redPotion, 1);
  }

  /** @return the bag of this player */
  public HashMap<Product, Integer> getBag() {
    return bag;
  }

  /**
   * @param item the product that is gonna be added to this player's bag
   * @param num the number of item that is added to this player's bag
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

  public void move(String direction, MapManager mapManager) {
    switch (direction) {
      case ("left"):
        if (checkBlockMap(mapManager, x - 1, y)) {
          x -= 1;
        }
        break;
      case ("right"):
        if (checkBlockMap(mapManager, x + 1, y)) {
          x += 1;
        }
        break;
      case ("up"):
        if (checkBlockMap(mapManager, x, y - 1)) {
          y -= 1;
          break;
        }
      case ("down"):
        if (checkBlockMap(mapManager, x, y + 1)) {
          y += 1;
        }
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
   * @param mapManager the mapManager that is holding all the blocks
   * @param x the x value of the position that we are checking
   * @param y the y value of the position that we are checking
   * @return false iff position (x, y) is within at least of block (a rectangle) holden by mapManager
   */
  private boolean checkBlockMap(MapManager mapManager, int x, int y) {
    for (double[] block : mapManager.blockMap) {
      if (block[0] - 0.5 < x && x < block[1] + 1 && block[2] - 0.75 < y && y < block[3] + 2) {
        return false;
      }
    }
    return true;
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
