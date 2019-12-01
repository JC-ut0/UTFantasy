package csc207.phase2.UTFantasy.Battle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
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

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import csc207.phase2.UTFantasy.Activities.ProductSelectActivity;
import csc207.phase2.UTFantasy.Activities.evolutionUI.EvolutionActivity;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.R;

public class BattleActivity extends AppCompatActivity implements BattleActivityModel {
    private String username;
    private Player player;
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
     * Pokemon View
     */
    ImageView myPokemon;

    ImageView rivalPokemon;
    ImageView catchAnimation;
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
    LinearLayout choosePokemon;
    private BattleInteractor interactor;
    private BattleController controller;
    /**
     * instance of skill buttons
     */
    private Button skill_1;

    private Button skill_2;
    private Button skill_3;
    private Button skill_4;
    /**
     * first pokemon in bag
     */
    private LinearLayout firstPokemonLayout;

    private ImageView firstPokemonInBag;
    private TextView firstPokemonHealthInfo;
    private ProgressBar firstPokemonHealthBar;

    /**
     * second pokemon in bag
     */
    private LinearLayout secondPokemonLayout;

    private ImageView secondPokemonInBag;
    private TextView secondPokemonHealthInfo;
    private ProgressBar secondPokemonHealthBar;

    /**
     * third pokemon in bag
     */
    private LinearLayout thirdPokemonLayout;

    private ImageView thirdPokemonInBag;
    private TextView thirdPokemonHealthInfo;
    private ProgressBar thirdPokemonHealthBar;

    /**
     * forth pokemon in bag
     */
    private LinearLayout fourthPokemonLayout;

    private ImageView fourthPokemonInBag;
    private TextView fourthPokemonHealthInfo;
    private ProgressBar fourthPokemonHealthBar;

    /**
     * fifth pokemon in bag
     */
    private LinearLayout fifthPokemonLayout;

    private ImageView fifthPokemonInBag;
    private TextView fifthPokemonHealthInfo;
    private ProgressBar fifthPokemonHealthBar;

    /**
     * sixth pokemon in bag
     */
    private LinearLayout sixthPokemonLayout;

    private ImageView sixthPokemonInBag;
    private TextView sixthPokemonHealthInfo;
    private ProgressBar sixthPokemonHealthBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserIO userIO = UserIO.getSingletonUserIo();
        final Intent intent = getIntent();
        username = intent.getStringExtra("username");
        player = userIO.getUserData().getUser(username).getPlayer();

        String NPCname = intent.getStringExtra("npcName");
        NPC npc = player.getPlayerMap().getNpcRepository().getNPC(NPCname);
        if (npc == null) {
            onBackPressed();
//      npc = new NPC("poor student", Duty.FIGHT);
//      Pokemon squirtle = new Squirtle();
//      squirtle.setLevel(5);
//      npc.addPokemon(squirtle);
//      npc.addPokemon(new Psyduck());
        }
        NPC rival = npc;
        initializeLayOuts();
        final BattlePresenter presenter = new BattlePresenter(this);
        interactor = new BattleInteractor(new BattleData(player, rival), presenter);
        controller = new BattleController(interactor, presenter);

        informationSection.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        controller.updateText();
                    }
                });

        // implement fight button onClickListener
        fight.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        menuSection.setVisibility(View.GONE);
                        battleSection.setVisibility(View.GONE);
                        fightBox.setVisibility(View.VISIBLE);
                    }
                });

        // implement bag button onclickListener
        bag.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        menuSection.setVisibility(View.GONE);
                        battleSection.setVisibility(View.GONE);
                        Intent intent = new Intent(BattleActivity.this, ProductSelectActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                        controller.useItem();
                        showText("...");
                    }
                });

        newPokemon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        menuSection.setVisibility(View.GONE);
                        battleSection.setVisibility(View.GONE);
                        fightBox.setVisibility(View.GONE);
                        informationSection.setVisibility(View.GONE);
                        choosePokemon.setVisibility(View.VISIBLE);
                        controller.openPokemonChoose();
                    }
                });
        // implement run buttons onClickListener
        run.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        endFight();
                        interactor.getBattleData().clearOberser();
                    }
                });

        // implement skill buttons onClickListener
        final View.OnClickListener skillClick =
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int i = 0;
                        switch (view.getId()) {
                            case R.id.skill_1:
                                i = 0;
                                break;
                            case R.id.skill_2:
                                i = 1;
                                break;
                            case R.id.skill_3:
                                i = 2;
                                break;
                            case R.id.skill_4:
                                i = 3;
                                break;
                        }
                        fightBox.setVisibility(View.GONE);
                        battleSection.setVisibility(View.VISIBLE);
                        controller.skillClick(i);
                    }
                };
        skill_1.setOnClickListener(skillClick);
        skill_2.setOnClickListener(skillClick);
        skill_3.setOnClickListener(skillClick);
        skill_4.setOnClickListener(skillClick);

        View.OnClickListener pokemonChooseListener =
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int i = 0;
                        switch (view.getId()) {
                            case R.id.firstPokemonInBag:
                                i = 0;
                                break;
                            case R.id.secondPokemonInBag:
                                i = 1;
                                break;
                            case R.id.thirdPokemonInBag:
                                i = 2;
                                break;
                            case R.id.fourthPokemonInBag:
                                i = 3;
                                break;
                            case R.id.fifthPokemonInBag:
                                i = 4;
                                break;
                            case R.id.sixthPokemonInBag:
                                i = 5;
                                break;
                        }
                        controller.choosePokemon(i);
                    }
                };

        firstPokemonInBag.setOnClickListener(pokemonChooseListener);
        secondPokemonInBag.setOnClickListener(pokemonChooseListener);
        thirdPokemonInBag.setOnClickListener(pokemonChooseListener);
        fourthPokemonInBag.setOnClickListener(pokemonChooseListener);
        fifthPokemonInBag.setOnClickListener(pokemonChooseListener);
        sixthPokemonInBag.setOnClickListener(pokemonChooseListener);
    }

    /**
     * Update ImageView, ProgressBar, TextView of a pokemon.
     *
     * @param pokeNum     the number of position of this pokemon in the player's bag
     * @param isAttending if this pokemon is the current pokemon during the battle
     * @param pokeId      the profile icon of this pokemon
     * @param hp          the hp of this pokemon
     * @param maxHp       the maximum hp of this pokemon
     */
    @Override
    public void showSinglePokemonForChoose(
            int pokeNum, boolean isAttending, int pokeId, int hp, int maxHp) {
        ImageView pokemonInBag = null;
        ProgressBar pokemonHealthBar = null;
        TextView pokemonHealthInfo = null;
        switch (pokeNum) {
            case 0:
                firstPokemonLayout.setVisibility(View.VISIBLE);
                pokemonInBag = firstPokemonInBag;
                pokemonHealthBar = firstPokemonHealthBar;
                pokemonHealthInfo = firstPokemonHealthInfo;
                break;
            case 1:
                secondPokemonLayout.setVisibility(View.VISIBLE);
                pokemonInBag = secondPokemonInBag;
                pokemonHealthBar = secondPokemonHealthBar;
                pokemonHealthInfo = secondPokemonHealthInfo;
                break;
            case 2:
                thirdPokemonLayout.setVisibility(View.VISIBLE);
                pokemonInBag = thirdPokemonInBag;
                pokemonHealthBar = thirdPokemonHealthBar;
                pokemonHealthInfo = thirdPokemonHealthInfo;
                break;
            case 3:
                fourthPokemonLayout.setVisibility(View.VISIBLE);
                pokemonInBag = fourthPokemonInBag;
                pokemonHealthBar = fourthPokemonHealthBar;
                pokemonHealthInfo = fourthPokemonHealthInfo;
                break;
            case 4:
                fifthPokemonLayout.setVisibility(View.VISIBLE);
                pokemonInBag = fifthPokemonInBag;
                pokemonHealthBar = fifthPokemonHealthBar;
                pokemonHealthInfo = fifthPokemonHealthInfo;
                break;
            case 5:
                sixthPokemonLayout.setVisibility(View.VISIBLE);
                pokemonInBag = sixthPokemonInBag;
                pokemonHealthBar = sixthPokemonHealthBar;
                pokemonHealthInfo = sixthPokemonHealthInfo;
                break;
        }
        pokemonInBag.setBackgroundColor(0x00000000);
        pokemonInBag.setImageDrawable(getResources().getDrawable(pokeId, null));
        pokemonHealthBar.setVisibility(View.VISIBLE);
        pokemonHealthBar.setMax(maxHp);
        pokemonHealthBar.setProgress(hp);
        pokemonHealthInfo.setText(hp + "/" + maxHp);
        if (isAttending) {
            pokemonInBag.setBackgroundColor(Color.parseColor("#2504E204"));
        }
    }

    @Override
    public void showText(String text) {
        battleSection.setVisibility(View.VISIBLE);
        battleInfo.setText(text);
    }

    @Override
    public void openMenu() {
        menuSection.setVisibility(View.VISIBLE);
        battleInfo.setText("what to do now");
        battleSection.setVisibility(View.VISIBLE);
        fightBox.setVisibility(View.GONE);
    }

    @Override
    public void closePokemonChoose() {
        battleSection.setVisibility(View.VISIBLE);
        informationSection.setVisibility(View.VISIBLE);
        choosePokemon.setVisibility(View.GONE);
    }

    @Override
    public void closeSkillMenu() {
        fightBox.setVisibility(View.GONE);
        battleSection.setVisibility(View.VISIBLE);
    }

    /**
     * heal the npc all pokemon and return to the main activity
     */
    @Override
    public void endFight() {
        for (Pokemon pokemon : interactor.getBattleData().getRival().getPokemonList()) {
            pokemon.setHp(pokemon.getMaximumHp());
        }
        onBackPressed();
    }

    @Override
    public void updatePlayerPoke(int pokeId) {
        myPokemon.setImageDrawable(getResources().getDrawable(pokeId, null));
    }

    @Override
    public void updateRivalPoke(int pokeId) {
        rivalPokemon.setImageDrawable(getResources().getDrawable(pokeId, null));
    }

    @Override
    public void updatePlayerPokeHp(int hp, int maxHp) {
        myHealth.setProgress(hp);
        myHealth.setMax(maxHp);
        String info = hp + "/" + maxHp;
        myHealthInfo.setText(info);
    }

    @Override
    public void updateRivalPokeHp(int hp, int maxHp) {
        rivalHealth.setProgress(hp);
        rivalHealth.setMax(maxHp);
        String info = hp + "/" + maxHp;
        rivalHealthInfo.setText(info);
    }

    @Override
    public void warnPokeNotAlive() {
        Toast.makeText(BattleActivity.this, "You can't choose a fainted pokemon.", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void setSkill1(String skill1) {
        skill_1.setText(skill1);
    }

    @Override
    public void setSkill2(String skill2) {
        skill_2.setText(skill2);
    }

    @Override
    public void setSkill3(String skill3) {
        skill_3.setText(skill3);
    }

    @Override
    public void setSkill4(String skill4) {
        skill_4.setText(skill4);
    }

    @Override
    public void showCatch() {
        rivalPokemon.setVisibility(View.GONE);
        catchAnimation.setVisibility(View.VISIBLE);
        ((AnimationDrawable) catchAnimation.getBackground()).start();
    }

    @Override
    public void hideCatch() {
        ((AnimationDrawable) catchAnimation.getBackground()).stop();
        catchAnimation.setVisibility(View.GONE);
        rivalPokemon.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCaught() {
        rivalPokemon.setVisibility(View.GONE);
        catchAnimation.setBackground(getResources().getDrawable(R.drawable.pokeballcatched, null));
        catchAnimation.setVisibility(View.VISIBLE);
    }

    @Override
    public void evolve(int pokemonIndex) {
        if (0 <= pokemonIndex && pokemonIndex < player.getPokemonList().size()) {
            Intent intent = new Intent(BattleActivity.this, EvolutionActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("pokemonIndex", pokemonIndex);
            startActivity(intent);
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
        skillInfo = findViewById(R.id.skill_info);
        // Pokemon View
        myPokemon = findViewById(R.id.myPokemon);
        rivalPokemon = findViewById(R.id.rivalPokemon);

        catchAnimation = findViewById(R.id.catchAnimation);
        // healthBar
        myHealth = findViewById(R.id.myHealthBar);
        rivalHealth = findViewById(R.id.rivalHealthBar);
        // healthBar Text
        myHealthInfo = findViewById(R.id.myHealthInfo);
        rivalHealthInfo = findViewById(R.id.rivalHealthInfo);
        // choosePokemon section
        choosePokemon = findViewById(R.id.choosePokemon);
        // first
        firstPokemonLayout = findViewById(R.id.firstPokemonLayout);
        firstPokemonInBag = findViewById(R.id.firstPokemonInBag);
        firstPokemonHealthInfo = findViewById(R.id.firstPokemonHealthInfo);
        firstPokemonHealthBar = findViewById(R.id.firstPokemonHealthBar);
        // second
        secondPokemonLayout = findViewById(R.id.secondPokemonLayout);
        secondPokemonInBag = findViewById(R.id.secondPokemonInBag);
        secondPokemonHealthInfo = findViewById(R.id.secondPokemonHealthInfo);
        secondPokemonHealthBar = findViewById(R.id.secondPokemonHealthBar);
        // third
        thirdPokemonLayout = findViewById(R.id.thirdPokemonLayout);
        thirdPokemonInBag = findViewById(R.id.thirdPokemonInBag);
        thirdPokemonHealthInfo = findViewById(R.id.thirdPokemonHealthInfo);
        thirdPokemonHealthBar = findViewById(R.id.thirdPokemonHealthBar);
        // fourth
        fourthPokemonLayout = findViewById(R.id.fourthPokemonLayout);
        fourthPokemonInBag = findViewById(R.id.fourthPokemonInBag);
        fourthPokemonHealthInfo = findViewById(R.id.fourthPokemonHealthInfo);
        fourthPokemonHealthBar = findViewById(R.id.fourthPokemonHealthBar);
        // fifth
        fifthPokemonLayout = findViewById(R.id.fifthPokemonLayout);
        fifthPokemonInBag = findViewById(R.id.fifthPokemonInBag);
        fifthPokemonHealthInfo = findViewById(R.id.fifthPokemonHealthInfo);
        fifthPokemonHealthBar = findViewById(R.id.fifthPokemonHealthBar);
        // sixth
        sixthPokemonLayout = findViewById(R.id.sixthPokemonLayout);
        sixthPokemonInBag = findViewById(R.id.sixthPokemonInBag);
        sixthPokemonHealthInfo = findViewById(R.id.sixthPokemonHealthInfo);
        sixthPokemonHealthBar = findViewById(R.id.sixthPokemonHealthBar);
    }
}
