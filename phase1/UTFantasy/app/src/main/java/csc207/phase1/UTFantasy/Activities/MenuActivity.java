package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.R;
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
    String items[];// = new String[]{"poison1","poison2","poison3","poison4","poison5","poison6"};
    /**
     * All the pokemon information, including the pokemon names, images, and info.
     */
    ArrayList<String> pokemons;// = new String[]{"Pikachu", "pokemon2","pokemon3","pokemon4","pokemon5"};
    ArrayList<String> pokemonsinfo;// = new String[]{"This is a Pikachu.","2","3","4","5"};
    ArrayList<Integer> images;// = new int[]{R.drawable.pikachu1,R.drawable.psyduck,R.drawable.squirtle,
            //R.drawable.charmander,R.drawable.jigglypuff};

    /**
     * The ListView for pokemon and items.
     */
    ListView itemslist;
    ListView pokemonlist;
    /**
     * The Toogle button for switching between pokemon and items.
     */
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag_item);

        // get the Player
        try{
        intent = getIntent();
        username = intent.getStringExtra("username");
        p = userManager.getUser(username).getPlayer();}
        catch (NullPointerException e){
            System.out.println("nonono");
        }

        //get all the information from the Player's bag
        //First, the pokemon
        ArrayList<Pokemon> pokemontemp;
        pokemontemp = p.getPokemonList();
        for(Pokemon pokemon: pokemontemp){
            pokemons.add(pokemon.getPokemonName());
            pokemonsinfo.add(pokemon.toString());
            images.add(pokemon.getProfileID());
        }




        //draw the list items and pokemon list
        itemslist = (ListView) findViewById(R.id.list_view);
        pokemonlist = (ListView) findViewById(R.id.list_view2);

        //Create new adapters for the listviews and adpate them.
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        CustomAdpater adapter2 = new CustomAdpater();
        itemslist.setAdapter(adapter1);
        pokemonlist.setAdapter(adapter2);

        //itemslist onClisk method
        itemslist.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MenuActivity.this, items[position], Toast.LENGTH_SHORT).show();
            }
        });

        //The Switch is on Items(OFF) at the first,
        //Set the pokemonlist to be invisible in the beginning.
        pokemonlist.setVisibility(View.INVISIBLE);

        //set up the toggle Button
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    itemslist.setVisibility(View.VISIBLE);
                    pokemonlist.setVisibility(View.INVISIBLE);

                }else{
                    itemslist.setVisibility(View.INVISIBLE);
                    pokemonlist.setVisibility(View.VISIBLE);

                }
            }
        });

        // The textview of the String: MY BAG
        TextView textView = (TextView)findViewById(R.id.textView);

    }

    /**
     * The CustomAdater for the pokemon listview.
     */
    class CustomAdpater extends BaseAdapter{
        @Override
        public int getCount() {
            return images.size();
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

            ImageView imageView = (ImageView) view.findViewById(R.id.pokemonimage);
            TextView pokename = (TextView) view.findViewById(R.id.pokemonname);
            TextView pokeinfo = (TextView) view.findViewById(R.id.pokemoninfo);

            imageView.setImageResource(images.get(position));
            pokename.setText(pokemons.get(position));
            pokeinfo.setText(pokemonsinfo.get(position));

            return view;
        }
    }
}
