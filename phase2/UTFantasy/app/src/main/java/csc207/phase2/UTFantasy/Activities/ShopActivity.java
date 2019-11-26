package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

/** The activity used to purchase products. */
public class ShopActivity extends AppCompatActivity implements ShopView {

  /** the intent of MainActivity */
  Intent intent;
  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();
  /** the name of current user */
  String username;
  /** the TextView of money */
  TextView moneyLeft;

  TextView totalMoney;
  TextView productInBag;
  TextView productSelected;
  ImageView productImage;
  TextView productName;
  TextView prodcutDescription;
  EditText enterAmount;
  LinearLayout layout;
  Button add1;
  Button add10;
  Button apply;
  Button buy;
  private ArrayList<Product> productInShop;
  private ShopPresenter presenter;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
    intent = getIntent();
    username = intent.getStringExtra("username");
    final Player player = userIO.getUserData().getUser(username).getPlayer();
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
    productImage = findViewById(R.id.productImage);
    productName = findViewById(R.id.productName);
    prodcutDescription = findViewById(R.id.productDescription);
    final Button backBtn = findViewById(R.id.back_to_main);
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
          }
        });

    add1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if (presenter.getProduct() != null) {
              int num = Integer.valueOf(productSelected.getText().toString());
              presenter.updateSelected(1 + num);
            } else {
              showMessage("Please select a product.");
            }
          }
        });

    add10.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if (presenter.getProduct() != null) {
              int num = Integer.valueOf(productSelected.getText().toString());
              presenter.updateSelected(10 + num);
            } else {
              showMessage("Please select a product.");
            }
          }
        });

    apply.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if (presenter.getProduct() != null) {
              if (enterAmount.getText().toString().equals("")) {
                showMessage("Please enter a number!");
              } else {
                int n = Integer.valueOf(enterAmount.getText().toString());
                presenter.updateSelected(n);
                enterAmount.setText("0");
              }
            } else {
              showMessage("Please select a product.");
            }
          }
        });

    buy.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            if (presenter.getProduct() != null) {
              int total = Integer.valueOf(totalMoney.getText().toString());
              int amount = Integer.valueOf(productSelected.getText().toString());
              presenter.trade(total, amount);
              presenter.updateSelected(0);
            } else {
              showMessage("Please select a product.");
            }
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

  /** Navigate to Back. */
  public void navigateToBag() {
    Intent intent = new Intent(ShopActivity.this, MenuActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  @Override
  public void showMessage(String text) {
    Toast.makeText(ShopActivity.this, text, Toast.LENGTH_SHORT).show();
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

  @Override
  public void setProductInfo(int res, String name, String description) {
    productImage.setImageResource(res);
    productName.setText(name);
    prodcutDescription.setText(description);
  }
}
