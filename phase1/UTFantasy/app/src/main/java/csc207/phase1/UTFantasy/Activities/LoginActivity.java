package csc207.phase1.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class LoginActivity extends AppCompatActivity {
    UserManager localUserManager;
    private EditText account, pwd;
    private String accountStr, passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account = findViewById(R.id.account);
        pwd = findViewById(R.id.pwd);
        final Button btn_log = findViewById(R.id.btn_log);
        final Button btn_register = findViewById(R.id.btn_register);
        final UserManager userManager = new UserManager();
        localUserManager = userManager;
        updateUserHashMap();

        final View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {

                    // case login button is clicked
                    case R.id.btn_log:
                        // exceptions we need to consider
                        try {
                            accountStr = account.getText().toString().trim();
                            passwordStr = pwd.getText().toString().trim();
                            if (accountStr.equals("")) {
                                message("Please Enter your Account");
                            } else if (passwordStr.equals("")) {
                                message("Please Enter your Password");
                            } else if (accountStr.contains("\n")) {
                                throw new ImproperNameException();
                            } else if (accountStr.contains("fuck")) {
                                throw new ImproperNameException();
                            }
                        } catch (Exception e) {
                            message("Error:" + e);
                        }

                        // login if loop
                        if (userManager.login(accountStr, passwordStr)) {
                            // log in succeeded. pop up a window shows success. Get user Id here.
                            User user = userManager.getUser(accountStr);
                            // go to MainActivity after logged in
                            Intent login_intent = new Intent(LoginActivity.this, MainActivity.class);
                            // pass in name and gender to MainActivity
                            Player player = new Player("ET", "ET");
                            user.setPlayer(player);
                            login_intent.putExtra("player", player);
                            login_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(login_intent);
                        } else {
                            // log in failed . pop up a window shows failure.
                            message("@string/account or password is not correct!");

                        }

                        break;
                    // case register button is clicked
                    case R.id.btn_register:
                        try {
                            accountStr = account.getText().toString().trim();
                            passwordStr = pwd.getText().toString().trim();
                            if (accountStr.equals("")) {
                                message("Please Enter your Account");
                            } else if (passwordStr.equals("")) {
                                message("Please Enter your Password");
                            } else if (passwordStr.length() < 6) {
                                message("Your Password need to have at least 6 letters.");
                            } else if (passwordStr.contains(";")) {
                                message("Your Password cannot contain a ;");
                            } else if (accountStr.contains(";")) {
                                throw new ImproperNameException();
                            } else if (userManager.getUserHashMap().containsKey(accountStr)) {
                                message("The UserName is used.");
                            } else if (accountStr.contains("\n")) {
                                throw new ImproperNameException();
                            } else if (accountStr.contains("fuck")) {
                                throw new ImproperNameException();
                            } else {
                                // this is a new user, register, go to set up activity
                                save(accountStr, passwordStr);
                                updateUserHashMap();
                                User user = userManager.register(accountStr, passwordStr);
                                Intent register_intent = new Intent(LoginActivity.this, CustomizeActivity.class);
                                // prevent User coming back to this activity!
                                register_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                register_intent.putExtra("user", user);
                                startActivity(register_intent);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            message("Error:" + e);
                        }

                        break;
                    default: // nothing
                        break;
                }
            }
        };

        // set all button onClick
        btn_log.setOnClickListener(click);
        btn_register.setOnClickListener(click);
    }


    class ImproperNameException extends Exception {
        // ToDO: complete this Exception when the user typed Improper User name of password.
        public ImproperNameException(String str) {
            super(str);
        }

        ImproperNameException() {
            super();
        }
    }

    private void message(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("UT Fantasy");
        builder.setMessage(str);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void save(String accountStr, String passwordStr) throws FileNotFoundException {
        try {
            FileOutputStream fos = openFileOutput("data.txt", MODE_PRIVATE);
            String inputFileContext = accountStr + ";" + passwordStr + "\n";
            fos.write(inputFileContext.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUserHashMap() {
        HashMap<String, User> userHashMap = new HashMap<>();
        try {
            FileInputStream fis = openFileInput("data.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;
            while ((text = br.readLine()) != null) {
                String[] userInfo = text.split(";");
                User user = new User(userInfo[0], userInfo[1]);
                userHashMap.put(userInfo[0], user);
                localUserManager.setUserHashMap(userHashMap);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            localUserManager.setUserHashMap(userHashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
