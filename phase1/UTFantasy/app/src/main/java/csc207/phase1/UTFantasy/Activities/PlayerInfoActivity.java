package csc207.phase1.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
    ImageButton backtomain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

//        intent = getIntent();
//        username = intent.getStringExtra("username");
//        User user = userManager.getUser(username);
//        player = user.getPlayer();


//        assert user != null;
//        player = user.getPlayer();
//        assert player != null;
//        player.addPokemon(new Pikachu());
//        pokemonList = player.getPokemonList();
//        assert pokemonList != null;
//        currentPokemon = pokemonList.get(0);
//        assert currentPokemon != null;

        if (true) {
            UserManager userManager = UserManager.getUserManager();
            userManager.message("Create a new User", PlayerInfoActivity.this);
            User user = new User("2", "123456");
            user.setPlayer(new Player("ET", "ET"));
            user.getPlayer().addPokemon(new Pikachu());
        }


        profile = (ImageView) findViewById(R.id.profileimage);
        character_name = (TextView) findViewById(R.id.profilename);
        character_gender = (TextView) findViewById(R.id.gender);
        money = (TextView) findViewById(R.id.money);
        character_description = (TextView) findViewById(R.id.description);


//        if (player.getGender().equals("male")){
//            profile.setImageResource(R.drawable.charater_male);
//            character_gender.setText("Gender: Male");
//        }else{
//            profile.setImageResource(R.drawable.character_female);
//            character_gender.setText("Gender: Female");
//        }

//        int moneynum = player.getMoney();

        profile.setImageResource(R.drawable.character_female);
        character_name.setText("Xiaoming");
        character_gender.setText("Gender: Male");

        money.setText("Money: $1000");
//        money.setText("Money: $" + moneynum);
        character_description.setText("This is the character.");



        backtomain = (ImageButton)findViewById(R.id.back_to_main);
        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
