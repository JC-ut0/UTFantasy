package csc207.phase1.UTFantasy.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.MapView;
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
    Player p;

    /**
     * The unique UserManager.
     */
    UserManager userManager = UserManager.getUserManager();

    /**
     * The name of the current User.
     */
    String username;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        username = intent.getStringExtra("username");
        p = userManager.getUser(username).getPlayer();

//        MapView mapView = new MapView(this, p);
//        FrameLayout frame = new FrameLayout(this);
//        RelativeLayout buttonHolders = new RelativeLayout(this);
//
//        // create buttons
//        Button leftButton = new Button(this);
//        leftButton.setId(123456);
//
//        Button rightButton = new Button(this);
//        rightButton.setId(123457);
//
//        Button upButton = new Button(this);
//        leftButton.setId(123458);
//
//        Button downButton = new Button(this);
//        rightButton.setId(123459);
//
//        Button menuButton = new Button(this);
//        menuButton.setId(123460);
//
//        Button bagButton = new Button(this);
//        bagButton.setId(123461);
//
//        Button profileButton = new Button(this);
//        profileButton.setId(123462);
//
//        //create button params
//        RelativeLayout.LayoutParams lb = new RelativeLayout.LayoutParams(200, 100);
//        leftButton.setLayoutParams(lb);
//        leftButton.setX(50);
//        leftButton.setY(600);
//
//        RelativeLayout.LayoutParams rb = new RelativeLayout.LayoutParams(200, 100);
//        rightButton.setLayoutParams(rb);
//        rightButton.setX(330);
//        rightButton.setY(600);
//
//        RelativeLayout.LayoutParams ub = new RelativeLayout.LayoutParams(100, 200);
//        upButton.setLayoutParams(ub);
//        upButton.setX(240);
//        upButton.setY(420);
//
//        RelativeLayout.LayoutParams db = new RelativeLayout.LayoutParams(100, 200);
//        downButton.setLayoutParams(db);
//        downButton.setX(240);
//        downButton.setY(680);
//
//        // set button holders params
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//        buttonHolders.setLayoutParams(params);
//
//        // add buttons to button holder
//        buttonHolders.addView(leftButton);
//        buttonHolders.addView(rightButton);
//        buttonHolders.addView(upButton);
//        buttonHolders.addView(downButton);

        // add the map and then the button holder to the whole frame
//        frame.addView(mapView);
//        frame.addView(buttonHolders);
//        RelativeLayout r = findViewById(R.id.activity_main);
//        frame.addView(r);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        LinearLayout mapViewHolder = findViewById(R.id.mapViewHolder);
        MapView mapView = new MapView(this, p);
        mapViewHolder.addView(mapView);

        // find all the buttons
        Button leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);
        Button upButton = findViewById(R.id.upButton);
        Button downButton = findViewById(R.id.downButton);
        Button A_Button = findViewById(R.id.A_Button);
        Button B_Button = findViewById(R.id.B_Button);
        Button menuButton = findViewById(R.id.menuButton);
        Button menuBagButton = findViewById(R.id.menu_bag);
        Button menuPokemonButton = findViewById(R.id.menu_pokemon);
        Button menuProfileButton = findViewById(R.id.menu_profile);
        Button menuBackButton = findViewById(R.id.menu_back);

        final LinearLayout mainButtonHolder = findViewById(R.id.main_menu_holder);

        // set onClickListener for the buttons
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("left");
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("right");
            }
        });
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("up");
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("down");
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mainButtonHolder.setVisibility(View.VISIBLE);
            }
        });
        menuBagButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        menuBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mainButtonHolder.setVisibility(View.GONE);
            }
        });
    }
}
