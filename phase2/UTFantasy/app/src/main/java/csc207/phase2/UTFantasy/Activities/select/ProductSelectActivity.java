package csc207.phase2.UTFantasy.Activities.select;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import csc207.phase2.UTFantasy.Activities.InfoMediator;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class ProductSelectActivity extends AppCompatActivity {

  /** The player */
  Player player;
  /** The list of the selected list of product */
  Product selectedProduct;
  /** The HashMap of the product */
  HashMap<Product, Integer> productHashMap;
  /** The information mediator */
  InfoMediator infoMediator;
  /** The unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();
  /** the adapter of select */
  private ProductSelectAdapter adapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_productselect);

    // get the data from the previous activity
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();
    // load the hashmap to a list
    infoMediator = new InfoMediator(player);
    productHashMap = infoMediator.getProductHashMap();

    // set up the activity
    setTextView();
    setButtons();
    setViewList();
  }

  /** check whether the selected can be processed. */
  public void checkSelectedItem() {
    // check if the selected item has only 1 amount
    if (selectedProduct == null) {
      Toast.makeText(this, "Please choose one product", Toast.LENGTH_LONG).show();
    } else {
      onBackPressed();
      infoMediator.setSelectedPokemon(selectedProduct);
      selectedProduct.setSelected(false);
    }
  }

  /** set the text view. */
  @SuppressLint("SetTextI18n")
  private void setTextView() {
    // set up the text view
    TextView textView = findViewById(R.id.textInfo);
    textView.setText("Please choose one Product from your bag.");
  }

  /** set the buttons go and cancel. */
  private void setButtons() {
    // set up the go button
    Button goButton = findViewById(R.id.gobutton);
    goButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            checkSelectedItem();
          }
        });
    // set up the cancel button
    Button cancelButton = findViewById(R.id.cancelButton);
    cancelButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            reset();
            onBackPressed();
          }
        });
  }

  /** set the view list. */
  private void setViewList() {
    // set up the view list and the adapter
    ListView listView = findViewById(R.id.pokemon_select_listView);
    adapter = new ProductSelectAdapter(this, productHashMap);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Product product = (Product) adapter.getItem(position);
            if (product.isSelected()) {
              product.setSelected(false);
              selectedProduct = null;
            } else {
              checkOnlyOne(product);
            }
            // now update the adapter
            adapter.updateRecords(productHashMap);
          }
        });
  }

  /**
   * helper to check if the player chose only one product or the product is null.
   *
   * @param product the product
   */
  private void checkOnlyOne(Product product) {
    if (selectedProduct != null) {
      Toast.makeText(this, "You can choose only one product", Toast.LENGTH_LONG).show();
    } else {
      product.setSelected(true);
      selectedProduct = product;
    }
  }

  /** rest all the product to be not selected. */
  private void reset() {
    infoMediator.resetSelect();
  }
}
