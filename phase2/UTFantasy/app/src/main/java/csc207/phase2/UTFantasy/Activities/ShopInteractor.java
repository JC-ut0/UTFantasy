package csc207.phase2.UTFantasy.Activities;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Products.Product;

public class ShopInteractor {

  //    /** the amount of money a player has */
  //    private int moneyLeft;
  /** the player */
  private Player player;
  /** The amount of product player wanted to buy */
  private int amount;

  private int total;
  private Product product;

  interface Listener {
    void showMessage(String tradeInfo);

    void updateMoneyLeft(int n);

    void updateProductsInBag(int n);

    void updateSelected(int n);
  }

  ShopInteractor(Player player) {
    this.player = player;
  }

  int countProducts(Product product) {
    Integer n = player.getBag().get(product);
    if (n != null) {
      return n;
    } else {
      return 0;
    }
  }

  int countMoney() {
    return player.getMoney();
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  int calculateTotal(int n) {
    return n * product.getPrice();
  }

  void trade(int total, int amount, Listener listener) {
    if (total != 0) {
      this.amount = amount;
      this.total = total;
      if (canAfford()) {
        int money = countMoney() - total;
        player.setMoney(money);
        player.addItem(product, amount);
        listener.updateMoneyLeft(money);
        listener.updateProductsInBag(countProducts(product));
        listener.showMessage("You have purchased " + amount + " " + product.getName() + "s.");
      } else {
        listener.showMessage("You don't Have enough money!");
        listener.updateSelected(0);
      }
    } else {
      listener.showMessage("Please add products!");
    }
  }

  private boolean canAfford() {
    return total <= countMoney();
  }

  int getMoneyLeft() {
    return countMoney();
  }
}
