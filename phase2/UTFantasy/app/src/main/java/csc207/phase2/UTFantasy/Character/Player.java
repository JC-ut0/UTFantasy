package csc207.phase2.UTFantasy.Character;

import androidx.annotation.NonNull;

import java.util.HashMap;

import csc207.phase2.UTFantasy.Map.Map;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.Product;

public class Player extends Person {

  private int x;
  private int y;
  private String gender;
  private Map playerMap;
  private HashMap<Product, Integer> bag;
  private boolean showingScore = true;

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
    this.setX(10);
    this.setY(10);
    this.setDirection("down");
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

  public String getGender() {
    return gender;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public Map getPlayerMap() {
    return playerMap;
  }

  public void setPlayerMap(Map map) {
    this.playerMap = map;
  }

  public HashMap<Product, Integer> getBag() {
    return bag;
  }

  /** add num of item's to the player's bag */
  public void addItem(Product item, int num) {
    try {
      //noinspection ConstantConditions
      bag.put(item, bag.get(item) + num);
    } catch (NullPointerException e) {
      bag.put(item, num);
    }
  }

  @NonNull
  @Override
  public String toString() {
    return "Player: "
        + name
        + ", "
        + gender
        + ", PokemonNum: "
        + pokemonList.size()
        + ", TotalLV: ."
        + getPlayerPokemonLV()
        + ".";
  }

  public int getPlayerPokemonLV() {
    int totalLV = 0;
    for (Pokemon pokemon : pokemonList) {
      totalLV += pokemon.getLevel();
    }
    return totalLV;
  }

  public boolean isShowingScore() {
    return showingScore;
  }

  public void setShowingScore(boolean showingScore) {
    this.showingScore = showingScore;
  }

  public void useProduct(Product product){
    Integer num = bag.get(product);
    if (num != null){
      bag.put(product, num - 1);
      if (num == 0){
        bag.remove(product);
      }
    }
  }
}
