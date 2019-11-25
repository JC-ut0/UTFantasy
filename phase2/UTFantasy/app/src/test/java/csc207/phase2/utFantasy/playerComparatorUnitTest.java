package csc207.phase2.utFantasy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import csc207.phase2.utFantasy.character.Player;
import csc207.phase2.utFantasy.character.PlayerComparator.PlayerPokemonLvComparator;
import csc207.phase2.utFantasy.character.PlayerComparator.PlayerPokemonNumComparator;
import csc207.phase2.utFantasy.pet.Pikachu;

public class playerComparatorUnitTest {
    @Test
    public void playerComparator_isCorrect() {
        List<Player> playerList = new ArrayList<>();
        Player p1 = new Player("p1", "boy");
        Player p2 = new Player("p2", "boy");
        Player p3 = new Player("p3", "girl");

        Pikachu pet1 = new Pikachu();
        Pikachu pet2 = new Pikachu();

        pet1.setLevel(10);
        pet2.setLevel(12);

        p1.addPokemon(pet1);
        p1.addPokemon(new Pikachu());
        p1.addPokemon(new Pikachu());
        p2.addPokemon(pet1);
        p2.addPokemon(pet2);
        p3.addPokemon(pet1);
        p3.addPokemon(pet2);

        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        //    Collections.sort(playerList, new PlayerPokemonLvComparator());
        System.out.println("Before Sorting:" + playerList);
        playerList.sort(new PlayerPokemonNumComparator().reversed());
        System.out.println("Sorted by Number from high to low:" + playerList);
        playerList.sort(new PlayerPokemonLvComparator().reversed());
        System.out.println("Sorted by TotalLV from high to low:" + playerList);
    }
}
