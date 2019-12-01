package csc207.phase2.UTFantasy.Activities.scoreboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonLvComparator;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonNumComparator;
import csc207.phase2.UTFantasy.IO.UserIO;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.PokemonFactory;
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
    private ScoreBoardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        userIO = UserIO.getSingletonUserIo();
        userManagerFacade = new UserManagerFacade(userIO, this);
        playerList = userManagerFacade.getScoreBoardPlayerList();

        //todo: delete later, this is only for testing
        addPokemon();

        playerList.sort(new PlayerPokemonLvComparator().reversed());

        ListView listView = findViewById(R.id.scoreBoardViewList);
        adapter = new ScoreBoardAdapter(this, playerList);
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
        playerList.sort(new PlayerPokemonLvComparator().reversed());
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Sorted", Toast.LENGTH_SHORT).show();
    }

    public void sortByPokemonNum(View view) {
        playerList.sort(new PlayerPokemonNumComparator().reversed());
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Sorted", Toast.LENGTH_SHORT).show();
    }

    //todo: delete later, this is only for testing and demo
    private void addPokemon() {
        Player p1 = new Player("p1", "boy");
        Player p2 = new Player("p2", "boy");
        Player p3 = new Player("p3", "girl");

        PokemonFactory pokemonFactory = new PokemonFactory();

        Pokemon pet1 = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 10);
        Pokemon pet2 = pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 12);

        p1.addPokemon(pet1);
        p1.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 1));
        p1.addPokemon(pokemonFactory.createPokemon(PokemonFactory.PokemonClass.PIKACHU, 1));
        p2.addPokemon(pet1);
        p2.addPokemon(pet2);
        p3.addPokemon(pet1);
        p3.addPokemon(pet2);

        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
    }
}
