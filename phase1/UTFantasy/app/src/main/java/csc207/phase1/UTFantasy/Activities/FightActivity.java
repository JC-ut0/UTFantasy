package csc207.phase1.UTFantasy.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


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
    /**
     * the player who participate in the fight
     */
    private Player player;
    /**
     * the opponent this player fight with
     */
    private FighterNPC opponent;
    /**
     * a list of pokemon the player has
     */
    private ArrayList<Pokemon> pokemonList;
    /**
     * the pokemon chosen to participant in fight
     */
    private Pokemon currentPokemon;
    /**
     * the pokemon player's pokemon fight with
     */
    private Pokemon currentRivalPokemon;

    private FightManager fightManager;

    /**
     * the bottom layout
     */
    LinearLayout informationSection;

    /**
     * skill section and menu section
     */
    LinearLayout fightBox;
    RelativeLayout skillSection;
    FrameLayout menuSection;

    /**
     * text view and corresponding layout
     */
    FrameLayout battleSection;
    FrameLayout skillInfoSection;
    TextView battleInfo;
    TextView skillInfo;

    /**
     * instance of menu buttons
     */
    Button fight;
    Button bag;
    Button newPokemon;
    Button run;

    /**
     * instance of skill buttons
     */
    private Button skill_1;
    private Button skill_2;
    private Button skill_3;
    private Button skill_4;

    /**
     * Pokemon View
     */
    ImageView myPokemon;
    ImageView rivalPokemon;

    /**
     * healthBar
     */
    ProgressBar myHealth;
    ProgressBar rivalHealth;

    /**
     * healthBar Text
     */
    TextView myHealthInfo;
    TextView rivalHealthInfo;

    ArrayList<String> turnInfo;
    NPCManager npcManager;
    LinearLayout choosePokemon;
    boolean clickable = true;

    /**
     * first pokemon in bag
     */
    private ImageView firstPokemonInBag;
    private TextView firstPokemonHealthInfo;
    private ProgressBar firstPokemonHealthBar;

    /**
     * second pokemon in bag
     */
    private ImageView secondPokemonInBag;
    private TextView secondPokemonHealthInfo;
    private ProgressBar secondPokemonHealthBar;

    /**
     * third pokemon in bag
     */
    private ImageView thirdPokemonInBag;
    private TextView thirdPokemonHealthInfo;
    private ProgressBar thirdPokemonHealthBar;

    /**
     * forth pokemon in bag
     */
    private ImageView fourthPokemonInBag;
    private TextView fourthPokemonHealthInfo;
    private ProgressBar fourthPokemonHealthBar;

    /**
     * fifth pokemon in bag
     */
    private ImageView fifthPokemonInBag;
    private TextView fifthPokemonHealthInfo;
    private ProgressBar fifthPokemonHealthBar;

    /**
     * sixth pokemon in bag
     */
    private ImageView sixthPokemonInBag;
    private TextView sixthPokemonHealthInfo;
    private ProgressBar sixthPokemonHealthBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // progress for fight, 5 progress in one round
        // ================================================================
        Intent main_intent = getIntent();
        String username = main_intent.getStringExtra("username");
        final UserManager userManager = UserManager.getUserManager();
        User user = userManager.getUser(username);
        if (user == null) {
            user = userManager.getUser("12312312");
        }
        assert user != null;
        player = user.getPlayer();
        assert player != null;
        pokemonList = player.getPokemonList();
        assert pokemonList != null;
        currentPokemon = pokemonList.get(0);
        assert currentPokemon != null;

        String NPCname = main_intent.getStringExtra("FighterName");
        NPC npc = player.getNpcManager().getNPC(NPCname);
        if (npc == null) {
            npc = new FighterNPC("poor student");
        }
        opponent = (FighterNPC) npc;
        fightManager = new FightManager(player, (FighterNPC) npc);
        currentRivalPokemon = npc.getPokemonList().get(0);

        initializeLayOuts();
        updateForPokemonExchange();
        updateHpBar();
        informationSection.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startRound();
                    }
                });

        // implement menu buttons onClickListener
        fight.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (currentPokemon.isAlive()) {
                            menuSection.setVisibility(View.GONE);
                            battleSection.setVisibility(View.GONE);
                            fightBox.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(
                                    FightActivity.this, "You can't choose a fainted pokemon.", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });

        // implement skill buttons onClickListener
        final View.OnClickListener skillClick =
                new View.OnClickListener() {
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
        newPokemon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseNewPokemon();
                        //                                              menuSection.setVisibility(View.GONE);
                        //                                              battleSection.setVisibility(View.GONE);
                        //                                              fightBox.setVisibility(View.GONE);
                        //
                        // informationSection.setVisibility(View.GONE);
                        //
                        // choosePokemon.setVisibility(View.VISIBLE);
                    }
                });
        // implement run buttons onClickListener
        run.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        endFight();
                    }
                });
        // todo: implement bag buttons onClickListener
        bag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chooseNewPokemon();
                        menuSection.setVisibility(View.GONE);
                        battleSection.setVisibility(View.GONE);
                        fightBox.setVisibility(View.GONE);
                    }
                });
        firstPokemonInBag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pokemon pokemon = getPokemonFromPlayerPokemonList(0);
                        changeCurrentPokemon(pokemon);
                    }
                });
        secondPokemonInBag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pokemon pokemon = getPokemonFromPlayerPokemonList(1);
                        changeCurrentPokemon(pokemon);
                    }
                });
        thirdPokemonInBag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pokemon pokemon = getPokemonFromPlayerPokemonList(2);
                        changeCurrentPokemon(pokemon);
                    }
                });
        fourthPokemonInBag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pokemon pokemon = getPokemonFromPlayerPokemonList(3);
                        changeCurrentPokemon(pokemon);
                    }
                });
        fifthPokemonInBag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pokemon pokemon = getPokemonFromPlayerPokemonList(4);
                        changeCurrentPokemon(pokemon);
                    }
                });
        sixthPokemonInBag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pokemon pokemon = getPokemonFromPlayerPokemonList(5);
                        changeCurrentPokemon(pokemon);
                    }
                });
    }

    /**
     * Get a pokemon from pokemon list
     *
     * @param i index of the pokemon
     * @return a pokemon at index i in pokemon list
     */
    private Pokemon getPokemonFromPlayerPokemonList(int i) {
        Pokemon pokemon;
        try {
            pokemon = player.getPokemonList().get(i);
        } catch (IndexOutOfBoundsException e) {
            pokemon = null;
            e.printStackTrace();
        }
        return pokemon;
    }

    /**
     * Put another pokemon in fight.
     *
     * @param pokemon the selected pokemon put in fight
     */
    private void changeCurrentPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            if (!pokemon.isAlive()) {
                Toast.makeText(
                        FightActivity.this, "You can't choose a fainted pokemon.", Toast.LENGTH_SHORT)
                        .show();
            } else {
                currentPokemon = pokemon;
                updateForPokemonExchange();
                informationSection.setVisibility(View.VISIBLE);
                choosePokemon.setVisibility(View.GONE);
                menuSection.setVisibility(View.VISIBLE);
                battleSection.setVisibility(View.VISIBLE);
                fightBox.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Choose  a new pokemon.
     */
    private void chooseNewPokemon() {
        updateForChoosePokemon();
        fightManager.reset();
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
        // update pokemon views
        fightManager.setPlayerPokemon(currentPokemon);
        currentRivalPokemon = fightManager.getRivalPokemon();
        Drawable myPokemonDrawable = getResources().getDrawable(currentPokemon.getProfileID());
        Drawable rivalPokemonDrawable = getResources().getDrawable(currentRivalPokemon.getProfileID());
        myPokemon.setImageDrawable(myPokemonDrawable);
        rivalPokemon.setImageDrawable(rivalPokemonDrawable);
        updateSkillButton();
        updateHpBar();
    }

    /**
     * Update health point Bar.
     */
    private void updateHpBar() {
        myHealth.setMax(currentPokemon.getMaximumHp());
        rivalHealth.setMax(currentRivalPokemon.getMaximumHp());
        myHealth.setProgress(currentPokemon.getHp());
        myHealthInfo.setText(currentPokemon.getHp() + "/" + currentPokemon.getMaximumHp());
        rivalHealth.setProgress(currentRivalPokemon.getHp());
        rivalHealthInfo.setText(currentRivalPokemon.getHp() + "/" + currentRivalPokemon.getMaximumHp());
    }

    /**
     * Reset all pokemon of NPC and return to the main activity
     */
    public void endFight() {
        for (Pokemon pokemon : opponent.getPokemonList()) {
            pokemon.setHp(pokemon.getMaximumHp());
        }
        onBackPressed();
    }

    /**
     * Update all skill buttons according to the skills current pokemon has.
     */
    private void updateSkillButton() {
        try {
            skill_1.setText(currentPokemon.getSkills()[0].getName());
            skill_2.setText(currentPokemon.getSkills()[1].getName());
            skill_3.setText(currentPokemon.getSkills()[2].getName());
            skill_4.setText(currentPokemon.getSkills()[3].getName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    /**
     * Update all pokemon in pokemon list.
     */
    private void updateForChoosePokemon() {
        choosePokemon.setVisibility(View.VISIBLE);
        informationSection.setVisibility(View.GONE);
        ArrayList<Pokemon> list = player.getPokemonList();
        for (int i = 0; i < 6; i++) {
            Pokemon pokemon;
            try {
                pokemon = list.get(i);
            } catch (Exception e) {
                pokemon = null;
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            switch (i) {
                case 0:
                    updateSinglePokemon(
                            pokemon, firstPokemonInBag, firstPokemonHealthBar, firstPokemonHealthInfo);
                    break;
                case 1:
                    updateSinglePokemon(
                            pokemon, secondPokemonInBag, secondPokemonHealthBar, secondPokemonHealthInfo);
                    break;
                case 2:
                    updateSinglePokemon(
                            pokemon, thirdPokemonInBag, thirdPokemonHealthBar, thirdPokemonHealthInfo);
                    break;
                case 3:
                    updateSinglePokemon(
                            pokemon, fourthPokemonInBag, fourthPokemonHealthBar, fourthPokemonHealthInfo);
                    break;
                case 4:
                    updateSinglePokemon(
                            pokemon, fifthPokemonInBag, fifthPokemonHealthBar, fifthPokemonHealthInfo);
                    break;
                case 5:
                    updateSinglePokemon(
                            pokemon, sixthPokemonInBag, sixthPokemonHealthBar, sixthPokemonHealthInfo);
                    break;
            }
        }
    }

    /**
     * Update ImageView, ProgressBar, TextView of a pokemon.
     *
     * @param pokemon           the pokemon being updated
     * @param pokemonInBag      ImageView of pokemon
     * @param pokemonHealthBar  ProgressBar of pokemon
     * @param pokemonHealthInfo TextView of pokemon
     */
    @SuppressLint("SetTextI18n")
    private void updateSinglePokemon(
            Pokemon pokemon,
            ImageView pokemonInBag,
            ProgressBar pokemonHealthBar,
            TextView pokemonHealthInfo) {
        if (pokemon == null) {
            pokemonInBag.setImageDrawable(null);
            pokemonHealthBar.setMax(0);
            pokemonHealthBar.setProgress(0);
            pokemonHealthInfo.setText("");
        } else {
            pokemonInBag.setBackgroundColor(0x00000000);
            pokemonInBag.setImageDrawable(getResources().getDrawable(pokemon.getProfileID()));
            pokemonHealthBar.setMax(pokemon.getMaximumHp());
            pokemonHealthBar.setProgress(pokemon.getHp());
            pokemonHealthInfo.setText(pokemon.getHp() + "/" + pokemon.getMaximumHp());
            fightManager.setPlayerPokemon(pokemon);
        }
        if (pokemon == currentPokemon) {
            pokemonInBag.setBackgroundColor(Color.parseColor("#2504E204"));
        }
    }

    /**
     * Initialize layouts.
     */
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
        // choosePokemon section
        choosePokemon = findViewById(R.id.choosePokemon);
        // first
        firstPokemonInBag = findViewById(R.id.firstPokemonInBag);
        firstPokemonHealthInfo = findViewById(R.id.firstPokemonHealthInfo);
        firstPokemonHealthBar = findViewById(R.id.firstPokemonHealthBar);
        // second
        secondPokemonInBag = findViewById(R.id.secondPokemonInBag);
        secondPokemonHealthInfo = findViewById(R.id.secondPokemonHealthInfo);
        secondPokemonHealthBar = findViewById(R.id.secondPokemonHealthBar);
        // third
        thirdPokemonInBag = findViewById(R.id.thirdPokemonInBag);
        thirdPokemonHealthInfo = findViewById(R.id.thirdPokemonHealthInfo);
        thirdPokemonHealthBar = findViewById(R.id.thirdPokemonHealthBar);
        // fourth
        fourthPokemonInBag = findViewById(R.id.fourthPokemonInBag);
        fourthPokemonHealthInfo = findViewById(R.id.fourthPokemonHealthInfo);
        fourthPokemonHealthBar = findViewById(R.id.fourthPokemonHealthBar);
        // fifth
        fifthPokemonInBag = findViewById(R.id.fifthPokemonInBag);
        fifthPokemonHealthInfo = findViewById(R.id.fifthPokemonHealthInfo);
        fifthPokemonHealthBar = findViewById(R.id.fifthPokemonHealthBar);
        // sixth
        sixthPokemonInBag = findViewById(R.id.sixthPokemonInBag);
        sixthPokemonHealthInfo = findViewById(R.id.sixthPokemonHealthInfo);
        sixthPokemonHealthBar = findViewById(R.id.sixthPokemonHealthBar);
    }
}
