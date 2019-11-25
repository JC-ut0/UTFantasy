package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;

public class ScoreBoardActivity extends AppCompatActivity {

    /** the unique UserIO */
    private UserIO userIO = UserIO.getSingletonUserIo();

    List<Player> playerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        Intent intent = getIntent();

        // TODO create a list of Player and sort them
//        Player player = userIO.getUserData().getUser(username).getPlayer();

        ListView listView = findViewById(R.id.scoreBoardViewList);
        final ScoreBoardAdapter adapter = new ScoreBoardAdapter(this, playerList);
        listView.setAdapter(adapter);

    }
}

