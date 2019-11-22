package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.SellerNPC;
import csc207.phase2.UTFantasy.ShopDialog;
import csc207.phase2.UTFantasy.Products.PotionFactory;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.UserManager;

/** The activity used to purchase products. */
public class ShopActivity extends AppCompatActivity implements ShopDialog.ExampleDialogListener {

//  /** The product pinkPotion. */
//  PinkPotion pinkPotion = PinkPotion.getPink();
//  /** The product redPotion. */
//  RedPotion redPotion = RedPotion.getRed();
//  /** The product purplePotion. */
//  PurplePotion purplePotion = PurplePotion.getPurple();
  /** A PotionFactory*/
  PotionFactory potionFactory = new PotionFactory();
  /** The amount of products a player wants to buy. */
  int amount;
  /** which product a player wants to buy */
  Product product;
  /** the intent of MainActivity */
  Intent intent;
  /** the player */
  Player player;
  /** the unique userManager */
  UserManager userManager = UserManager.getUserManager();
  /** the name of current user */
  String username;
  /** the amount of money a player has */
  int moneyLeft;
  /** the TextView of money */
  TextView money;
  /** the sellerNPC */
  SellerNPC sellerNPC;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);
    intent = getIntent();
    username = intent.getStringExtra("username");
    player = userManager.getUser(username).getPlayer();

    final Button redPotionBtn = findViewById(R.id.choose_red);
    final Button pinkPotionBtn = findViewById(R.id.choose_pink);
    final Button purplePotionBtn = findViewById(R.id.choose_purple);
    final ImageButton backBtn = findViewById(R.id.back_to_main);
    final Button bagBtn = findViewById(R.id.my_bag);

    moneyLeft = player.getMoney();

    sellerNPC = (SellerNPC) player.getNpcManager().getNPC("Alice");

    money = findViewById(R.id.money);
    money.setText(String.valueOf(moneyLeft));

    redPotionBtn.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {
            // Code here executes on main thread after user presses button
            openDialog();
            product = potionFactory.makePotion("red");
          }
        });

    pinkPotionBtn.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {
            // Code here executes on main thread after user presses button
            openDialog();
            product = potionFactory.makePotion("pink");
          }
        });

    purplePotionBtn.setOnClickListener(
        new View.OnClickListener() {
          public void onClick(View v) {
            // Code here executes on main thread after user presses button
            openDialog();
            product =  potionFactory.makePotion("purple");
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

  /**
   * A window pops up where you can enter a number that represents the number of products you want
   * to purchase.
   */
  public void openDialog() {
    ShopDialog shopDialog = new ShopDialog();
    shopDialog.show(getSupportFragmentManager(), "shop dialog");
  }

  /** Apply the text entered by the user to sellerNPC. */
  @Override
  public void applyTexts(String amount) {
    this.amount = Integer.valueOf(amount);
    String tradeInfo = "You bought " + this.amount + " " + product.getName() + "!";
    Toast.makeText(ShopActivity.this, tradeInfo, Toast.LENGTH_SHORT).show();
    moneyLeft = player.getMoney();
    money.setText(String.valueOf(moneyLeft));
  }

  /** Navigate to Back. */
  public void navigateToBag(){
    Intent intent = new Intent(ShopActivity.this, MenuActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }
}
