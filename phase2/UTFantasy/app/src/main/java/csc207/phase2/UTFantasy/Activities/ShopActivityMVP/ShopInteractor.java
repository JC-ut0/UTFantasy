package csc207.phase2.UTFantasy.Activities.ShopActivityMVP;

import csc207.phase2.UTFantasy.Character.PlayerManager;
import csc207.phase2.UTFantasy.Products.Product;

public class ShopInteractor {

  /** the player */
  private PlayerManager playerManager;
  /** total cost of selected amount of product */
  private int total;
  /** the selected product */
  private Product product = null;

  ShopInteractor(PlayerManager playerManager) {
    this.playerManager = playerManager;
  }

  /** return the number of given product in player's bag */
  int countProducts(Product product) {
    Integer n = playerManager.getBag().get(product);
    if (n != null) {
      return n;
    } else {
      return 0;
    }
  }

  /** return amount of money in player's bag */
  int countMoney() {
    return playerManager.getMoney();
  }

  /** calculate total cost of given number of products */
  int calculateTotal(int n) {
    return n * product.getPrice();
  }

  /** Update the amount of product and money in player's bag. */
  void trade(int total, int amount, Listener listener) {
    if (total != 0) {
      this.total = total;
      if (canAfford()) {
        int money = countMoney() - total;
        playerManager.setMoney(money);
        playerManager.addItem(product, amount);
        listener.updateMoneyLeft(money);
        listener.updateProductsInBag(countProducts(product));
        listener.showMessage("You have purchased " + amount + " " + product.getName() + "（s）.");
      } else {
        listener.showMessage("You don't Have enough money!");
        listener.updateSelected(0);
      }
    } else {
      listener.showMessage("Please add products!");
    }
  }

  /** return the value of variable product */
  Product getProduct() {
    return product;
  }

  /** assign value to variable product */
  public void setProduct(Product product) {
    this.product = product;
  }

  /** Check if player has enough money to buy certain number of product. */
  private boolean canAfford() {
    return total <= countMoney();
  }

  /** return the image resource of product */
  int getProductImage() {
    return product.getProfile_id();
  }

  /** return the name of product */
  String getProductName() {
    return product.getName();
  }

  /** return the description of product */
  String getProductDescription() {
    return product.toString();
  }
  /** an interface used to interact with presenter */
  interface Listener {
    void showMessage(String tradeInfo);

    void updateMoneyLeft(int n);

    void updateProductsInBag(int n);

    void updateSelected(int n);
  }
}
