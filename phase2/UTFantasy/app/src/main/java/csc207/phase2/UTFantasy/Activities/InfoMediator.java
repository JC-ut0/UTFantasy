package csc207.phase2.UTFantasy.Activities;

import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class InfoMediator {
  /** the player. */
  private final Player player;
  /** the description of this character. */
  private String description;

  /**
   * the constructor of the InfoMediator.
   *
   * @param player the player
   */
  public InfoMediator(Player player) {
    this.player = player;
    this.setDescription("This is the character in U of T.");
  }

  /**
   * set the selected product selected by the player during battle.
   *
   * @param selectedProduct the product selected
   */
  public void setSelectedPokemon(Product selectedProduct) {
    player.setSelectedProduct(selectedProduct);
  }

  /**
   * get the description of the player.
   *
   * @return string of the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * set the description of the player.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * get the list of the pokemon of the player.
   *
   * @return list of Pokemon
   */
  public List<Pokemon> getPokemonList() {
    return player.getPokemonList();
  }

  /**
   * get the HashMap of the bag of the player
   *
   * @return the HashMap of bag
   */
  public HashMap<Product, Integer> getProductHashMap() {
    return player.getBag();
  }

  /**
   * get the gender of the player
   *
   * @return string of gender
   */
  String getGender() {
    if (player.getGender().equals("boy")) {
      return "Gender: Male";
    } else {
      return "Gender: Female";
    }
  }

  /**
   * get the image of the gender
   *
   * @return gender image
   */
  int getGenderImage() {
    if (player.getGender().equals("boy")) {
      return R.drawable.charater_male;
    } else {
      return R.drawable.character_female;
    }
  }

  /**
   * get the money of the player
   *
   * @return amount of money
   */
  public String getMoney() {
    return "Money: $" + player.getMoney();
  }

  /**
   * swap the pokemon to the first one
   *
   * @param position position of the pokemon in the ListView
   */
  public void swapPokemon(int position) {
    player.swapPokemon(position);
  }

  /**
   * discard of the pokemon you selected
   *
   * @param position position of the pokemon in the ListView
   */
  public void discardPokemon(int position) {
    player.discardPokemon(position);
  }

  /** reset the product to be not selected. */
  public void resetSelect() {
    for (Product product : player.getBag().keySet()) {
      product.setSelected(false);
    }
  }
}
