package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Products.PotionFactory;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.UserManager;

/** The activity used to purchase products. */
public class ShopActivity extends AppCompatActivity implements ShopView {

  /** A PotionFactory */
  PotionFactory potionFactory = new PotionFactory();
  //  /** The amount of products a player wants to buy. */
  //  int amount;
  //  /** which product a player wants to buy */
  //  Product product;
  //  /** the intent of MainActivity */
  Intent intent;
  /** the player */
  Player player;
  /** the unique userManager */
  UserManager userManager = UserManager.getUserManager();
  /** the name of current user */
  String username;
  //  /** the amount of money a player has */
  //  int money;
  /** the TextView of money */
  TextView moneyLeft;

  TextView totalMoney;
  TextView productInBag;
  TextView productSelected;
  EditText enterAmount;
  LinearLayout layout;
  Button add1;
  Button add10;
  Button apply;
  Button buy;
  private ArrayList<Product> productInShop;
  private ShopPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
    intent = getIntent();
    username = intent.getStringExtra("username");
    player = userManager.getUser(username).getPlayer();
    presenter = new ShopPresenter(new ShopInteractor(player), this);
    ListView listView = findViewById(R.id.productListView);
    totalMoney = findViewById(R.id.totalMoney);
    moneyLeft = findViewById(R.id.money_left);
    productInBag = findViewById(R.id.amountInBag);
    productSelected = findViewById(R.id.num_selected);
    enterAmount = findViewById(R.id.enter_amount);
    moneyLeft.setText(String.valueOf(player.getMoney()));
    layout = findViewById(R.id.left_top);
    add1 = findViewById(R.id.add1);
    add10 = findViewById(R.id.add10);
    apply = findViewById(R.id.apply);
    buy = findViewById(R.id.buy);
    final ImageButton backBtn = findViewById(R.id.back_to_main);
    final Button bagBtn = findViewById(R.id.my_bag);

    ProductCreator productCreator = new ProductCreator();
    productInShop = productCreator.getProducts();

    ProductAdapter productAdapter =
        new ProductAdapter(this, R.layout.product_layout, productInShop);
    listView.setAdapter(productAdapter);

    listView.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Product product = productInShop.get(position);
            presenter.updateAll(product);
            // View view1 = createView(product);
            //            updateAll(product);
            //            setButton();
          }
        });

    add1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            int num = Integer.valueOf(productSelected.getText().toString());
            presenter.updateSelected(1 + num);
          }
        });

    add10.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            int num = Integer.valueOf(productSelected.getText().toString());
            presenter.updateSelected(10 + num);
          }
        });

    apply.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if (enterAmount.getText() != null) {
              int n = Integer.valueOf(enterAmount.getText().toString());
              presenter.updateSelected(n);
              enterAmount.setText("0");
            } else {
              showMessage("Please enter a number!");
            }
          }
        });

    buy.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            int total = Integer.valueOf(totalMoney.getText().toString());
            int amount = Integer.valueOf(productSelected.getText().toString());
            presenter.trade(total, amount);
            presenter.updateSelected(0);
          }
        });

    backBtn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            onBackPressed();
          }
        });

    bagBtn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            navigateToBag();
          }
        });
  }

  //  /**
  //   * A window pops up where you can enter a number that represents the number of products you
  // want
  //   * to purchase.
  //   */
  //  public void openDialog() {
  //    ShopDialog shopDialog = new ShopDialog();
  //    shopDialog.show(getSupportFragmentManager(), "shop dialog");
  //  }

  //  /** Apply the text entered by the user to sellerNPC. */
  //  @Override
  //  public void applyTexts(String amount) {
  //    this.amount = Integer.valueOf(amount);
  //    trade();
  //    money.setText(String.valueOf(moneyLeft));
  //  }

  /** Navigate to Back. */
  public void navigateToBag() {
    Intent intent = new Intent(ShopActivity.this, MenuActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  public void showMessage(String text) {
    Toast.makeText(ShopActivity.this, text, Toast.LENGTH_SHORT).show();
  }

  //  public void trade(){
  //    if (canAfford()){
  //      player.addItem(product, amount);
  //      int total = product.getPrice() * amount;
  //      money -= total;
  //      player.setMoney(money);
  //      String tradeInfo = "You bought " + this.amount + " " + product.getName() + "!";
  //      Toast.makeText(ShopActivity.this, tradeInfo,  Toast.LENGTH_SHORT).show();
  //    } else{
  //      String tradeInfo = "You don't have enough money.";
  //      Toast.makeText(ShopActivity.this, tradeInfo,  Toast.LENGTH_SHORT).show();
  //    }
  //  }
  //  public void trade(){
  //    if (total != 0){
  //      if (canAfford()){
  //        int money = Integer.valueOf(moneyLeft.getText().toString()) - total;
  //        player.setMoney(money);
  //        int amount = Integer.valueOf(productSelected.getText().toString());
  //        player.addItem(product, amount);
  //        moneyLeft.setText(String.valueOf(money));
  //        updateProductInBag();
  //      } else {
  //        showMessage("You don't Have enough money!");
  //        productSelected.setText("0");
  //        updateTotal();
  //      }
  //    }else{
  //      showMessage("Please add products!");
  //    }

  //  private void updateProductInBag(){
  //    productInBag.setText(productSelected.getText().toString());
  //  }

  //  public boolean canAfford(){
  //    int price = product.getPrice();
  //    int money = player.getMoney();
  //    int total = price * amount;
  //    return total <= money;
  //  }
  //  public boolean canAfford(){
  //    return Integer.valueOf(totalMoney.getText().toString()) <=
  // Integer.valueOf(moneyLeft.getText().toString());
  //  }

  //  public void updateAll(Product product){
  //    //layout.addView(view, 0);
  //    totalMoney.setText("0");
  //    productSelected.setText("0");
  //    Integer n = player.getBag().get(product);
  //    if (n != null){
  //      productInBag.setText(String.valueOf(n));
  //    }else{
  //      productInBag.setText("0");
  //    }
  //  }

  public View createView(Product product) {
    int id = product.getProfile_id();
    String name = product.getName();
    String description = product.toString();
    LayoutInflater inflater = LayoutInflater.from(this);
    View view = inflater.inflate(R.layout.product_info, layout, false);
    ImageView productImage = view.findViewById(R.id.productImage);
    TextView productDescription = view.findViewById(R.id.productDescription);
    TextView productName = view.findViewById(R.id.productName);
    productImage.setImageResource(id);
    productName.setText(name);
    productDescription.setText(description);
    return view;
  }
  //  public void updateNewAmount(int num){
  //    productSelected.setText(String.valueOf(num));
  //  }

  @Override
  public void setButtons() {
    add1.setEnabled(true);
    add10.setEnabled(true);
    buy.setEnabled(true);
    apply.setEnabled(true);
  }

  @Override
  public void setProductSelected(String text) {
    productSelected.setText(text);
  }

  @Override
  public void setTotalMoney(String text) {
    totalMoney.setText(text);
  }

  @Override
  public void setProductInBag(String text) {
    productInBag.setText(text);
  }

  @Override
  public void setMoneyLeft(String text) {
    moneyLeft.setText(text);
  }
}
