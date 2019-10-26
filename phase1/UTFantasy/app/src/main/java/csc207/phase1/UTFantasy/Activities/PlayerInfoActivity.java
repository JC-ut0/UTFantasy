package csc207.phase1.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class PlayerInfoActivity extends AppCompatActivity {

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

    ImageView profile;
    TextView character_name;
    TextView character_gender;
    TextView money;
    TextView character_description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        intent = getIntent();
        username = intent.getStringExtra("username");
        User user = userManager.getUser(username);
        p = user.getPlayer();

//        if (user == null){
//            UserManager userManager = UserManager.getUserManager();
//            userManager.loadUserManager(PlayerInfoActivity.this);
//            user = userManager.getUser("1");
//        }
//        assert user != null;
//        p = user.getPlayer();
//        assert p != null;
//        p.addPokemon(new Pikachu());
//        pokemonList = p.getPokemonList();
//        assert pokemonList != null;
//        currentPokemon = pokemonList.get(0);
//        assert currentPokemon != null;


        profile = (ImageView) findViewById(R.id.profileimage);
        character_name = (TextView) findViewById(R.id.profilename);
        character_gender = (TextView) findViewById(R.id.gender);
        money = (TextView) findViewById(R.id.money);
        character_description = (TextView) findViewById(R.id.description);


//        if (p.getGender().equals("male")){
//            profile.setImageResource(R.drawable.charater_male);
//            character_gender.setText("Gender: Male");
//        }else{
//            profile.setImageResource(R.drawable.character_female);
//            character_gender.setText("Gender: Female");
//        }

//        int moneynum = p.getMoney();

        profile.setImageResource(R.drawable.character_female);
        character_name.setText("Xiaoming");
        character_gender.setText("Gender: Male");

        money.setText("Money: $1000");
//        money.setText("Money: $" + moneynum);
        character_description.setText("This is the character.");
    }
}
