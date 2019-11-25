package csc207.phase2.UTFantasy.Activities;

public interface ShopView {
  void showMessage(String message);

  void setButtons();

  void setProductSelected(String text);

  void setProductInBag(String text);

  void setMoneyLeft(String text);

  void setTotalMoney(String text);
}
