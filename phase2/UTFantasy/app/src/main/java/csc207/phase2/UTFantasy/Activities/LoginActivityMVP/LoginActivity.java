package csc207.phase2.UTFantasy.Activities.LoginActivityMVP;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import csc207.phase2.UTFantasy.Activities.CustomizeActivity;
import csc207.phase2.UTFantasy.CustomizeException.ImproperUserSettingException;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.User.User;
import csc207.phase2.UTFantasy.User.UserManagerFacade;
import csc207.phase2.UTFantasy.Activities.mapUI.MainActivity;

/** The activity used to log into the game with username and passwords. */
public class LoginActivity extends AppCompatActivity implements LoginView {

  /** EditText account and password. */
  private EditText account, pwd;

  /** a checkbox shows whether this user want to remember his password. */
  private CheckBox rememberPassword;

  /** SharedPreferences */
  private SharedPreferences pref;

  /** LoginActivityFolder Presneter */
  private LoginPresenter loginPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.v("TAG", "Logging");
    super.onCreate(savedInstanceState);
    // set for full screen and initialize all fields.
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_login);
    // initialize userIO and UserManagerFacade
    UserIO userIO = UserIO.getSingletonUserIo();
    UserManagerFacade userManagerFacade = new UserManagerFacade(userIO, LoginActivity.this);
    loginPresenter = new LoginPresenter(this, userManagerFacade);
    account = findViewById(R.id.account);
    pwd = findViewById(R.id.pwd);
    pref = PreferenceManager.getDefaultSharedPreferences(this);
    rememberPassword = findViewById(R.id.remember_password);
    loadPassword();
    final Button btnLog = findViewById(R.id.btn_log);
    final Button btnRegister = findViewById(R.id.btn_register);
    final Button btnBack = findViewById(R.id.backToStartUp);

    // when log in button is clicked
    btnLog.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // exceptions we need to consider
            try {
              loginPresenter.validateUsernameAndPasswordForLogin(
                  account.getText().toString().trim(), pwd.getText().toString().trim());
            } catch (Exception e) {
              e.printStackTrace();
              Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
          }
        });
    // when register button is clicked
    btnRegister.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            // when register button is clicked
            try {
              validateUsernameAndPasswordForRegister();
            } catch (Exception e) {
              e.printStackTrace();
              Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
          }
        });
    // when back button is clicked
    btnBack.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            onBackPressed();
          }
        });
  }

  /**
   * If the user selects remember password, his password and username will be stored for his next
   * login.
   */
  public void rememberPassword() {
    // Save to sharedPreference
    SharedPreferences.Editor editor = pref.edit();
    if (rememberPassword.isChecked()) {
      editor.putBoolean("remember_password", true);
      editor.putString("account", account.getText().toString().trim());
      editor.putString("pwd", pwd.getText().toString().trim());
    } else editor.clear();
    editor.apply();
  }

  /**
   * If the user selected remember password last time, his user name and password will be loaded.
   */
  private void loadPassword() {
    boolean isRemember = pref.getBoolean("remember_password", false);
    if (isRemember) {
      account.setText(pref.getString("account", ""));
      pwd.setText(pref.getString("pwd", ""));
      rememberPassword.setChecked(true);
    }
  }

  /**
   * Make sure that the username and password are valid.
   *
   * @throws ImproperUserSettingException if username and password are not valid
   */
  private void validateUsernameAndPasswordForRegister() throws ImproperUserSettingException {
    loginPresenter.validateUsernameAndPasswordForRegister(
        account.getText().toString().trim(), pwd.getText().toString().trim());
  }

  /**
   * If the account is not registered or doesn't have a player, jump to CustomizeActivity to create
   * a new player.
   */
  public void newPlayerAction(User user) {
    rememberPassword();
    Intent register_intent = new Intent(LoginActivity.this, CustomizeActivity.class);
    // prevent User coming back to this activity!
    register_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    register_intent.putExtra("username", user.getName());
    startActivity(register_intent);
  }

  /**
   * If the parameter user has been customized, jump to the MainActivity, else, the user is
   * registered but not customized, jump to CustomizeActivity to create a new player.
   *
   * @param user the login user
   */
  public void logInAction(User user) {
    rememberPassword();
    // log in succeeded. pop up a window shows success. Get user Icon here.
    if (user.hasPlayer()) {
      // go to MainActivity after logged in
      Intent login_intent = new Intent(LoginActivity.this, MainActivity.class);
      login_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      login_intent.putExtra("username", user.getName());
      startActivity(login_intent);
    } else {
      // create a player
      newPlayerAction(user);
    }
  }
}
