package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Map.MainActivity;
import csc207.phase2.UTFantasy.InfoMediator;
import csc207.phase2.UTFantasy.R;

public class PlayerInfoActivity extends AppCompatActivity {

  /** the player */
  private Player player;

  /** the unique UserIO */
  private UserIO userIO = UserIO.getUserIO();

  private InfoMediator infoMediator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player_info);

    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();
    infoMediator = new InfoMediator(player);

    setBackToMain();
    setCharacter_description();
    setCharacter_gender_and_profile();
    setCharacter_name();
    setMoney();
  }

  /** Set the character's name. */
  private void setCharacter_name() {
    TextView character_name = findViewById(R.id.profilename);
    character_name.setText(player.getName());
  }

  /** Set the character's gender and it's profile. */
  private void setCharacter_gender_and_profile() {
    TextView character_gender = findViewById(R.id.gender);
    ImageView profile = findViewById(R.id.profileimage);
    profile.setImageResource(infoMediator.getGenderImage());
    character_gender.setText(infoMediator.getGender());
  }

  /** Set the character's money. */
  private void setMoney() {
    TextView money = findViewById(R.id.money);
    money.setText(infoMediator.getMoney());
  }

  /** Set the character's description. */
  private void setCharacter_description() {
    TextView character_description = findViewById(R.id.description);
    character_description.setText(infoMediator.getDescription());
  }

  /** Set the Back Button, it will return to the main activity. */
  private void setBackToMain() {
    ImageButton backToMain = findViewById(R.id.back_to_main);
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
