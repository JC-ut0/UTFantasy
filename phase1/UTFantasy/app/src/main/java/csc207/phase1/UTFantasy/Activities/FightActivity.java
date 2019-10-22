package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;

@SuppressLint("Registered")
public class FightActivity extends AppCompatActivity {
    private Player player;
    private boolean clickable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fight);

        // the bottom layout
        LinearLayout bottomLayout = findViewById(R.id.bottom_layout);

        // skill section and menu section
        final LinearLayout fightBox = findViewById(R.id.fightBox);
        final RelativeLayout skillSection = findViewById(R.id.skillSection);
        final FrameLayout menuSection = findViewById(R.id.menuSection);

        // instance of skill buttons
        final Button skill_1 = findViewById(R.id.skill_1);
        Button skill_2 = findViewById(R.id.skill_2);
        Button skill_3 = findViewById(R.id.skill_3);
        Button skill_4 = findViewById(R.id.skill_4);

        // instance of menu buttons
        Button fight = findViewById(R.id.fight);
        Button bag = findViewById(R.id.bag);
        Button pokemon = findViewById(R.id.pokemon);
        Button run = findViewById(R.id.run);

        // text view and corresponding layout
        final FrameLayout battleSection = findViewById(R.id.battleSection);
        final TextView battleInfo = findViewById(R.id.battle_info);
        final FrameLayout skillInfoSection = findViewById(R.id.skillInformationSection);
        final TextView skillInfo = findViewById(R.id.skill_info);

        Intent main_intent = getIntent();
        User user = (User) main_intent.getSerializableExtra("user");
        if (user != null) {
            player = user.getPlayer();
        }

        bottomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (clickable){
                   menuSection.setVisibility(View.VISIBLE);
                   clickable = false;
               }
            }
        });

        // implement menu buttons onClickListener
        fight.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         menuSection.setVisibility(View.GONE);
                                         battleSection.setVisibility(View.GONE);
                                         fightBox.setVisibility(View.VISIBLE);
                                         clickable = false;
                                     }
                                 }
        );

        // implement skill buttons onClickListener
        final View.OnClickListener skillClick = new View.OnClickListener() {
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
                fightBox.setVisibility(View.GONE);
                battleSection.setVisibility(View.VISIBLE);
                clickable = true;
            }
        };
        skill_1.setOnClickListener(skillClick);
        skill_2.setOnClickListener(skillClick);
        skill_3.setOnClickListener(skillClick);
        skill_4.setOnClickListener(skillClick);
    }

    private void message(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(FightActivity.this);
        builder.setTitle("UT Fantasy");
        builder.setMessage(str);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
