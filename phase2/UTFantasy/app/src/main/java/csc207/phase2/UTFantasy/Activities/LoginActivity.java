package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.CustomizeException.ImproperUserSettingException;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.User;
import csc207.phase2.UTFantasy.UserManager;

/**
 * The activity used to log into the game with username and passwords.
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * the unique UserManager
     */
    private UserManager userManager = UserManager.getUserManager();
    /**
     * EditText account and password.
     */
    private EditText account, pwd;

    /**
     * account and password entered by a user
     */
    private String accountStr, passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("TAG", "Logging");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account = findViewById(R.id.account);
        pwd = findViewById(R.id.pwd);
        final Button btn_log = findViewById(R.id.btn_log);
        final Button btn_register = findViewById(R.id.btn_register);

        // firstly load the userManager
        userManager.loadUserManager(LoginActivity.this);

        // when log in button is clicked
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // exceptions we need to consider
                try {
                    nonEmptyAccountOrPassword();
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                // login if
                User user = userManager.login(accountStr, passwordStr);
                if (user == null) {
                    // log in failed . pop up a window shows failure.
                    Toast.makeText(LoginActivity.this, "@string/account or password is not correct!", Toast.LENGTH_LONG).show();
                } else {
                    logInAction(user);
                }
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                // when register button is clicked
                                                try {
                                                    validateUsernameAndPassword();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        }
        );
    }

    /**
     * Make sure that the account and password are not empty.
     */
    private void nonEmptyAccountOrPassword() {
        accountStr = account.getText().toString().trim();
        passwordStr = pwd.getText().toString().trim();
        if (accountStr.equals("")) {
            Toast.makeText(LoginActivity.this, "Please Enter your Account", Toast.LENGTH_LONG).show();
        } else if (passwordStr.equals("")) {
            Toast.makeText(LoginActivity.this, "Please Enter your Password", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Make sure that the username and password are valid.
     *
     * @throws ImproperUserSettingException if username and password are not valid
     */
    private void validateUsernameAndPassword() throws ImproperUserSettingException {
        accountStr = account.getText().toString().trim();
        passwordStr = pwd.getText().toString().trim();
        if (accountStr.equals("")) {
            throw new ImproperUserSettingException("Please Enter your Account");
        } else if (passwordStr.equals("")) {
            throw new ImproperUserSettingException("Please Enter your Password");
        } else if (passwordStr.length() < 6) {
            throw new ImproperUserSettingException("Your Password need to have at least 6 letters.");
        } else if (passwordStr.contains(";")) {
            throw new ImproperUserSettingException("Invalid punctuation is used.");
        } else if (accountStr.contains(";")) {
            throw new ImproperUserSettingException("Invalid punctuation is used.");
        } else if (userManager.getUserHashMap().containsKey(accountStr)) {
            Toast.makeText(LoginActivity.this, "The UserName is used.", Toast.LENGTH_LONG).show();
        } else if (accountStr.contains("\n")) {
            throw new ImproperUserSettingException("Invalid punctuation is used.");
        } else if (accountStr.contains("fuck")) {
            throw new ImproperUserSettingException("Please be polite!");
        } else {
            newPlayerAction();
        }
    }

    /**
     * If the account is not registered or doesn't have a player, jump to CustomizeActivity to create a new player.
     */
    private void newPlayerAction() {
        // this is a new user, saveFile the info of this user, go to set up activity
        User user = userManager.register(accountStr, passwordStr);
        userManager.saveUserManager(LoginActivity.this);
        Intent register_intent = new Intent(LoginActivity.this, CustomizeActivity.class);
        // prevent User coming back to this activity!
        register_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        register_intent.putExtra("username", user.getName());
        startActivity(register_intent);
    }

    /**
     * If the parameter user has been customized, jump to the MainActivity,
     * else, the user is registered but not customized, jump to CustomizeActivity to create a new player.
     *
     * @param user the login user
     */
    private void logInAction(User user) {
        // log in succeeded. pop up a window shows success. Get user Id here.
        if (user.hasPlayer()) {
            // go to MainActivity after logged in
            Intent login_intent = new Intent(LoginActivity.this, MainActivity.class);
            login_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            login_intent.putExtra("username", user.getName());
            startActivity(login_intent);
        } else {
            // create a player
            newPlayerAction();
        }
    }

}
