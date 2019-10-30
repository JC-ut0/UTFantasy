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

        intent = getIntent();
        username = intent.getStringExtra("username");
        User user = userManager.getUser(username);
        p = user.getPlayer();

        profile = findViewById(R.id.profileimage);
        character_name = findViewById(R.id.profilename);
        character_gender = findViewById(R.id.gender);
        money = findViewById(R.id.money);
        character_description = findViewById(R.id.description);


        if (p.getGender().equals("boy")){
            profile.setImageResource(R.drawable.charater_male);
            character_gender.setText("Gender: Male");
        }else{
            profile.setImageResource(R.drawable.character_female);
            character_gender.setText("Gender: Female");
        }


        character_name.setText(p.getName());


        money.setText("Money: $" + p.getMoney());
        character_description.setText("This is the character.");



        backtomain = findViewById(R.id.back_to_main);
        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayerInfoActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }
}
