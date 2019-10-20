package csc207.phase1.UTFantasy.Activities;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.MapView;
import csc207.phase1.UTFantasy.R;

public class MainActivity extends AppCompatActivity {

    /**
     * the intent of MainActivity
     */

    /**
     * the player
     */
    Player p;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        p = (Player) intent.getSerializableExtra("player");

        MapView mapView = new MapView(this, p);
        FrameLayout frame = new FrameLayout(this);
        RelativeLayout buttonHolders = new RelativeLayout(this);

        // create buttons
        Button leftButton = new Button(this);
        leftButton.setId(123456);

        Button rightButton = new Button(this);
        rightButton.setId(123457);

        Button upButton = new Button(this);
        leftButton.setId(123458);

        Button downButton = new Button(this);
        rightButton.setId(123459);

        //create button params
        RelativeLayout.LayoutParams lb = new RelativeLayout.LayoutParams(200, 100);
        leftButton.setLayoutParams(lb);
        leftButton.setX(50);
        leftButton.setY(600);

        RelativeLayout.LayoutParams rb = new RelativeLayout.LayoutParams(200, 100);
        rightButton.setLayoutParams(rb);
        rightButton.setX(330);
        rightButton.setY(600);

        RelativeLayout.LayoutParams ub = new RelativeLayout.LayoutParams(100, 200);
        upButton.setLayoutParams(ub);
        upButton.setX(240);
        upButton.setY(420);

        RelativeLayout.LayoutParams db = new RelativeLayout.LayoutParams(100, 200);
        downButton.setLayoutParams(db);
        downButton.setX(240);
        downButton.setY(680);

        // set button holders params
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        buttonHolders.setLayoutParams(params);

        // add buttons to button holder
        buttonHolders.addView(leftButton);
        buttonHolders.addView(rightButton);
        buttonHolders.addView(upButton);
        buttonHolders.addView(downButton);

        // add the map and then the button holder to the whole frame
        frame.addView(mapView);
        frame.addView(buttonHolders);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(frame);

        // set onClickListener for the buttons
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("left");
                System.out.println("left");
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("right");
                System.out.println("right");
            }
        });
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("up");
                System.out.println("up");
            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.move("down");
            }
        });
    }
}
