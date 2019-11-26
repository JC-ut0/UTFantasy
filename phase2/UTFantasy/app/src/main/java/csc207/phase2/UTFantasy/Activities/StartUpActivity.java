package csc207.phase2.UTFantasy.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import csc207.phase2.UTFantasy.Activities.LoginActivityMVP.LoginActivity;
import csc207.phase2.UTFantasy.Activities.scoreboard.ScoreBoardActivity;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;

/**
 * The activity that got launched when launching the app Showing the start up picture for 5 seconds
 * and then go to
 */
public class StartUpActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    // first time get userIO, load user data
    UserIO userIO = UserIO.getSingletonUserIo();
    userIO.loadUserData(StartUpActivity.this);
    // set the content view of this activity to be activity_start_up
    setContentView(R.layout.activity_start_up);
    Button gameStartBt = findViewById(R.id.startButton);
    Button scoreBoardBt = findViewById(R.id.scoreBoard);
    Button leaveBt = findViewById(R.id.leaveButton);

    gameStartBt.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            navigateToLoginActivity();
          }
        });

    scoreBoardBt.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            navigateToScoreBoardActivity();
          }
        });

    leaveBt.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            finish();
          }
        });
  }

  private void navigateToLoginActivity() {
    startActivity(new Intent(StartUpActivity.this, LoginActivity.class));
  }

  private void navigateToScoreBoardActivity() {
      startActivity(new Intent(StartUpActivity.this, ScoreBoardActivity.class));
  }
}
