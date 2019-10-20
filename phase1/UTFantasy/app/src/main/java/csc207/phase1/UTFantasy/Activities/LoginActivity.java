package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class LoginActivity extends AppCompatActivity {
    private EditText account, pwd;

    public String result, is;
    private String accountStr, pwdStr;

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
                        //                try{
                        accountStr = account.getText().toString().trim();
                        pwdStr = pwd.getText().toString().trim();
                        message.setVisibility(View.VISIBLE);
                        message.setText("@string/account");



//                }
//                catch (UnproperException e){
//                    message.setText("error");
//                }

                        //TODO: login response with <message>
//                if (User.login(accountStr,pwdStr)) {
//                    // log in succeeded. pop up a window shows success.
//                }else {// log in failed . pop up a window shows failure.}

                        // TODO: if it is our user and logged in successfully, go to mainThread
                        Intent login_intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(login_intent);
                        break;
                    // case register button is clicked
                    case R.id.btn_register:
                        // TODO: register, store all information about this user to local, exception need to be implemented
                        User user = UserManager.register(accountStr,pwdStr);
                        // if it is a new user, register, go to set up activity
                        Intent register_intent = new Intent(LoginActivity.this, CustomizeActivity.class);
                        register_intent.putExtra("user", user);
                        startActivity(register_intent);
                        break;
                    default:
                        break;
                }
            }
        };

        // set all button onClick
        btn_log.setOnClickListener(click);
        btn_register.setOnClickListener(click);
    }


    //    private Exception UnproperException() {
//        // ToDO: complete this Exceptin when the user typed Unproper User name of password.
//    }


}
