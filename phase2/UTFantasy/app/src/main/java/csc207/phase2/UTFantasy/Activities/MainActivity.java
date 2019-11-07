package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Map.MapView;
import csc207.phase2.UTFantasy.MapManager;
import csc207.phase2.UTFantasy.NPCManager;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.UserManager;

public class MainActivity extends AppCompatActivity {

    /**
     * the intent of MainActivity
     */
    Intent intent;

    /**
     * the player
     */
    Player player;

    /**
     * The unique UserManager.
     */
    UserManager userManager = UserManager.getUserManager();

    /**
     * The name of the current User.
     */
    String username;

    /**
     * the Map View of this main activity
     */
    MapView mapView;

    MapManager mapManager;

    /**
     * the npc that this player might interact with, default to be null
     */
    NPC npc;

    /**
     * the reference to the shared preference file
     */
    private SharedPreferences sharedPreferences;
    /**
     * the file that stores the shared preference
     */
    private String sharedPreFile = "sharePreFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        final LinearLayout mapViewHolder = findViewById(R.id.mapViewHolder);
        final LinearLayout interactWindow = findViewById(R.id.interaction_window);

        // find all the buttons
        Button leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);
        Button upButton = findViewById(R.id.upButton);
        Button downButton = findViewById(R.id.downButton);
        final Button A_Button = findViewById(R.id.A_Button);
        Button B_Button = findViewById(R.id.B_Button);
        final Button menuButton = findViewById(R.id.menuButton);
        final Button menuBagButton = findViewById(R.id.menu_bag);
        final Button menu_system = findViewById(R.id.menu_system);
        final Button menuProfileButton = findViewById(R.id.menu_profile);
        final Button menuBackButton = findViewById(R.id.menu_back);
        final Button interactFight = findViewById(R.id.interact_fight);
        final Button interactPurchase = findViewById(R.id.interact_purchase);
        final Button interactHeal = findViewById(R.id.interact_heal);
        final Button interactBack = findViewById(R.id.interact_back);

        final LinearLayout mainButtonHolder = findViewById(R.id.main_menu_holder);

        // set onClickListener for the buttons
        final View.OnClickListener moveClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapManager.movementFinished()) {
                    mapManager.setProgress(1);
                    switch (view.getId()) {
                        case R.id.leftButton:
                            mapManager.setDirection("left");
                            break;
                        case R.id.rightButton:
                            mapManager.setDirection("right");
                            break;
                        case R.id.upButton:
                            mapManager.setDirection("up");
                            break;
                        case R.id.downButton:
                            mapManager.setDirection("down");
                            break;
                    }
                }
            }
        };
        leftButton.setOnClickListener(moveClick);
        rightButton.setOnClickListener(moveClick);
        upButton.setOnClickListener(moveClick);
        downButton.setOnClickListener(moveClick);

        final View.OnTouchListener moveTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mapManager.movementFinished()) {
                            mapManager.setMoving(true);
                            switch (view.getId()) {
                                case R.id.leftButton:
                                    mapManager.setDirection("left");
                                    break;
                                case R.id.rightButton:
                                    mapManager.setDirection("right");
                                    break;
                                case R.id.upButton:
                                    mapManager.setDirection("up");
                                    break;
                                case R.id.downButton:
                                    mapManager.setDirection("down");
                                    break;
                            }
                            break;
                        }
                    case MotionEvent.ACTION_UP:
                        mapManager.setMoving(false);
                        break;
                }
                return true;
            }
        };
        leftButton.setOnTouchListener(moveTouchListener);
        rightButton.setOnTouchListener(moveTouchListener);
        upButton.setOnTouchListener(moveTouchListener);
        downButton.setOnTouchListener(moveTouchListener);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainButtonHolder.setVisibility(View.VISIBLE);
            }
        });
        menuBagButton.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {
                                                 Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                                                 intent.putExtra("username", username);
                                                 startActivity(intent);
                                             }
                                         }
        );
        menuBackButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  mainButtonHolder.setVisibility(View.GONE);
                                              }
                                          }
        );
        menuProfileButton.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     Intent profileIntent = new Intent(MainActivity.this, PlayerInfoActivity.class);
                                                     profileIntent.putExtra("username", username);
                                                     startActivity(profileIntent);
                                                 }
                                             }
        );


        menu_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SystemActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        A_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String npcName = mapManager.checkForward(player.getDirection());
                if (npcName != null) {
                    NPCManager npcManager = player.getNpcManager();
                    npc = npcManager.getNPC(npcName);
                    if (npc != null) {
                        interactWindow.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        interactFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (npc.canFight() && player.isFightAble()) {
                    Intent intent = new Intent(MainActivity.this, FightActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("FighterName", npc.getName());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "You can't fight", Toast.LENGTH_LONG).show();
                }
            }
        });

        interactPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (npc.canTrade()) {
                    Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("SellerName", npc.getName());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "You can't trade with this npc", Toast.LENGTH_LONG).show();
                }
            }
        });

        interactHeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (npc.canHeal()) {
                    for (Pokemon pokemon : player.getPokemonList()) {
                        pokemon.setHp(pokemon.getMaximumHp());
                    }
                    Toast.makeText(MainActivity.this, "All Pokemon are healed.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "This npc can't heal you", Toast.LENGTH_LONG).show();
                }
            }
        });

        interactBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interactWindow.setVisibility(View.GONE);
                npc = null;
            }
        });

        intent =

                getIntent();

        username = intent.getStringExtra("username");
        sharedPreferences =

                getSharedPreferences(sharedPreFile, MODE_PRIVATE);

        // if this sharedPreference does not exist, then user.getString("username") should return
        // non null string
        // if the sharedPreference already exists, then intent.getStringExtra return non null string
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();
        player = userManager.getUser(username).

                getPlayer();

        mapView = new

                MapView(this, player);
        mapViewHolder.addView(mapView);
        mapManager = mapView.getMapManager();
    }

    /**
     * resume this activity
     * called when this activity is resumed from being paused
     */
    @Override
    protected void onResume() {
        super.onResume();
        username = sharedPreferences.getString("username", null);
        try {
            player = userManager.getUser(username).getPlayer();
        } catch (Exception e) {
            System.out.println("A bug occurred, non-valid username");
        }
        if (!mapView.getThread().getRunning()) {
            mapView.setThread();
            mapView.getThread().setRunning(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.getThread().setRunning(false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();
        userManager.saveUserManager(MainActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            mapView.getThread().setRunning(false);
        }
    }
}
