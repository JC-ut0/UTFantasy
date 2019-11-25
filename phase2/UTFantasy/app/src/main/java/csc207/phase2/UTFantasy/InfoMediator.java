package csc207.phase2.UTFantasy;

import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.Product;

public class InfoMediator {
  /** the player. */
  private final Player player;

  private String description;

  private Product selectedProduct;

  public InfoMediator(Player player) {
    this.player = player;
    this.setDescription("This is the character in U of T.");
  }

  public Product getselectedProduct() {
    return selectedProduct;
  }

  public void setSelectedPokemon(Product selectedProduct) {
    this.selectedProduct = selectedProduct;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Pokemon> getPokemonList() {
    return player.getPokemonList();
  }

  public HashMap<Product, Integer> getProductHashMap() {
    return player.getBag();
  }

  public String getGender() {
    if (player.getGender().equals("boy")) {
      return "Gender: Male";
    } else {
      return "Gender: Female";
    }
  }

  public int getGenderImage() {
    if (player.getGender().equals("boy")) {
      return R.drawable.charater_male;
    } else {
      return R.drawable.character_female;
    }
  }

  public String getMoney() {
    return "Money: $" + player.getMoney();
  }
}
