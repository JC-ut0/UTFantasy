package csc207.phase2.UTFantasy.Activities;

import android.widget.Space;

import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.ShopDialog;

public class ShopPresenter implements ShopInteractor.Listener {
  private ShopInteractor shopInteractor;
  private ShopView shopView;

  ShopPresenter(ShopInteractor shopInteractor, ShopView shopView) {
    this.shopInteractor = shopInteractor;
    this.shopView = shopView;
  }

  void updateAll(Product product) {
    shopInteractor.setProduct(product);
    int n = shopInteractor.countProducts(product);
    int money = shopInteractor.countMoney();
    if (shopView != null) {
      shopView.setTotalMoney("0");
      shopView.setProductSelected("0");
      shopView.setProductInBag(String.valueOf(n));
      shopView.setMoneyLeft(String.valueOf(money));
      shopView.setButtons();
    }
  }

  @Override
  public void showMessage(String message) {
    if (shopView != null) {
      shopView.showMessage(message);
    }
  }

  @Override
  public void updateSelected(int n) {
    if (shopView != null) {
      shopView.setProductSelected(String.valueOf(n));
      int total = shopInteractor.calculateTotal(n);
      shopView.setTotalMoney(String.valueOf(total));
    }
  }

  @Override
  public void updateProductsInBag(int n) {
    if (shopView != null) {
      shopView.setProductInBag(String.valueOf(n));
    }
  }

  @Override
  public void updateMoneyLeft(int n) {
    if (shopView != null) {
      shopView.setMoneyLeft(String.valueOf(n));
    }
  }

  void trade(int total, int amount) {
    shopInteractor.trade(total, amount, this);
  }
}
