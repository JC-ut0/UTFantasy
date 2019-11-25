package csc207.phase2.UTFantasy.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.CustomizeException.ImproperPlayerNameException;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Map.MainActivity;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.User.User;
import csc207.phase2.UTFantasy.User.UserManagerFacade;

/** The activity used to create a new user. */
public class CustomizeActivity extends Activity {

  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();
  /**
   * determine the progress of this activity 0 indicates player is asked for name 1 indicates player
   * is asked for gender
   */
  private int progress = 0;
  /** the name of the player */
  private String name;
  /** the gender of the player */
  private String gender;
  /** stuffs shows on this activity */
  private TextView textViewName;

  private TextView textViewGender;
  private EditText editTextName;
  private RadioGroup radioGroup;
  private RadioButton buttonBoy;
  private RadioButton buttonGirl;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    // set the content view of this activity to activity_customize
    setContentView(R.layout.activity_customize);
    // initialize userIO and UserManagerFacade
    UserIO userIO = UserIO.getSingletonUserIo();
    UserManagerFacade userManagerFacade = new UserManagerFacade(userIO, CustomizeActivity.this);

    // initialize all the palette
    Button buttonA = findViewById(R.id.button_a);
    Button buttonB = findViewById(R.id.button_b);
    textViewName = findViewById(R.id.text_view_name);
    textViewGender = findViewById(R.id.text_view_gender);
    editTextName = findViewById(R.id.edit_text_name);
    radioGroup = findViewById(R.id.radio_button_group);
    buttonBoy = findViewById(R.id.radio_button_boy);
    buttonGirl = findViewById(R.id.radio_button_girl);

    // the things to do when button A or button B is clicked
    final View.OnClickListener click =
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (progress == 0) {
              name = editTextName.getText().toString().trim();
              try {
                validatePlayerName();
              } catch (ImproperPlayerNameException e) {
                Toast.makeText(CustomizeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
              }

            } else if (progress == 1) {

              if (buttonBoy.isChecked()) {
                gender = "boy";
                move_to_main();
              } else if (buttonGirl.isChecked()) {
                gender = "girl";
                move_to_main();
              } else {
                Toast.makeText(CustomizeActivity.this, "Please Choose A Gender", Toast.LENGTH_LONG)
                    .show();
              }
            }
          }
        };
    buttonA.setOnClickListener(click);

    buttonB.setOnClickListener(click);
  }

  /** set up gender */
  private void goChooseGender() {
    // set the questions of name to be invisible
    textViewName.setVisibility(View.GONE);
    editTextName.setVisibility(View.GONE);

    // set the questions of gender to be visible
    textViewGender.setVisibility(View.VISIBLE);
    radioGroup.setVisibility(View.VISIBLE);
    buttonBoy.setVisibility(View.VISIBLE);
    buttonGirl.setVisibility(View.VISIBLE);
    // increase the progress
    progress += 1;
  }

  /**
   * After registering a new account, information of this account is stored in the UserData, and
   * user can get into the game with a character, player.
   */
  private void move_to_main() {
    Intent login_intent = getIntent();
    String username = login_intent.getStringExtra("username");
    // initialize the intent
    Intent intent = new Intent(CustomizeActivity.this, MainActivity.class);

    // pass in name and gender to MainActivity
    Player player = new Player(name, gender);
    User user = userIO.getUserData().getUser(username);
    user.setPlayer(player);
    userIO.saveUserData(CustomizeActivity.this);
    intent.putExtra("username", username);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    // now go to main activity
    startActivity(intent);
  }

  /**
   * Validate name of player.
   *
   * @throws ImproperPlayerNameException If the name is not valid.
   */
  private void validatePlayerName() throws ImproperPlayerNameException {
    if (name.equals("")) {
      throw new ImproperPlayerNameException("Please Enter your name");
    } else if (name.contains(";")) {
      throw new ImproperPlayerNameException("Invalid punctuation is used.");
    } else if (name.contains("\n")) {
      throw new ImproperPlayerNameException("Invalid punctuation is used.");
    } else if (name.contains("fuck")) {
      throw new ImproperPlayerNameException("Please be polite!");
    } else goChooseGender();
  }
}
