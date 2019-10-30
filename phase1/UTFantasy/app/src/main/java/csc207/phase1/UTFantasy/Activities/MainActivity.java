package csc207.phase1.UTFantasy.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.MainThread;
import csc207.phase1.UTFantasy.Map.MapView;
import csc207.phase1.UTFantasy.MapManager;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.UserManager;

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
        LinearLayout mapViewHolder = findViewById(R.id.mapViewHolder);

        // find all the buttons
        Button leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);
        Button upButton = findViewById(R.id.upButton);
        Button downButton = findViewById(R.id.downButton);
        Button A_Button = findViewById(R.id.A_Button);
        Button B_Button = findViewById(R.id.B_Button);
        Button menuButton = findViewById(R.id.menuButton);
        Button menuBagButton = findViewById(R.id.menu_bag);
        Button menu_system = findViewById(R.id.menu_system);
        Button menuProfileButton = findViewById(R.id.menu_profile);
        Button menuBackButton = findViewById(R.id.menu_back);

        final LinearLayout mainButtonHolder = findViewById(R.id.main_menu_holder);

        // set onClickListener for the buttons
        leftButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              player.move("left", mapManager);
                                          }
                                      }
        );
        rightButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               player.move("right", mapManager);
                                           }
                                       }
        );
        upButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            player.move("up", mapManager);
                                        }
                                    }
        );
        downButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              player.move("down", mapManager);
                                          }
                                      }
        );
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

        intent = getIntent();
        username = intent.getStringExtra("username");
        sharedPreferences = getSharedPreferences(sharedPreFile, MODE_PRIVATE);
        // if this sharedPreference does not exist, then user.getString("username") should return
        // non null string
        // if the sharedPreference already exists, then intent.getStringExtra return non null string
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();
        player = userManager.getUser(username).getPlayer();
        mapView = new MapView(this, player);
        intent.putExtra("mapView", mapView);
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
            System.out.println("A bug occured, non-valid username");
        }

        if (!mapView.getThread().getRunning()) {
            mapView.setThread(new MainThread(mapView.getHolder(), mapView));
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            mapView.getThread().setRunning(false);
            userManager.saveUserManager(MainActivity.this);
        }
    }
}
