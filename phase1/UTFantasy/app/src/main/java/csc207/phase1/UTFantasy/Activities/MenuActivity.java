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
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Products.PinkPotion;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.Products.PurplePotion;
import csc207.phase1.UTFantasy.Products.RedPotion;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class MenuActivity extends AppCompatActivity {

    /**
     * the intent of MainActivity
     */
    Intent intent;

    /**
     * the player
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
    ListView itemslist;
    ListView pokemonlist;
    /**
     * The Toogle button for switching between pokemon and items.
     */
    ToggleButton toggleButton;
    ImageButton backtomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag_item);
//        PinkPotion PinkP = PinkPotion.getPink();
//        RedPotion RP = RedPotion.getRed();
//        PurplePotion PurpleP = PurplePotion.getPurple();

        intent = getIntent();
        username = intent.getStringExtra("username");
        p = userManager.getUser(username).getPlayer();

//        if (true) {
//            UserManager userManager = UserManager.getUserManager();
//            userManager.message("Create a new User", MenuActivity.this);
//            User user = new User("2", "123456");
//            Player player = new Player("ET", "ET");
//            user.setPlayer(player);
//            player = user.getPlayer();
//            player.addPokemon(new Pikachu());
//            player.setMoney(1000);
//
//            player.addItem(PinkP,1);
//            player.addItem(RP,1);
//            player.addItem(PurpleP,1);
//        }

        //get all the information from the Player's bag
        //First, the pokemon
        ArrayList<Pokemon> pokemontemp;
        pokemontemp = p.getPokemonList();
        for (Pokemon pokemon : pokemontemp) {
            pokemons.add(pokemon.getPokemonName());
            pokemonsinfo.add(pokemon.toString());
            images.add(pokemon.getProfileID());
        }

        HashMap<Product, Integer> itemtemp;
        itemtemp = p.getBag();
        for (Product item : itemtemp.keySet()) {
            items.add(item.getName());
            potioninfo.add(item.toString() + "\n" + "Num: " + itemtemp.get(item));
            potionimages.add(item.getProfile_id());
        }


        //draw the list items and pokemon list
        itemslist = findViewById(R.id.list_view);
        pokemonlist = findViewById(R.id.list_view2);

        //Create new adapters for the listviews and adpate them.
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        CustomAdapter adapter1 = new CustomAdapter("item");
        CustomAdapter adapter2 = new CustomAdapter("pokemon");
        itemslist.setAdapter(adapter1);
        pokemonlist.setAdapter(adapter2);

        //itemslist onClisk method
//        itemslist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MenuActivity.this, items.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });

        //The Switch is on Items(OFF) at the first,
        //Set the pokemonlist to be invisible in the beginning.
        pokemonlist.setVisibility(View.INVISIBLE);

        //set up the toggle Button
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    itemslist.setVisibility(View.VISIBLE);
                    pokemonlist.setVisibility(View.INVISIBLE);

                } else {
                    itemslist.setVisibility(View.INVISIBLE);
                    pokemonlist.setVisibility(View.VISIBLE);

                }
            }
        });

        // The textview of the String: MY BAG
//        TextView textView = findViewById(R.id.textView);

        backtomain = (ImageButton) findViewById(R.id.back_to_main);
        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    /**
     * The CustomAdater for the pokemon listview.
     */
    class CustomAdapter extends BaseAdapter {

        String type;

        public CustomAdapter(String type) {
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
            TextView pokename = view.findViewById(R.id.pokemonname);
            TextView pokeinfo = view.findViewById(R.id.pokemoninfo);
            if (this.type.equals("pokemon")) {
                imageView.setImageResource(images.get(position));
                pokename.setText(pokemons.get(position));
                pokeinfo.setText(pokemonsinfo.get(position));
            } else if (this.type.equals("item")) {
                imageView.setImageResource(potionimages.get(position));
                pokename.setText(items.get(position));
                pokeinfo.setText(potioninfo.get(position));
            }

            return view;
        }
    }
}
