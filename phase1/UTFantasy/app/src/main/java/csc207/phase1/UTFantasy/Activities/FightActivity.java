package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;

@SuppressLint("Registered")
public class FightActivity extends AppCompatActivity {
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        // instance of skill buttons
        Button skill_1 = findViewById(R.id.skill_1);
        Button skill_2 = findViewById(R.id.skill_2);
        Button skill_3 = findViewById(R.id.skill_3);
        Button skill_4 = findViewById(R.id.skill_4);
        Intent main_intent = getIntent();
        User user = (User) main_intent.getSerializableExtra("user");
        if (user != null) {
            player = user.getPlayer();}
        //
        final View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.skill_1:
                        message("Skill one");
                        break;
                    case R.id.skill_2:
                        message("Skill two");
                        break;
                    case R.id.skill_3:
                        message("Skill three");
                        break;
                    case R.id.skill_4:
                        message("Skill four");
                        break;
                }
            }
        };
        skill_1.setOnClickListener(click);
        skill_2.setOnClickListener(click);
        skill_3.setOnClickListener(click);
        skill_4.setOnClickListener(click);
    }
    private void message(String str){
        AlertDialog.Builder builder  = new AlertDialog.Builder(FightActivity.this);
        builder.setTitle("UT Fantasy" ) ;
        builder.setMessage(str ) ;
        builder.setPositiveButton("OK" ,  null );
        builder.show();
    }
}
