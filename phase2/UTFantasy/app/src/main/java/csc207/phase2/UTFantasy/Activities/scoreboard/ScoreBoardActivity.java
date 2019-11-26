package csc207.phase2.UTFantasy.Activities.scoreboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonLvComparator;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonNumComparator;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.R;
import csc207.phase2.UTFantasy.User.UserManagerFacade;

public class ScoreBoardActivity extends AppCompatActivity {

    /**
     * the unique UserIO
     */
    private UserIO userIO;
    /**
     * User
     */
    private UserManagerFacade userManagerFacade;

    private List<Player> playerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        userIO = UserIO.getSingletonUserIo();
        userManagerFacade = new UserManagerFacade(userIO, this);
        playerList = userManagerFacade.getScoreBoardPlayerList();
        playerList.sort(new PlayerPokemonLvComparator());

        ListView listView = findViewById(R.id.scoreBoardViewList);
        ScoreBoardAdapter adapter = new ScoreBoardAdapter(this, playerList);
        listView.setAdapter(adapter);

        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void sortByPokemonLv(View view) {
        playerList.sort(new PlayerPokemonLvComparator());
    }

    public void sortByPokemonNum(View view) {
        playerList.sort(new PlayerPokemonNumComparator());
    }
}
