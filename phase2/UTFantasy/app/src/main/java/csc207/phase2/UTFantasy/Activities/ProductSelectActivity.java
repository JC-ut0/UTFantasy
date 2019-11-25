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
import csc207.phase2.UTFantasy.Products.PinkPotion;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.Products.PurplePotion;
import csc207.phase2.UTFantasy.Products.RedPotion;
import csc207.phase2.UTFantasy.R;

public class ProductSelectActivity extends AppCompatActivity {
  /** the intent of MainActivity */
  Intent intent;

  /** the player */
  Player player;
  /** the unique UserIO */
  private UserIO userIO = UserIO.getUserIO();
  /** The name of the current User. */
  String username;

  List<Product> selectedList;
  HashMap<Product, Integer> productHashMap;

  List<Product> productList;

  InfoMediator infoMediator;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_productselect);

//        intent = getIntent();
//        username = intent.getStringExtra("username");
//        player = userIO.getUserData().getUser(username).getPlayer();
//        infoMediator = new InfoMediator(player);
//        productHashMap = infoMediator.getProductHashMap();

    productHashMap = new HashMap<>();
    productHashMap.put(PinkPotion.getPink(), 2);
    productHashMap.put(PurplePotion.getPurple(), 3);
    productHashMap.put(RedPotion.getRed(), 1);
    productList = new ArrayList<>();
    productList.addAll(productHashMap.keySet());
    selectedList = new ArrayList<>();

    TextView textView = findViewById(R.id.textInfo);
    textView.setText("Please choose 1 Potion.");
    ListView listView = findViewById(R.id.pokemon_select_listView);
    Button goButton = findViewById(R.id.gobutton);
    goButton.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                checkSelectedItem();
              }
            });

    Button cancelButton = findViewById(R.id.cancelButton);
    cancelButton.setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                onBackPressed();
              }
            });
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

  public void checkSelectedItem() {
    if (selectedList.size() > 1) {
      Toast.makeText(this, "Please choose one product", Toast.LENGTH_LONG).show();
    } else if (selectedList.size() == 0) {
      Toast.makeText(this, "Please choose a product", Toast.LENGTH_LONG).show();
    } else {
      //          String item = "";
      //          for (Pokemon pokemon: selectedPokemon){
      //              item += pokemon.getPokemonName()+" ";
      //          }
      //          Toast.makeText(this,"Choosed " + item, Toast.LENGTH_SHORT).show();
      onBackPressed();
      infoMediator.setSelectedPokemon(selectedList.get(0));
    }
  }
}

