package csc207.phase2.UTFantasy.Character;

import java.util.HashMap;

import csc207.phase2.UTFantasy.Products.Product;

/** PlayerManager */
public class PlayerManager {
  private Player player;

  public PlayerManager(Player player) {
    this.player = player;
  }

  public void addItem(Product item, int num) {
    player.addItem(item, num);
  }

  public void deleteItem(Product product) {
      player.useItem(product);
  }

  public int getMoney() {
    return player.getMoney();
  }

  public void setMoney(int money) {
    player.setMoney(money);
  }

  public HashMap<Product, Integer> getBag() {
    return player.getBag();
  }
}
