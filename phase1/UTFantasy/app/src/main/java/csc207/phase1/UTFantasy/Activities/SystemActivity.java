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

    /**
     * The buttons.
     */
    Button save_button;
    Button logout_button;
    Button back_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_menu);

        //set the buttons
        setBack_button();
        setLogout_button();
        setSave_button();
    }

    /**
     * Set the save button.
     */
    private void setSave_button() {
        save_button = findViewById(R.id.save);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.saveUserManager(SystemActivity.this);
                Toast.makeText(SystemActivity.this, "Save Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Set the logout button.
     */
    private void setLogout_button() {
        logout_button = findViewById(R.id.logout);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userManager.logout(SystemActivity.this);
                Toast.makeText(SystemActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Set the back button.
     */
    private void setBack_button() {
        back_button = findViewById(R.id.back);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Toast.makeText(SystemActivity.this, "Resume", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
