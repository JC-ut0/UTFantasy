package csc207.phase2.UTFantasy.Battle;

public interface BattleActivityModel {
  void showText(String text);

  /**
   * open the menu of choosing next action either choose skill, open bag, choose pokemon or escape
   */
  void openMenu();

  void openSkillBox();

  void closeSkillMenu();

  void closePokemonChoose();

  void endFight();

  void updatePlayerPoke(int pokeId);

  void updateRivalPoke(int pokeId);

  void updatePlayerPokeHp(int hp, int maxHp);

  void updateRivalPokeHp(int hp, int maxHp);

  /**
   * Update ImageView, ProgressBar, TextView of a pokemon when choosing pokemon.
   *
   * @param pokeNum the number of position of this pokemon in the player's bag
   * @param isAttending if this pokemon is the current pokemon during the battle
   * @param pokeId the profile icon of this pokemon
   * @param hp the hp of this pokemon
   * @param maxHp the maximum hp of this pokemon
   */
  void showSinglePokemonForChoose(int pokeNum, boolean isAttending, int pokeId, int maxHp, int hp);

  void popText(String text);

  void setSkill1(String skill1);

  void setSkill2(String skill2);

  void setSkill3(String skill3);

  void setSkill4(String skill4);

  /** run the animation of catching pokemon */
  void showCatch();

  /** stop the animation of catching pokemon called when pokemon is failed to be caught */
  void hideCatch();

  /** display that the pokemon is already caught */
  void showCaught();
}
