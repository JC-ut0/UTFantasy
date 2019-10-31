package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.UserManager;

public class MenuActivity extends AppCompatActivity {

    /**
     * the intent of MainActivity.
     */
    Intent intent;

    /**
     * the player.
     */
    Player p;
    /**
     * The unique UserManager.
     */
    UserManager userManager = UserManager.getUserManager();
    /**
     * The name of the current User.
     */
    String username;
    /**
     * The items in the Player's bag.
     */
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> potioninfo = new ArrayList<>();
    ArrayList<Integer> potionimages = new ArrayList<>();

    /**
     * All the pokemon information, including the pokemon names, images, and info.
     */
    ArrayList<String> pokemons = new ArrayList<>();
    ArrayList<String> pokemonsinfo = new ArrayList<>();
    ArrayList<Integer> images = new ArrayList<>();

    /**
     * The ListView for pokemon and items.
     */
    ListView itemsList;
    ListView pokemonList;
    /**
     * The Toogle button for switching between pokemon and items.
     */
    ToggleButton toggleButton;
    ImageButton backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag_item);

        //get the user from main
        intent = getIntent();
        username = intent.getStringExtra("username");
        p = userManager.getUser(username).getPlayer();

        //read the information of the player
        read_info();

        //draw all the stuffs to the activity
        draw_listViews();
        draw_toggleButton();
        draw_backButton();

        //The Switch is on Items(OFF) at the first,
        //Set the pokemonList to be invisible in the beginning.
        pokemonList.setVisibility(View.INVISIBLE);
    }

    /**
     * The CustomAdapter for the pokemon and item listviews.
     */
    class CustomAdapter extends BaseAdapter {

        String type;


        /**
         * The adapter of the ViewList with title and subtitle.
         *
         * @param type the type of pokemon or item
         */
        private CustomAdapter(String type) {
            this.type = type;
        }

        @Override
        public int getCount() {
            if (this.type.equals("pokemon") && images != null) {
                return images.size();
            } else if (this.type.equals("item") && potionimages != null) {
                return potionimages.size();
            } else {
                return 0;
            }

        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.pokemon_layout, null);
            ImageView imageView = view.findViewById(R.id.pokemonimage);
            TextView pokeName = view.findViewById(R.id.pokemonname);
            TextView pokeInfo = view.findViewById(R.id.pokemoninfo);
            if (this.type.equals("pokemon")) {
                imageView.setImageResource(images.get(position));
                pokeName.setText(pokemons.get(position));
                pokeInfo.setText(pokemonsinfo.get(position));
            } else if (this.type.equals("item")) {
                imageView.setImageResource(potionimages.get(position));
                pokeName.setText(items.get(position));
                pokeInfo.setText(potioninfo.get(position));
            }

            return view;
        }
    }

    /**
     * Read all the information from the player.
     */
    private void read_info() {
        //get all the information from the Player's bag
        //First, the pokemon
        ArrayList<Pokemon> pokemontemp;
        pokemontemp = p.getPokemonList();
        for (Pokemon pokemon : pokemontemp) {
            pokemons.add(pokemon.getPokemonName());
            pokemonsinfo.add(pokemon.toString());
            images.add(pokemon.getProfileID());
        }

        //Second, the potion
        HashMap<Product, Integer> itemtemp;
        itemtemp = p.getBag();
        for (Product item : itemtemp.keySet()) {
            items.add(item.getName());
            potioninfo.add(item.toString() + "\n" + "Num: " + itemtemp.get(item));
            potionimages.add(item.getProfile_id());
        }
    }

    /**
     * Set up the ListViews.
     */
    private void draw_listViews() {
        //draw the list items and pokemon list
        itemsList = findViewById(R.id.list_view);
        pokemonList = findViewById(R.id.list_view2);

        //Create new adapters for the listViews and adapt them.
        CustomAdapter adapter1 = new CustomAdapter("item");
        CustomAdapter adapter2 = new CustomAdapter("pokemon");
        itemsList.setAdapter(adapter1);
        pokemonList.setAdapter(adapter2);
    }

    /**
     * Set up the Toggle button.
     */
    private void draw_toggleButton() {
        //set up the toggle Button
        toggleButton = findViewById(R.id.toggleButton1);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    itemsList.setVisibility(View.VISIBLE);
                    pokemonList.setVisibility(View.INVISIBLE);

                } else {
                    itemsList.setVisibility(View.INVISIBLE);
                    pokemonList.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    /**
     * Set up the backButton.
     */
    private void draw_backButton() {
        //The return button will always return to its previous page
        backToMain = findViewById(R.id.back_to_main);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
