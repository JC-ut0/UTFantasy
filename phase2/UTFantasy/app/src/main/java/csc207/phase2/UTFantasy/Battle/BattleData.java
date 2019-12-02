package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;

/**
 * The entity that stores all the necessary data of this battle
 */
class BattleData {
  private Player player;
  private NPC rival;
  private Pokemon currPlayerPoke;
  private Pokemon currRivalPoke;
  private Pokemon attacker;
  private Pokemon defender;
  private Skill skill;
  private boolean secondSkillUsed;
  private TypeMap typeMap;
  /**
   * the action that supposed to be done in next updateText() call inside BattleInteractor
   */
  private Action action;

  public BattleData(Player player, NPC rival) {
    this.player = player;
    this.rival = rival;
    this.typeMap = new TypeMap();
    this.action = Action.BEGIN;
  }

  Player getPlayer() {
    return player;
  }

  NPC getRival() {
    return rival;
  }

  Pokemon getCurrPlayerPoke() {
    return currPlayerPoke;
  }

  Pokemon getCurrRivalPoke() {
    return currRivalPoke;
  }

  void setCurrPlayerPoke(Pokemon currPlayerPoke) {
    this.currPlayerPoke = currPlayerPoke;
  }

  void setCurrRivalPoke(Pokemon currRivalPoke) {
    this.currRivalPoke = currRivalPoke;
  }

  Pokemon getAttacker() {
    return attacker;
  }

  Pokemon getDefender() {
    return defender;
  }

  Skill getSkill() {
    return skill;
  }

  void setAttacker(Pokemon attacker) {
    this.attacker = attacker;
  }

  void setDefender(Pokemon defender) {
    this.defender = defender;
  }

  void setSkill(Skill skill) {
    this.skill = skill;
  }

  double getTypeIndex(TypeMap.TypeEnum attackType, TypeMap.TypeEnum defendType) {
    return typeMap.getTypeIndex(attackType, defendType);
  }

  enum Action {
    BEGIN,
    FIGHT,
    USEITEM,
    CATCH,
    CATCHDECISION,
    HEAL,
    OPENMENU,
    END
  }

  void setAction(Action action) {
    this.action = action;
  }

  Action getAction() {
    return action;
  }

  boolean isSecondSkillUsed() {
    return secondSkillUsed;
  }

  void setSecondSkillUsed(boolean secondSkillUsed) {
    this.secondSkillUsed = secondSkillUsed;
  }

  /**
   * clear the observer of all pokemons engaged during this battle
   */
  void clearObserver() {
    for (Pokemon pokemon : player.getPokemonList()) {
      pokemon.setObserver(null);
    }
    for (Pokemon pokemon : rival.getPokemonList()) {
      pokemon.setObserver(null);
    }
  }
}
