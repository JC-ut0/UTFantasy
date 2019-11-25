package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.InfoMediator;
import csc207.phase2.UTFantasy.R;

public class MenuActivity extends AppCompatActivity {

  /** the player. */
  Player player;

  /** the unique UserIO */
  private UserIO userIO = UserIO.getUserIO();

  /** The ListView for pokemon and items. */
  private ListView potionList;

  private ListView pokemonList;

  private InfoMediator infoMediator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_bag_item);

    // get the user from main
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();

    //    player = new Player("hello","boy");
    infoMediator = new InfoMediator(player);

    // draw all the stuffs to the activity
    draw_listViews();
    draw_toggleButton();
    draw_backButton();

    // The Switch is on Items(OFF) at the first,
    // Set the pokemonList to be invisible in the beginning.
    pokemonList.setVisibility(View.INVISIBLE);
  }

  /** Set up the ListViews. */
  private void draw_listViews() {
    // draw the list items and pokemon list
    potionList = findViewById(R.id.list_view);
    pokemonList = findViewById(R.id.list_view2);

    // Create new adapters for the listViews and adapt them.
    ItemAdapter adapter1 = new ItemAdapter(this, infoMediator.getPokemonList());
    ItemAdapter adapter2 = new ItemAdapter(this, infoMediator.getProductHashMap());
    pokemonList.setAdapter(adapter1);
    potionList.setAdapter(adapter2);
  }

  /** Set up the Toggle button. */
  private void draw_toggleButton() {
    // set up the toggle Button
    ToggleButton toggleButton = findViewById(R.id.toggleButton1);
    toggleButton.setOnCheckedChangeListener(
        new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!isChecked) {
              potionList.setVisibility(View.VISIBLE);
              pokemonList.setVisibility(View.INVISIBLE);

            } else {
              potionList.setVisibility(View.INVISIBLE);
              pokemonList.setVisibility(View.VISIBLE);
            }
          }
        });
  }

  /** Set up the backButton. */
  private void draw_backButton() {
    // The return button will always return to its previous page
    ImageButton backToMain = findViewById(R.id.back_to_main);
    backToMain.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            onBackPressed();
          }
        });
  }
}
