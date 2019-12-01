package csc207.phase2.UTFantasy.Activities.scoreboard;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonLvComparator;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonNumComparator;

public class ScoreCalculator {
    private List<Player> playerList;

    public ScoreCalculator(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getListsortByPokemonLv() {
        playerList.sort(new PlayerPokemonLvComparator().reversed());
        return playerList;
    }

    public List<Player> getListSortByPokemonNum() {
        playerList.sort(new PlayerPokemonNumComparator().reversed());
        return playerList;
    }

    public String getTopPercentilByPokemonLv(Player player) {
        int maxPokemonLv = player.getPlayerPokemonMaxLV();
        PlayerPokemonLvComparator comparator = new PlayerPokemonLvComparator();
        playerList.sort(comparator.reversed());
        int i;
        for (i = 0; i < playerList.size(); i++) {
            if (comparator.compare(player, playerList.get(i)) >= 0) {
                return "Top " + (i + 1);
            }
        }
        return "Top " + (i + 1);
    }
}
