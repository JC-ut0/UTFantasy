package csc207.phase2.UTFantasy.Character.PlayerComparator;

import java.util.Comparator;

import csc207.phase2.UTFantasy.Character.Player;

/**
 * A comparator of Player, which will sort player by owned Pokemon number
 */
public class PlayerPokemonNumComparator implements Comparator<Player> {

  @Override
  public int compare(Player p1, Player p2) {
    return p1.getPokemonList().size() - p2.getPokemonList().size();
  }
}
