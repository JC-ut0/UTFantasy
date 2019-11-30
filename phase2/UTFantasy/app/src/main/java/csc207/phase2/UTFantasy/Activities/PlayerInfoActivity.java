package csc207.phase2.UTFantasy.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import csc207.phase2.UTFantasy.Activities.scoreboard.ScoreCalculator;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.mapUI.MainActivity;
import csc207.phase2.UTFantasy.R;

public class PlayerInfoActivity extends AppCompatActivity {

  /** the player */
  private Player player;

  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();
  /** The information mediator. */
  private InfoMediator infoMediator;
  /** The checkbox for showing score*/
  private CheckBox showingScoreCheckBox;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_player_info);

    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();
    infoMediator = new InfoMediator(player);

    setPlayerStatistics();
    setScoreCheckBox();
    setBackToMain();
    setCharacter_description();
    setCharacter_gender_and_profile();
    setCharacter_name();
    setMoney();
  }

  @SuppressLint("SetTextI18n")
  private void setPlayerStatistics() {
    TextView percentile = findViewById(R.id.percentile);
    percentile.setText(getTopPercentilByPokemonLv(player));
    TextView numPokemonOwned = findViewById(R.id.pokemonNum);
    numPokemonOwned.setText("Number Pokemons Owned:" + player.getPokemonList().size());
    TextView maxPokemonLV = findViewById(R.id.pokemonLV);
    maxPokemonLV.setText("Highest Pokemons Level:" + player.getPlayerPokemonMaxLV());
  }

  private void setScoreCheckBox() {
    showingScoreCheckBox = findViewById(R.id.showingScore);
    showingScoreCheckBox.setChecked(player.isShowingScore());
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
            onBackPressed();
          }
        });
  }

  public void changeShowingScore(View view) {
    if (showingScoreCheckBox.isChecked()) {
      player.setShowingScore(false);
    } else player.setShowingScore(true);
  }

  public String getTopPercentilByPokemonLv(Player player) {
    UserIO userIO = UserIO.getSingletonUserIo();
    List<Player> playerList = userIO.getUserData().getScoreBoardPlayerList();
    ScoreCalculator scoreCalculator = new ScoreCalculator(playerList);
    return scoreCalculator.getTopPercentilByPokemonLv(player);
  }
}
