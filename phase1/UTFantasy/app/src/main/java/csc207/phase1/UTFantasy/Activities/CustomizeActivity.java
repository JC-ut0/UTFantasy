package csc207.phase1.UTFantasy.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class CustomizeActivity extends Activity {

    // determine the progress of this activity
    // 0 indicates player is asked for name
    // 1 indicates player is asked for gender
    private int progress = 0;

    // the name of the player
    private String name;

    // the gender of the player
    private String gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent login_intent = getIntent();
        final UserManager userManager = UserManager.getUserManager();
        final String username = login_intent.getStringExtra("username");
        assert username != null;

        super.onCreate(savedInstanceState);
        // set the content view of this activity to activity_customize
        setContentView(R.layout.activity_customize);

        // initialize all the palette
        final Button buttonA = findViewById(R.id.button_a);
        final Button buttonB = findViewById(R.id.button_b);
        final TextView textViewName = findViewById(R.id.text_view_name);
        final TextView textViewGender = findViewById(R.id.text_view_gender);
        final EditText editTextName = findViewById(R.id.edit_text_name);
        final RadioGroup radioGroup = findViewById(R.id.radio_button_group);
        final RadioButton buttonBoy = findViewById(R.id.radio_button_boy);
        final RadioButton buttonGirl = findViewById(R.id.radio_button_girl);

        // the things to do when button A or button B is clicked
        final View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progress == 0) {

                    // assign name by the input of EditText
                    name = editTextName.getText().toString();

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

                } else if (progress == 1) {

                    // assign gender by checking the radio button input
                    if (buttonBoy.isChecked()) {
                        gender = "boy";
                    } else {
                        gender = "girl";
                    }

                    // initialize the intent
                    Intent intent = new Intent(CustomizeActivity.this, MainActivity.class);

                    // pass in name and gender to MainActivity
                    Player player = new Player(name, gender);
                    User user = userManager.getUser(username);
                    user.setPlayer(player);
                    userManager.save(CustomizeActivity.this);
                    intent.putExtra("username", username);

                    // now go to main activity
                    startActivity(intent);
                }
            }
        };
        buttonA.setOnClickListener(click);

        buttonB.setOnClickListener(click);
    }
}
