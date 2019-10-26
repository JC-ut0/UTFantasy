package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class FightActivity extends AppCompatActivity {
    private Player player;
    private boolean clickable = true;
    private ArrayList<Pokemon> pokemonList;
    private Pokemon currentPokemon;
    private int progress = 0;

    // the bottom layout
    LinearLayout informationSection;
    // skill section and menu section
    LinearLayout fightBox;
    RelativeLayout skillSection;
    FrameLayout menuSection;
    // text view and corresponding layout
    FrameLayout battleSection;
    FrameLayout skillInfoSection;
    TextView battleInfo;
    TextView skillInfo;
    // instance of menu buttons
    Button fight;
    Button bag;
    Button newPokemon;
    Button run;
    // instance of skill buttons
    private Button skill_1;
    private Button skill_2;
    private Button skill_3;
    private Button skill_4;
    // Pokemon View
    ImageView myPokemon;
    ImageView rivalPokemon;
    // healthBar
    ProgressBar myHealth;
    ProgressBar rivalHealth;
    // healthBar Text
    TextView myHealthInfo;
    TextView rivalHealthInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeLayOuts();
        // progress for fight, 5 progress in one round
        //================================================================
        Intent main_intent = getIntent();
        String username = main_intent.getStringExtra("username");
        final UserManager userManager = UserManager.getUserManager();
        User user = userManager.getUser(username);
        if (user == null) {
            user = userManager.getUser("12312312");
        }
        if (true) {
            userManager.message("Create a new User", FightActivity.this);
            user = new User("2", "123456");
            user.setPlayer(new Player("ET", "ET"));
            user.getPlayer().addPokemon(new Pikachu());
        }
        assert user != null;
        player = user.getPlayer();
        assert player != null;
        player.addPokemon(new Pikachu());
        pokemonList = player.getPokemonList();
        assert pokemonList != null;
        currentPokemon = pokemonList.get(0);
        assert currentPokemon != null;

        updateSkillButton();

        informationSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickable) {
                    startRound();
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
                        Toast.makeText(FightActivity.this, "Skill one.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.skill_2:
                        Toast.makeText(FightActivity.this, "Skill two.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.skill_3:
                        Toast.makeText(FightActivity.this, "Skill three.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.skill_4:
                        Toast.makeText(FightActivity.this, "Skill four.", Toast.LENGTH_SHORT).show();
                        break;
                }
                fightBox.setVisibility(View.GONE);
                battleSection.setVisibility(View.VISIBLE);
                clickable = true;
                progress++;
            }
        };
        skill_1.setOnClickListener(skillClick);
        skill_2.setOnClickListener(skillClick);
        skill_3.setOnClickListener(skillClick);
        skill_4.setOnClickListener(skillClick);

        // todo: implement Pokemon buttons onClickListener
        newPokemon.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              chooseNewPokemon();
                                              menuSection.setVisibility(View.GONE);
                                              battleSection.setVisibility(View.GONE);
                                              fightBox.setVisibility(View.GONE);
                                              clickable = false;
                                          }
                                      }
        );
        // implement run buttons onClickListener
        run.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              onBackPressed();
                                              userManager.message("!!!!!!", FightActivity.this);
                                          }
                                      }
        );
        // todo: implement run buttons onClickListener
        bag.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       chooseNewPokemon();
                                       menuSection.setVisibility(View.GONE);
                                       battleSection.setVisibility(View.GONE);
                                       fightBox.setVisibility(View.GONE);
                                       clickable = false;
                                   }
                               }
        );
    }

    private void chooseNewPokemon() {

    }

    private void initializeLayOuts() {
        setContentView(R.layout.activity_fight);
        // the bottom layout
        informationSection = findViewById(R.id.bottom_layout);
        // skill section and menu section
        fightBox = findViewById(R.id.fightBox);
        skillSection = findViewById(R.id.skillSection);
        menuSection = findViewById(R.id.menuSection);
        // instance of skill buttons
        skill_1 = findViewById(R.id.skill_1);
        skill_2 = findViewById(R.id.skill_2);
        skill_3 = findViewById(R.id.skill_3);
        skill_4 = findViewById(R.id.skill_4);
        // instance of menu buttons
        fight = findViewById(R.id.fight);
        bag = findViewById(R.id.bag);
        newPokemon = findViewById(R.id.pokemon);
        run = findViewById(R.id.run);
        // text view and corresponding layout
        battleSection = findViewById(R.id.battleSection);
        skillInfoSection = findViewById(R.id.skillInformationSection);
        battleInfo = findViewById(R.id.battle_info);
        skillInfo = findViewById(R.id.skill_info);
        // Pokemon View
        myPokemon = findViewById(R.id.myPokemon);
        rivalPokemon = findViewById(R.id.rivalPokemon);
        // healthBar
        myHealth = findViewById(R.id.myHealthBar);
        ProgressBar rivalHealth = findViewById(R.id.rivalHealthBar);
        // healthBar Text
        myHealthInfo = findViewById(R.id.myHealthInfo);
        rivalHealthInfo = findViewById(R.id.rivalHealthInfo);
    }

    private void startRound() {
        switch (progress) {
            case 0:
                menuSection.setVisibility(View.VISIBLE);
                updateSkillButton();
                clickable = false;
                break;
            case 1:
                battleInfo.setText("progress1:" + progress);
                progress++;
                break;
            case 2:
                battleInfo.setText("progress2:" + progress);
                progress++;
                break;
            case 3:
                battleInfo.setText("progress3:" + progress);
                progress++;
                break;
            case 4:
                battleInfo.setText("progress4:" + progress);
                progress++;
                break;
            case 5:
                battleInfo.setText("progress5:" + progress);
                progress++;
                break;
            case 6:
                battleInfo.setText("What you want to do");
                progress = 0;
                break;
        }
        if (!currentPokemon.isAlive()) {

        }

    }

    private void updateSkillButton() {
        // set all skill to display the currentPokemon's skills
        ArrayList<Skill> currentPokemonSkills = currentPokemon.getSkills();

        try {
            skill_1.setText(currentPokemonSkills.get(0).getName());
            skill_2.setText(currentPokemonSkills.get(1).getName());
            skill_3.setText(currentPokemonSkills.get(2).getName());
            skill_4.setText(currentPokemonSkills.get(3).getName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }


}
