package csc207.phase2.UTFantasy.Character.PlayerComparator;

import java.util.Comparator;

import csc207.phase2.UTFantasy.Character.Player;

/** A comparator of Player, which will sort player by Pokemon max level */
public class PlayerPokemonLvComparator implements Comparator<Player> {
  @Override
  public int compare(Player p1, Player p2) {
    return p1.getPlayerPokemonMaxLV() - p2.getPlayerPokemonMaxLV();
  }
}
