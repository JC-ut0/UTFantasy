package csc207.phase2.UTFantasy.Activities;

import csc207.phase2.UTFantasy.Products.Product;

public interface ShopView {
  void showMessage(String message);

  void setButtons();

  void setProductSelected(String text);

  void setProductInBag(String text);

  void setMoneyLeft(String text);

  void setTotalMoney(String text);

  void setProductInfo(Product product);
}
