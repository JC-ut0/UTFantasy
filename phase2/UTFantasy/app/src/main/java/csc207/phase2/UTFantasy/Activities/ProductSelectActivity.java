package csc207.phase2.UTFantasy.Activities;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.InfoMediator;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class ProductSelectActivity extends AppCompatActivity {

  /** The player */
  Player player;
  /** The unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();
  /** The list of the selected list of product */
  List<Product> selectedList;
  /** The hashmap of the product */
  HashMap<Product, Integer> productHashMap;
  /** The list of the product */
  List<Product> productList;
  /** The information mediator */
  InfoMediator infoMediator;

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
    selectedList = new ArrayList<>();

    // set up the activity
    setTextView();
    setButtons();
    setViewList();
  }

  public void checkSelectedItem() {
    //check if the selected item has only 1 amount
    if (selectedList.size() > 1) {
      Toast.makeText(this, "Please choose one product", Toast.LENGTH_LONG).show();
    } else if (selectedList.size() == 0) {
      Toast.makeText(this, "Please choose a product", Toast.LENGTH_LONG).show();
    } else {
      onBackPressed();
      infoMediator.setSelectedPokemon(selectedList.get(0));
    }
  }

  private void setTextView() {
    // set up the text view
    TextView textView = findViewById(R.id.textInfo);
    textView.setText("Please choose one Product from your bag.");
  }

  private void setButtons() {
    //set up the go button
    Button goButton = findViewById(R.id.gobutton);
    goButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            checkSelectedItem();
          }
        });
    //set up the cancel button
    Button cancelButton = findViewById(R.id.cancelButton);
    cancelButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            onBackPressed();
          }
        });
  }

  private void setViewList() {
    //set up the view list and the adapter
    ListView listView = findViewById(R.id.pokemon_select_listView);
    final ProductSelectAdapter adapter = new ProductSelectAdapter(this, productHashMap);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Product product = productList.get(position);
            if (selectedList.contains(product)) {
              selectedList.remove(product);
            } else {
              selectedList.add(product);
            }
            productList.set(position, product);

            // now update the adapter
            adapter.updateRecords(productList, selectedList);
          }
        });
  }
}
