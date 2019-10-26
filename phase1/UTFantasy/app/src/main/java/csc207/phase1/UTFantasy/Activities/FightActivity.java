package csc207.phase1.UTFantasy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Pet.Pikachu;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

@SuppressLint("Registered")
public class FightActivity extends AppCompatActivity {
    private Player player;
    private boolean clickable = true;
    private ArrayList<Pokemon> pokemonList;
    private Pokemon currentPokemon;

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
        final Button skill_2 = findViewById(R.id.skill_2);
        final Button skill_3 = findViewById(R.id.skill_3);
        final Button skill_4 = findViewById(R.id.skill_4);

        // instance of menu buttons
        Button fight = findViewById(R.id.fight);
        Button bag = findViewById(R.id.bag);
        Button newPokemon = findViewById(R.id.pokemon);
        Button run = findViewById(R.id.run);

        // text view and corresponding layout
        final FrameLayout battleSection = findViewById(R.id.battleSection);
        final FrameLayout skillInfoSection = findViewById(R.id.skillInformationSection);
        TextView battleInfo = findViewById(R.id.battle_info);
        TextView skillInfo = findViewById(R.id.skill_info);
        // layout setup finished
        //================================================================
        Intent main_intent = getIntent();
        User user = (User) main_intent.getSerializableExtra("user");
        if (user == null) {
            UserManager userManager = UserManager.getUserManager();
            userManager.loadUserManager(FightActivity.this);
            user = userManager.getUser("123123123");
        }
        if (user == null) {
            UserManager userManager = UserManager.getUserManager();
            userManager.message("Create a new User", FightActivity.this);
            User user1 = new User("2", "123456");
            user1.setPlayer(new Player("ET", "ET"));
            user1.getPlayer().addPokemon(new Pikachu());
        }
        assert user != null;
        player = user.getPlayer();
        assert player != null;
        player.addPokemon(new Pikachu());
        pokemonList = player.getPokemonList();
        assert pokemonList != null;
        currentPokemon = pokemonList.get(0);
        assert currentPokemon != null;
        updateSkillButton(skill_1, skill_2, skill_3, skill_4);

        bottomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickable) {
                    menuSection.setVisibility(View.VISIBLE);
                    updateSkillButton(skill_1, skill_2, skill_3, skill_4);
                    clickable = false;
                }
            }
        });

        // wait for NPC's turn(menuSection invisible), fight when it is player's turn (menuSection visible)
        // after the player's turn menuSection becomes invisible again.

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
        final View.OnClickListener skillClick = getOnClickSkillListener(fightBox, battleSection);
        skill_1.setOnClickListener(skillClick);
        skill_2.setOnClickListener(skillClick);
        skill_3.setOnClickListener(skillClick);
        skill_4.setOnClickListener(skillClick);
    }

    private void updateSkillButton(Button skill_1, Button skill_2, Button skill_3, Button skill_4) {
        // set all skill to display the currentPokemon's skills
        Skill[] currentPokemonSkills = currentPokemon.getSkills();
        try {
            skill_1.setText(currentPokemonSkills[0].getName());
            skill_2.setText(currentPokemonSkills[1].getName());
            skill_3.setText(currentPokemonSkills[2].getName());
            skill_4.setText(currentPokemonSkills[3].getName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    @NotNull
    private View.OnClickListener getOnClickSkillListener(final LinearLayout fightBox, final FrameLayout battleSection) {
        return new View.OnClickListener() {
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
            }
        };
    }


}
