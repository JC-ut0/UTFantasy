package csc207.phase1.UTFantasy.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.UserManager;

public class SystemActivity extends AppCompatActivity {

    /**
     * The unique UserManager.
     */
    UserManager userManager = UserManager.getUserManager();
    Button save_button;
    Button logout_button;
    Button back_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_menu);


        save_button = findViewById(R.id.save);
        logout_button = findViewById(R.id.logout);
        back_button = findViewById(R.id.back);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.saveUserManager(SystemActivity.this);
                Toast.makeText(SystemActivity.this, "Save Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.logout(SystemActivity.this);
                Toast.makeText(SystemActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Toast.makeText(SystemActivity.this, "Resume", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
