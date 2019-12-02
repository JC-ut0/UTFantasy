package csc207.phase2.UTFantasy.Activities.mapUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.Activities.PlayerInfoActivity;
import csc207.phase2.UTFantasy.Activities.ShopActivityMVP.ShopActivity;
import csc207.phase2.UTFantasy.Activities.SystemActivity;
import csc207.phase2.UTFantasy.Activities.evolutionUI.EvolutionActivity;
import csc207.phase2.UTFantasy.Activities.menu.MenuActivity;
import csc207.phase2.UTFantasy.Battle.BattleActivity;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.WildPokemonObserver;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.mapUseCase.MainThread;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;
import csc207.phase2.UTFantasy.mapUseCase.MapInteractor;
import csc207.phase2.UTFantasy.mapUseCase.WildPokemonChecker;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {
  private MapView mapView;
  private MapController mapController;
  private MapInteractor mapInteractor;
  private MapDrawer mapDrawer;
  /** the intent of MainActivity */
  private Intent intent;

  /** the player */
  private Player player;

  /** the unique UserIO */
  private UserIO userIO = UserIO.getSingletonUserIo();

  /** The name of the current User. */
  private String username;

  private Button leftButton;
  private Button rightButton;
  private Button upButton;
  private Button downButton;
  private Button menuButton;
  private RelativeLayout dialogueBox;
  private TextView dialogueText;
  private RelativeLayout displayCase;
  private ImageView displayIcon;

  @SuppressLint("ClickableViewAccessibility")
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
    leftButton = findViewById(R.id.leftButton);
    rightButton = findViewById(R.id.rightButton);
    upButton = findViewById(R.id.upButton);
    downButton = findViewById(R.id.downButton);
    Button aButton = findViewById(R.id.A_Button);
    Button bButton = findViewById(R.id.B_Button);
    menuButton = findViewById(R.id.menuButton);
    final Button menuBagButton = findViewById(R.id.menu_bag);
    final Button menu_system = findViewById(R.id.menu_system);
    final Button menuProfileButton = findViewById(R.id.menu_profile);
    final Button menuBackButton = findViewById(R.id.menu_back);
    final LinearLayout mainButtonHolder = findViewById(R.id.main_menu_holder);
    dialogueBox = findViewById(R.id.dialogueBox);
    dialogueText = findViewById(R.id.dialogueText);
    displayCase = findViewById(R.id.displayCase);
    displayIcon = findViewById(R.id.displayIcon);

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

    aButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mapController.buttonAClick();
          }
        });

    bButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            mapController.buttonBClick();
          }
        });

    intent = getIntent();
    username = intent.getStringExtra("username");
    player = userIO.getUserData().getUser(username).getPlayer();
    mapController = new MapController(player);
    mapView = new MapView(this);
    mapInteractor = mapController.getMapInteractor();
    mapDrawer = new MapPresenter(mapView, this);
    mapController.getNpcInteractor().setDrawer(mapDrawer);
    mapController.getEvolutionChecker().setDrawer(mapDrawer);
    MainThread mainThread = new MainThread(mapDrawer, mapInteractor);
    mapView.setThread(mainThread);
    mapViewHolder.addView(mapView);
  }

  /** resume this activity called when this activity is resumed from being paused */
  @Override
  protected void onResume() {
    super.onResume();
    try {
      player = userIO.getUserData().getUser(username).getPlayer();
    } catch (Exception e) {
      System.out.println("A bug occurred, non-valid username");
    }
    if (!mapView.getThread().getRunning()) {
      mapView.setThread(new MainThread(mapDrawer, mapInteractor));
      mapView.getThread().setRunning(true);
    }
    mapController.checkEvolution();
    WildPokemonObserver wildPokemonObserver = new WildPokemonChecker(player, mapDrawer);
    player.addObserver(wildPokemonObserver);
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapView.getThread().setRunning(false);
    mapController.clearObserver();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    userIO.saveUserData(MainActivity.this);
  }

  @Override
  public void fight() {
    Intent intent = new Intent(MainActivity.this, BattleActivity.class);
    intent.putExtra("username", username);
    startActivity(intent);
  }

  @Override
  public void popText(String text) {
    Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
  }

  @Override
  public void openDialogue(String dialogue) {
    dialogueBox.setVisibility(View.VISIBLE);
    dialogueText.setText(dialogue);
  }

  @Override
  public void closeDialogue() {
    dialogueBox.setVisibility(View.GONE);
    displayCase.setVisibility(View.GONE);
  }

  @Override
  public void display(int iconId) {
    displayCase.setVisibility(View.VISIBLE);
    displayIcon.setImageDrawable(getResources().getDrawable(iconId, null));
  }

  @Override
  public void goToBattleActivity(String npcName) {
    intent = new Intent(MainActivity.this, BattleActivity.class);
    intent.putExtra("username", username);
    intent.putExtra("npcName", npcName);
    startActivity(intent);
  }

  @Override
  public void goToShopActivity(String npcName) {
    intent = new Intent(MainActivity.this, ShopActivity.class);
    intent.putExtra("username", username);
    intent.putExtra("npcName", npcName);
    startActivity(intent);
  }

  @Override
  public void goToEvolutionActivity(int pokemonIndex) {
    intent = new Intent(MainActivity.this, EvolutionActivity.class);
    intent.putExtra("username", username);
    intent.putExtra("pokemonIndex", pokemonIndex);
    startActivity(intent);
  }

  @Override
  public void hideButtons() {
    upButton.setVisibility(View.GONE);
    downButton.setVisibility(View.GONE);
    leftButton.setVisibility(View.GONE);
    rightButton.setVisibility(View.GONE);
    menuButton.setVisibility(View.GONE);
  }

  @Override
  public void showButtons() {
    upButton.setVisibility(View.VISIBLE);
    downButton.setVisibility(View.VISIBLE);
    leftButton.setVisibility(View.VISIBLE);
    rightButton.setVisibility(View.VISIBLE);
    menuButton.setVisibility(View.VISIBLE);
  }
}
