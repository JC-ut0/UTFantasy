package csc207.phase2.UTFantasy.Battle;

import java.util.List;

import csc207.phase2.UTFantasy.Pet.Pokemon;

public interface BattleOutputBoundary {
  void showText(String text);

  void openMenu();

  void openSkillBox();

  /**
   * display pokemons for choose pokemon action
   *
   * @param pokeList          the list of pokemons owned by the player
   * @param currPlayerPokemon the player's pokemon that is currently attending the battle
   */
  void showPokeList(List<Pokemon> pokeList, Pokemon currPlayerPokemon);

  void closeSkillMenu();

  void closePokemonChoose();

  void updatePlayerPokeView(int pokeId);

  void updateRivalPokeView(int pokeId);

  void updatePlayerHpBar(int hp, int maxHp);

  void updateRivalHpBar(int hp, int maxHp);

  void endFight();

  void popText(String text);

  void setSkill1(String skill1);

  void setSkill2(String skill2);

  void setSkill3(String skill3);

  void setSkill4(String skill4);

  void showCatch();

  void hideCatch();

  void showCaught();
}
