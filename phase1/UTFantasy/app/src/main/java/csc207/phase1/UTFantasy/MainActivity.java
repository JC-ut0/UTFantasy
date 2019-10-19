package csc207.phase1.UTFantasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import csc207.phase1.UTFantasy.Character.Player;

public class MainActivity extends AppCompatActivity {

    /**
     * the intent of MainActivity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("run main");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        Player p = (Player) intent.getSerializableExtra("player");
        setContentView(new MapView(this, p));
    }

}
