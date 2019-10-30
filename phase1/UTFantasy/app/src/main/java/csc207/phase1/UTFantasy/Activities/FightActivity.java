package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.FighterNPC;
import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.FightManager;
import csc207.phase1.UTFantasy.NPCManager;
import csc207.phase1.UTFantasy.Pet.Charmander;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Pet.Squirtle;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class FightActivity extends AppCompatActivity {
    private Player player;
    private FighterNPC opponent;
    private ArrayList<Pokemon> pokemonList;
    private Pokemon currentPokemon;
    private Pokemon currentRivalPokemon;
    private FightManager fightManager;

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
    ArrayList<String> turnInfo;
    NPCManager npcManager;
    boolean clickable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            user.getPlayer().addPokemon(new Squirtle());
            npcManager = NPCManager.getNpcManager();
            opponent = new FighterNPC("2");
            opponent.getPokemonList().add(new Charmander());
        }
        assert user != null;
        player = user.getPlayer();
        assert player != null;
        player.addPokemon(new Pikachu());
        pokemonList = player.getPokemonList();
        assert pokemonList != null;
        currentPokemon = pokemonList.get(0);
        assert currentPokemon != null;

        fightManager = new FightManager(player, opponent);
        initializeLayOuts();

        String NPCname = main_intent.getStringExtra("NPCname");
        NPC npc = NPCManager.getNpcManager().getNPC(NPCname);
        if (npc == null) {
            npc = new FighterNPC("poor student");
        }
        assert npc != null;

        updateForPokemonExchange();
        updateHpBar();
        informationSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRound();
            }
        });

        // implement menu buttons onClickListener
        fight.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         menuSection.setVisibility(View.GONE);
                                         battleSection.setVisibility(View.GONE);
                                         fightBox.setVisibility(View.VISIBLE);
                                     }
                                 }
        );

        // implement skill buttons onClickListener
        final View.OnClickListener skillClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.skill_1:
                        fightManager.setSkill(fightManager.getPlayerPokemon().getSkills()[0]);
                        break;
                    case R.id.skill_2:
                        fightManager.setSkill(fightManager.getPlayerPokemon().getSkills()[1]);
                        break;
                    case R.id.skill_3:
                        fightManager.setSkill(fightManager.getPlayerPokemon().getSkills()[2]);
                        break;
                    case R.id.skill_4:
                        fightManager.setSkill(fightManager.getPlayerPokemon().getSkills()[3]);
                        break;
                }
                if (fightManager.getSkill() != null) {
                    fightBox.setVisibility(View.GONE);
                    battleSection.setVisibility(View.VISIBLE);
                    fightManager.setRivalSkill();
                    fightManager.determineTurn();
                    battleInfo.setText(fightManager.updateInfo(fightManager.getProgress()));
                    clickable = true;
                }
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
                                          }
                                      }
        );
        // implement run buttons onClickListener
        run.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       endFight();
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
        battleInfo.setText(fightManager.updateInfo(7));
        skillInfo = findViewById(R.id.skill_info);
        // Pokemon View
        myPokemon = findViewById(R.id.myPokemon);
        rivalPokemon = findViewById(R.id.rivalPokemon);
        // healthBar
        myHealth = findViewById(R.id.myHealthBar);
        rivalHealth = findViewById(R.id.rivalHealthBar);
        // healthBar Text
        myHealthInfo = findViewById(R.id.myHealthInfo);
        rivalHealthInfo = findViewById(R.id.rivalHealthInfo);
    }

    private void startRound() {
        if (clickable) {
            if (fightManager.getProgress() == -1) {
                endFight();
            } else if (fightManager.getProgress() == 0) {
                updateHpBar();
                menuSection.setVisibility(View.VISIBLE);
                clickable = false;
            } else {
                updateHpBar();
                updateForPokemonExchange();
            }

            battleInfo.setText(fightManager.updateInfo(fightManager.getProgress()));
        }

    }

    private void updateForPokemonExchange() {
        currentPokemon = fightManager.getPlayerPokemon();
        currentRivalPokemon = fightManager.getRivalPokemon();
        Drawable myPokemonDrawable = getResources().getDrawable(currentPokemon.getProfileID());
        Drawable rivalPokemonDrawable = getResources().getDrawable(currentRivalPokemon.getProfileID());
        myPokemon.setImageDrawable(myPokemonDrawable);
        rivalPokemon.setImageDrawable(rivalPokemonDrawable);
        updateSkillButton();
        myHealth.setMax(currentPokemon.getMaximumHp());
        rivalHealth.setMax(currentRivalPokemon.getMaximumHp());
    }

    private void updateHpBar() {
        myHealth.setProgress(currentPokemon.getHp());
        myHealthInfo.setText(currentPokemon.getHp() + "/" + currentPokemon.getMaximumHp());
        rivalHealth.setProgress(currentRivalPokemon.getHp());
        rivalHealthInfo.setText(currentRivalPokemon.getHp() + "/" + currentRivalPokemon.getMaximumHp());
    }


    public void endFight() {
        //TODO : back parent
        onBackPressed();
    }

    private void updateSkillButton() {
        // set all skill to display the currentPokemon's skills
        Skill[] currentPokemonSkills = currentPokemon.getSkills();

        try {
            skill_1.setText(currentPokemon.getSkills()[0].getName());
            skill_2.setText(currentPokemon.getSkills()[1].getName());
            skill_3.setText(currentPokemon.getSkills()[2].getName());
            skill_4.setText(currentPokemon.getSkills()[3].getName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
