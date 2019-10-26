package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;


import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Character.SalerNPC;
import csc207.phase1.UTFantasy.ExampleDialog;
import csc207.phase1.UTFantasy.Products.BluePotion;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.Products.YellowPotion;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;


public class ShopActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    /*private SalerNPC sa = new SalerNPC("Anna","female");
    private YellowPotion YP = new YellowPotion();
//    private BluePotion BP = new BluePotion();
    private ArrayList<Product> shoppingCart = new ArrayList<>();*/
    private int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final Button button1 = findViewById(R.id.choose_blue);
        final Button button2 = findViewById(R.id.choose_yellow);
        final Button button3 = findViewById(R.id.choose_purple);
        final Button button4 = findViewById(R.id.exit);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openDialog();

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openDialog();
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                openDialog();
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }

    @Override
    public void applyTexts(String amount) {
        this.amount = Integer.valueOf(amount);
    }


    /*private void message(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("UT Fantasy");
        builder.setMessage(str);
        builder.setPositiveButton("OK", null);
        builder.show();
    }*/
}
