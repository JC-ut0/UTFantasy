package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;

public class SystemActivity extends AppCompatActivity {

  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();

  /** The buttons. */
  private Button save_button;

  private Button logout_button;
  private Button back_button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_system_menu);

    // set the buttons
    setBack_button();
    setLogout_button();
    setSave_button();
  }

  /** Set the save button. */
  private void setSave_button() {
    save_button = findViewById(R.id.save);
    save_button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            userIO.saveUserData(SystemActivity.this);
            Toast.makeText(SystemActivity.this, "Save Successfully", Toast.LENGTH_SHORT).show();
          }
        });
  }

  /** Set the logout button. */
  private void setLogout_button() {
    logout_button = findViewById(R.id.logout);
    logout_button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            logout();
            Toast.makeText(SystemActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
          }
        });
  }
  /** Save the current User's file, logout and go to LoginActivityFolder. */
  private void logout() {
    // save file first
    userIO.saveUserData(SystemActivity.this);
    // go back to User Activity from the current Activity
    Intent intent = new Intent(SystemActivity.this, StartUpActivity.class);
    // prevent User coming back to this activity!
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

  /** Set the back button. */
  private void setBack_button() {
    back_button = findViewById(R.id.backToStartUp);
    back_button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            onBackPressed();
          }
        });
  }
}
