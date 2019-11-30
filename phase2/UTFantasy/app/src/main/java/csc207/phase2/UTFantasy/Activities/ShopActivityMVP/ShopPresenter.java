package csc207.phase2.UTFantasy.Activities.ShopActivityMVP;

import csc207.phase2.UTFantasy.Products.Product;

public class ShopPresenter implements ShopInteractor.Listener {
  private ShopInteractor shopInteractor;
  private ShopView shopView;

  ShopPresenter(ShopInteractor shopInteractor, ShopView shopView) {
    this.shopInteractor = shopInteractor;
    this.shopView = shopView;
  }

  /***
   * Update all information of the product and initialize the TextViews.
   * @param product the chosen product
   */
  void updateAll(Product product) {
    shopInteractor.setProduct(product);
    int n = shopInteractor.countProducts(product);
    int money = shopInteractor.countMoney();
    int res = shopInteractor.getProductImage();
    String name = shopInteractor.getProductName();
    String description = shopInteractor.getProductDescription();
    if (shopView != null) {
      shopView.setTotalMoney("0");
      shopView.setProductSelected("0");
      shopView.setProductInBag(String.valueOf(n));
      shopView.setMoneyLeft(String.valueOf(money));
      shopView.setProductInfo(res, name, description);
    }
  }

  /** return the chosen product*/
  Product getProduct() {
    return shopInteractor.getProduct();
  }

  /** Call showMessage method in ShopView, called by ShopInteractor. */
  @Override
  public void showMessage(String message) {
    if (shopView != null) {
      shopView.showMessage(message);
    }
  }

  /** Update the number of product selected and the total cost of selected product. */
  @Override
  public void updateSelected(int n) {
    if (shopView != null) {
      shopView.setProductSelected(String.valueOf(n));
      int total = shopInteractor.calculateTotal(n);
      shopView.setTotalMoney(String.valueOf(total));
    }
  }

  /** Update the number of product in bag in ShopView. */
  @Override
  public void updateProductsInBag(int n) {
    if (shopView != null) {
      shopView.setProductInBag(String.valueOf(n));
    }
  }

  /** Update the number of money in bag in ShopView. */
  @Override
  public void updateMoneyLeft(int n) {
    if (shopView != null) {
      shopView.setMoneyLeft(String.valueOf(n));
    }
  }

  /** It is used to purchase products in shop. */
  void trade(int total, int amount) {
    shopInteractor.trade(total, amount, this);
  }
}
