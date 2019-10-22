package csc207.phase1.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class LoginActivity extends AppCompatActivity {
    private UserManager userManager = UserManager.getUserManager();
    private EditText account, pwd;
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

        try {
            userManager.loadUser(LoginActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // when log in button is clicked
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // exceptions we need to consider
                try {
                    accountStr = account.getText().toString().trim();
                    passwordStr = pwd.getText().toString().trim();
                    if (accountStr.equals("")) {
                        message("Please Enter your Account");
                    } else if (passwordStr.equals("")) {
                        message("Please Enter your Password");
                    }
                } catch (Exception e) {
                    message("Error:" + e);
                }
                // login if loop
                if (userManager.login(accountStr, passwordStr)) {
                    logInAction();
                } else {
                    // log in failed . pop up a window shows failure.
                    message("@string/account or password is not correct!");
                }
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when register button is clicked
                try {
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
                        message("The UserName is used.");
                    } else if (accountStr.contains("\n")) {
                        throw new ImproperUserSettingException("Invalid punctuation is used.");
                    } else if (accountStr.contains("fuck")) {
                        throw new ImproperUserSettingException("Please be polite!");
                    } else {
                        newPlayerAction();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    class ImproperUserSettingException extends Exception {
        // ToDO: complete this Exception when the user typed Improper User name of password.
        ImproperUserSettingException() {
        }

        ImproperUserSettingException(String str) {
            super(str);
        }
    }

    private void message(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("UT Fantasy");
        builder.setMessage(str);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void newPlayerAction() {
        // this is a new user, saveFile the info of this user, go to set up activity
        User user = userManager.register(accountStr, passwordStr);
        userManager.save(LoginActivity.this);
        Intent register_intent = new Intent(LoginActivity.this, CustomizeActivity.class);
        // prevent User coming back to this activity!
        register_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        register_intent.putExtra("username", user.getName());
        startActivity(register_intent);
    }

    private void logInAction() {
        // log in succeeded. pop up a window shows success. Get user Id here.
        User user = userManager.getUser(accountStr);
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
