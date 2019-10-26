package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Character.SalerNPC;
import csc207.phase1.UTFantasy.ExampleDialog;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Products.PinkPotion;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.Products.PurplePotion;
import csc207.phase1.UTFantasy.Products.RedPotion;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;


public class ShopActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    SalerNPC alice = SalerNPC.getAlice();
    private PinkPotion PinkP = new PinkPotion();
    private RedPotion RP = new RedPotion();
    private PurplePotion PurpleP = new PurplePotion();
    int num;
    Product product;
    Intent intent;
    Player player;
    UserManager userManager = UserManager.getUserManager();
    String username;
    int moneyLeft;
    TextView money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        intent = getIntent();
        username = intent.getStringExtra("username");
        player = userManager.getUser(username).getPlayer();


        final Button button1 = findViewById(R.id.choose_red);
        final Button button2 = findViewById(R.id.choose_pink);
        final Button button3 = findViewById(R.id.choose_purple);
        final ImageButton button4 = findViewById(R.id.back_to_main);

//        if (true) {
//            UserManager userManager = UserManager.getUserManager();
//            userManager.message("Create a new User", ShopActivity.this);
//            User user = new User("2", "123456");
//            user.setPlayer(new Player("ET", "ET"));
//            user.getPlayer().addPokemon(new Pikachu());
//            player = user.getPlayer();
//            player.setMoney(1000);
//        }
        moneyLeft = player.getMoney();

        money = findViewById(R.id.money);
        money.setText(String.valueOf(moneyLeft));

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openDialog();
                product = RP;
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openDialog();
                product = PinkP;
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openDialog();
                product = PurpleP;
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String amount) {
        num = Integer.valueOf(amount);
        alice.ability(player, num, product);
        if (!alice.isAffordable()) {
            Toast.makeText(ShopActivity.this, "You do not have enough money.",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ShopActivity.this, "Products are in your bag.",
                    Toast.LENGTH_SHORT).show();
        }
        moneyLeft = player.getMoney();
        money.setText(String.valueOf(moneyLeft));
    }


}
