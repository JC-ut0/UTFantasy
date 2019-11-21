package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Map.MainActivity;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.UserManager;

public class PlayerInfoActivity extends AppCompatActivity {

  /** the intent of MainActivity */
  Intent intent;

  /** the player */
  Player player;
  /** The unique UserManager. */
  UserManager userManager = UserManager.getUserManager();
  /** The name of the current User. */
  String username;

  /** The stuffs will shown on the activity. */
  ImageView profile;

  TextView character_name;
  TextView character_gender;
  TextView money;
  TextView character_description;
  ImageButton backToMain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player_info);

    intent = getIntent();
    username = intent.getStringExtra("username");
    player = userManager.getUser(username).getPlayer();

    setBackToMain();
    setCharacter_description();
    setCharacter_gender_and_profile();
    setCharacter_name();
    setMoney();
  }

  /** Set the character's name. */
  private void setCharacter_name() {
    character_name = findViewById(R.id.profilename);
    character_name.setText(player.getName());
  }

  /** Set the character's gender and it's profile. */
  private void setCharacter_gender_and_profile() {
    character_gender = findViewById(R.id.gender);
    profile = findViewById(R.id.profileimage);
    if (player.getGender().equals("boy")) {
      profile.setImageResource(R.drawable.charater_male);
      character_gender.setText("Gender: Male");
    } else {
      profile.setImageResource(R.drawable.character_female);
      character_gender.setText("Gender: Female");
    }
  }

  /** Set the character's money. */
  private void setMoney() {
    money = findViewById(R.id.money);
    money.setText("Money: $" + player.getMoney());
  }

  /** Set the character's description. */
  private void setCharacter_description() {
    character_description = findViewById(R.id.description);
    character_description.setText("This is the character.");
  }

  /** Set the Back Button, it will return to the main activity. */
  private void setBackToMain() {
    backToMain = findViewById(R.id.back_to_main);
    backToMain.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(PlayerInfoActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
          }
        });
  }
}
