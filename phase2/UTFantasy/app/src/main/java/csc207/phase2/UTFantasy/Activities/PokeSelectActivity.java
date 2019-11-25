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
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Products.InfoMediator;
import csc207.phase2.UTFantasy.R;

public class PokeSelectActivity extends AppCompatActivity {
  /** the intent of MainActivity */
  Intent intent;

  /** the player */
  Player player;

  /** the unique UserIO */
  private final UserIO userIO = UserIO.getSingletonUserIo();

  /** The name of the current User. */
  private String username;

  private List<Pokemon> selectedPokemon;

  private List<Pokemon> pokemonList;

  private InfoMediator infoMediator;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pokeselect);

    intent = getIntent();
    username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();
    infoMediator = new InfoMediator(player);
    pokemonList = infoMediator.getPokemonList();
    selectedPokemon = new ArrayList<>();

    //    pokemonList = new ArrayList<>();
    //    pokemonList.add(new Pikachu());
    //    pokemonList.add(new Psyduck());
    //    pokemonList.add(new Squirtle());
    //    pokemonList.add(new Charmander());
    TextView textView = findViewById(R.id.textInfo);
    textView.setText("Please choose at most 3 Pokemons.");
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
    final PokeSelectAdapter adapter = new PokeSelectAdapter(this, pokemonList);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Pokemon pokemon = pokemonList.get(position);
            if (selectedPokemon.contains(pokemon)) {
              selectedPokemon.remove(pokemon);
            } else {
              selectedPokemon.add(pokemon);
            }
            pokemonList.set(position, pokemon);

            // now update the adapter
            adapter.updateRecords(pokemonList, selectedPokemon);
          }
        });
  }

  public void checkSelectedItem() {
    if (selectedPokemon.size() > 3) {
      Toast.makeText(this, "Please choose at most 3 pokemons", Toast.LENGTH_LONG).show();
    } else if (selectedPokemon.size() == 0) {
      Toast.makeText(this, "Please choose a pokemon", Toast.LENGTH_LONG).show();
    } else {
      //          String item = "";
      //          for (Pokemon pokemon: selectedPokemon){
      //              item += pokemon.getPokemonName()+" ";
      //          }
      //          Toast.makeText(this,"Choosed " + item, Toast.LENGTH_SHORT).show();
      onBackPressed();
      infoMediator.setSelectedPokemon(selectedPokemon);
    }
  }
}
