package csc207.phase2.UTFantasy.Activities.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Activities.InfoMediator;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;

public class MenuActivity extends AppCompatActivity {

  /** the player. */
  Player player;
  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();
  /** The ListView for pokemon and items. */
  private ListView potionList;

  private ListView pokemonList;
  /** The information mediator. */
  private InfoMediator infoMediator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_bag_item);

    // get the user from main
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();
    infoMediator = new InfoMediator(player);

    // draw all the stuffs to the activity
    drawListViews();
    drawToggleButton();
    drawBackButton();

    // The Switch is on Items(OFF) at the first,
    // Set the pokemonList to be invisible in the beginning.
    pokemonList.setVisibility(View.INVISIBLE);
  }

  /** Set up the ListViews. */
  private void drawListViews() {
    // draw the list items and pokemon list
    potionList = findViewById(R.id.list_view);
    pokemonList = findViewById(R.id.list_view2);

    // Create new adapters for the listViews and adapt them.
    final ItemAdapter adapter1 = new ItemAdapter(this, infoMediator.getPokemonList());
    ItemAdapter adapter2 = new ItemAdapter(this, infoMediator.getProductHashMap());
    pokemonList.setAdapter(adapter1);
    potionList.setAdapter(adapter2);
    pokemonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        drawControlButton(position,adapter1);
      }
    });
  }

  /** Set up the Toggle button. */
  private void drawToggleButton() {
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
  private void drawBackButton() {
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

  private void drawControlButton(final int position, final ItemAdapter adapter){
    //swap
    final Button swap = findViewById(R.id.swap);
    swap.setVisibility(View.VISIBLE);
    //discard
    final Button discard = findViewById(R.id.discard);
    discard.setVisibility(View.VISIBLE);
    //back
    final Button back = findViewById(R.id.nothing);
    back.setVisibility(View.VISIBLE);

    //swap's listener
    swap.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        infoMediator.swapPokemon(position);
        adapter.updateRecords(infoMediator.getPokemonList());
        swap.setVisibility(View.INVISIBLE);
        discard.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
      }
    });

    //discard's listener
    discard.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        infoMediator.discardPokemon(position);
        adapter.updateRecords(infoMediator.getPokemonList());
        swap.setVisibility(View.INVISIBLE);
        discard.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
      }
    });

    back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        swap.setVisibility(View.INVISIBLE);
        discard.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
      }
    });

  }

}
