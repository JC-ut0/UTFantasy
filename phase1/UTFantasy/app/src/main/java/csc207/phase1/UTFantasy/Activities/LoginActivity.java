package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import csc207.phase1.UTFantasy.MainActivity;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class LoginActivity extends AppCompatActivity {
    private EditText account, pwd;

    public String result, is;
    private String accountStr, passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account = findViewById(R.id.account);
        pwd = findViewById(R.id.pwd);
        final Button btn_log = findViewById(R.id.btn_log);
        final Button btn_register = findViewById(R.id.btn_register);
        final TextView message = findViewById(R.id.pop_up_message);

        final View.OnClickListener click = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
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
                            }else if (passwordStr.equals("")){
                                message("Please Enter your Password");
                            }else if (accountStr.contains("\n")) {
                                message("ImproperNameException");
                                throw new ImproperNameException();
                            }else if (accountStr.contains("fuck")){
                                message("ImproperNameException");
                                throw new ImproperNameException();
                            }
                            else message.setText("@string/account Logging");
                        } catch (Exception e) {
                            message("Error:" + e);
                        } finally {
                            message.setVisibility(View.VISIBLE);
                        }

                        // login if loop
                        if (UserManager.login(accountStr, passwordStr)) {
                            // log in succeeded. pop up a window shows success. Get user Id here.
                            User user = UserManager.getUser(accountStr);
                            message("@string/account Logged In Successfully!");
                            // go to MainActivity after logged in
                            Intent login_intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(login_intent);
                        } else {
                            // log in failed . pop up a window shows failure.
                            message("@string/account or password is not correct!");

                        }

                        break;
                    // case register button is clicked
                    case R.id.btn_register:
                        // TODO: register, store all information about this user to local, exception need to be implemented
                        User user = UserManager.register(accountStr, passwordStr);

                        try {
                            accountStr = account.getText().toString().trim();
                            passwordStr = pwd.getText().toString().trim();
                            if (accountStr.equals("")) {
                                message("Please Enter your Account");
                            }else if (passwordStr.equals("")){
                                message("Please Enter your Password");
                            }else if (accountStr.contains("\n")) {
                                message("ImproperNameException");
                                throw new ImproperNameException();
                            }else if (accountStr.contains("fuck")){
                                message("ImproperNameException");
                                throw new ImproperNameException();
                            }
                            else {
                                message.setText("@string/account Registering");
                                // this is a new user, register, go to set up activity
                                Intent register_intent = new Intent(LoginActivity.this, CustomizeActivity.class);
                                register_intent.putExtra("user", user);
                                startActivity(register_intent);}
                        } catch (Exception e) {
                            message("Error:" + e);
                        } finally {
                            message.setVisibility(View.VISIBLE);
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
        public ImproperNameException() {
            super();
        }
    }

    private void message(String str){
        AlertDialog.Builder builder  = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("UT Fantasy" ) ;
        builder.setMessage(str ) ;
        builder.setPositiveButton("OK" ,  null );
        builder.show();
    }

}
