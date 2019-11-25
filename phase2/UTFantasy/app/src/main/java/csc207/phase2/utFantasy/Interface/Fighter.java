package csc207.phase2.utFantasy.Interface;

import java.util.List;

import csc207.phase2.utFantasy.pet.Pokemon;

/** All objects which are able to fight. */
public interface Fighter {

  /** @return the name of this fighter */
  String getName();

  /**
   * add this pokemon to this fighter's pokemon list
   *
   * @param pokemon the pokemon to this fighter's pokemon list
   */
  void addPokemon(Pokemon pokemon);

  /** @return the pokemon list of this fighter */
  List<Pokemon> getPokemonList();

  /** @return true iff this fighter has at least one non-fainted pokemon */
  boolean isFightAble();
}
