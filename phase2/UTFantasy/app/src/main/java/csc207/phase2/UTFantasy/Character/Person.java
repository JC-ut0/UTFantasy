package csc207.phase2.UTFantasy.Character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import csc207.phase2.UTFantasy.Pet.Pokemon;

public class Person implements Serializable {
  private final int maxSizeOfPokemonList = 6;
  protected String name;
  private String direction;
  protected int money;
  List<Pokemon> pokemonList;

  Person(String name) {
    this.name = name;
    this.pokemonList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public void addPokemon(Pokemon pokemon) {
    if (this.pokemonList.size() < maxSizeOfPokemonList) {
      this.pokemonList.add(pokemon);
      pokemon.setMaster(this);
    }
  }

  public List<Pokemon> getPokemonList() {
    return pokemonList;
  }

  public Pokemon getFirstAlivePoke() {
    int i = 0;
    Pokemon result = null;
    while (i < pokemonList.size() && result == null) {
      if (pokemonList.get(i).isAlive()) {
        result = pokemonList.get(i);
      }
      i++;
    }
    return result;
  }

  public boolean isFightAble() {
    return getFirstAlivePoke() != null;
  }

  public void heal() {
    for (Pokemon pokemon : pokemonList) {
      pokemon.setHp(pokemon.getMaximumHp());
    }
  }
}
