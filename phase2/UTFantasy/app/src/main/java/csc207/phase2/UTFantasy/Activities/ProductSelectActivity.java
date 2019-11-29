package csc207.phase2.UTFantasy.Activities;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.InfoMediator;
import csc207.phase2.UTFantasy.Products.Product;
import csc207.phase2.UTFantasy.R;

public class ProductSelectActivity extends AppCompatActivity {

  /** the player */
  Player player;
  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();

  List<Product> selectedList;
  HashMap<Product, Integer> productHashMap;

  List<Product> productList;

  InfoMediator infoMediator;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productselect);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        player = userIO.getUserData().getUser(username).getPlayer();
        infoMediator = new InfoMediator(player);
        productHashMap = infoMediator.getProductHashMap();
        selectedList = new ArrayList<>();

        TextView textView = findViewById(R.id.textInfo);
        textView.setText("Please choose one Product from your bag.");
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
      onBackPressed();
      infoMediator.setSelectedPokemon(selectedList.get(0));
    }
  }
}
