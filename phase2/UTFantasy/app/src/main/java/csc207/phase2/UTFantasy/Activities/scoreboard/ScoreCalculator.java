package csc207.phase2.UTFantasy.Activities.scoreboard;

import java.util.List;

import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonLvComparator;
import csc207.phase2.UTFantasy.Character.PlayerComparator.PlayerPokemonNumComparator;

public class ScoreCalculator {
  /** The list of player */
  private List<Player> playerList;

  /**
   * the constructor of the ScoreCalculator
   *
   * @param playerList the list of player
   */
  public ScoreCalculator(List<Player> playerList) {
    this.playerList = playerList;
  }

  /**
   * get the list of player sorted by pokemon's level
   *
   * @return list of player
   */
  public List<Player> getListsortByPokemonLv() {
    playerList.sort(new PlayerPokemonLvComparator().reversed());
    return playerList;
  }

  /**
   * get the list of player sorted by the number amount of pokemon
   *
   * @return list of player
   */
  public List<Player> getListSortByPokemonNum() {
    playerList.sort(new PlayerPokemonNumComparator().reversed());
    return playerList;
  }

  /**
   * get the player's top percentile by the pokemon's level
   *
   * @param player the player
   * @return the percentile
   */
  public String getTopPercentileByPokemonLv(Player player) {
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
