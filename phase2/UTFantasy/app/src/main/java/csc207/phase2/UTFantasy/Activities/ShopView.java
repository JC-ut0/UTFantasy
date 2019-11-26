package csc207.phase2.UTFantasy.Activities;

public interface ShopView {
  void showMessage(String message);

  void setProductSelected(String text);

  void setProductInBag(String text);

  void setMoneyLeft(String text);

  void setTotalMoney(String text);

  void setProductInfo(int res, String name, String description);
}
