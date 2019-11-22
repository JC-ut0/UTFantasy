package csc207.phase2.UTFantasy.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Activities.FightActivity;
import csc207.phase2.UTFantasy.Activities.LoginActivity;
import csc207.phase2.UTFantasy.Activities.MenuActivity;
import csc207.phase2.UTFantasy.Activities.PlayerInfoActivity;
import csc207.phase2.UTFantasy.Activities.ShopActivity;
import csc207.phase2.UTFantasy.Activities.SystemActivity;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.UserManager;

public class MainActivity extends AppCompatActivity implements MainActivityModel {
  private MapView mapView;
  private MapController mapController;
  private MapInteractor mapInteractor;
  private MapDrawer mapDrawer;
  private MainThread mainThread;
  /** the intent of MainActivity */
  Intent intent;

  /** the player */
  Player player;

  /** The unique UserManager. */
  UserManager userManager = UserManager.getUserManager();

  /** The name of the current User. */
  String username;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow()
        .setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_main);
    final LinearLayout mapViewHolder = findViewById(R.id.mapViewHolder);

    // find all the buttons
    Button leftButton = findViewById(R.id.leftButton);
    Button rightButton = findViewById(R.id.rightButton);
    Button upButton = findViewById(R.id.upButton);
    Button downButton = findViewById(R.id.downButton);
    final Button A_Button = findViewById(R.id.A_Button);
    final Button menuButton = findViewById(R.id.menuButton);
    final Button menuBagButton = findViewById(R.id.menu_bag);
    final Button menu_system = findViewById(R.id.menu_system);
    final Button menuProfileButton = findViewById(R.id.menu_profile);
    final Button menuBackButton = findViewById(R.id.menu_back);
    final LinearLayout mainButtonHolder = findViewById(R.id.main_menu_holder);

    // set onClickListener for the buttons
    final View.OnClickListener moveClick =
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            switch (view.getId()) {
              case R.id.leftButton:
                mapController.moveClick("left");
                break;
              case R.id.rightButton:
                mapController.moveClick("right");
                break;
              case R.id.upButton:
                mapController.moveClick("up");
                break;
              case R.id.downButton:
                mapController.moveClick("down");
                break;
            }
          }
        };
    leftButton.setOnClickListener(moveClick);
    rightButton.setOnClickListener(moveClick);
    upButton.setOnClickListener(moveClick);
    downButton.setOnClickListener(moveClick);

    final View.OnTouchListener moveTouchListener =
        new View.OnTouchListener() {
          @Override
          public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
              case MotionEvent.ACTION_DOWN:
                switch (view.getId()) {
                  case R.id.leftButton:
                    mapController.moveTouchDownAction("left");
                    break;
                  case R.id.rightButton:
                    mapController.moveTouchDownAction("right");
                    break;
                  case R.id.upButton:
                    mapController.moveTouchDownAction("up");
                    break;
                  case R.id.downButton:
                    mapController.moveTouchDownAction("down");
                    break;
                }
                break;
              case MotionEvent.ACTION_UP:
                mapController.moveTouchUpAction();
                break;
            }
            return true;
          }
        };
    leftButton.setOnTouchListener(moveTouchListener);
    rightButton.setOnTouchListener(moveTouchListener);
    upButton.setOnTouchListener(moveTouchListener);
    downButton.setOnTouchListener(moveTouchListener);

    menuButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainButtonHolder.setVisibility(View.VISIBLE);
          }
        });
    menuBagButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
          }
        });

    menuProfileButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent profileIntent = new Intent(MainActivity.this, PlayerInfoActivity.class);
            profileIntent.putExtra("username", username);
            startActivity(profileIntent);
          }
        });

    menu_system.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SystemActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
          }
        });

    menuBackButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mainButtonHolder.setVisibility(View.GONE);
          }
        });

    A_Button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mapController.buttonAClick();
          }
        });

    // ============================================================================================

    intent = getIntent();
    username = intent.getStringExtra("username");
    player = userManager.getUser(username).getPlayer();
    mapController = new MapController(player, this);
    mapView = new MapView(this);
    mapInteractor = mapController.getMapInteractor();
    mapDrawer = new MapPresenter(mapView);
    mainThread = new MainThread(mapDrawer, mapInteractor);
    mapView.setThread(mainThread);
    mapViewHolder.addView(mapView);
  }

  /** resume this activity called when this activity is resumed from being paused */
  @Override
  protected void onResume() {
    super.onResume();
    try {
      player = userManager.getUser(username).getPlayer();
    } catch (Exception e) {
      System.out.println("A bug occurred, non-valid username");
    }
    if (!mapView.getThread().getRunning()) {
      mapView.setThread(new MainThread(mapDrawer, mapInteractor));
      mapView.getThread().setRunning(true);
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapView.getThread().setRunning(false);
    userManager.saveUserManager(MainActivity.this);
  }

  @Override
  public void fight() {
    Intent intent = new Intent(MainActivity.this, FightActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  @Override
  public void trade() {
    Intent intent = new Intent(MainActivity.this, ShopActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  @Override
  public void popText(String text) {
    Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
  }
}
