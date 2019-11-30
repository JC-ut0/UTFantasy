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

  private String description;

  public InfoMediator(Player player) {
    this.player = player;
    this.setDescription("This is the character in U of T.");
  }

  void setSelectedPokemon(Product selectedProduct) {
    player.setSelectedProduct(selectedProduct);
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  List<Pokemon> getPokemonList() {
    return player.getPokemonList();
  }

  HashMap<Product, Integer> getProductHashMap() {
    return player.getBag();
  }

  String getGender() {
    if (player.getGender().equals("boy")) {
      return "Gender: Male";
    } else {
      return "Gender: Female";
    }
  }

  int getGenderImage() {
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
