package csc207.phase2.UTFantasy.BattleUseCase;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;

/** The entity that stores all the necessary data of this battle */
public class BattleData {
  private Player player;
  private NPC rival;
  private Pokemon currPlayerPoke;
  private Pokemon currRivalPoke;
  private Pokemon attacker;
  private Pokemon defender;
  private Skill skill;
  private boolean secondSkillUsed;
  private TypeMap typeMap;
  /** the action that supposed to be done in next updateText() call inside BattleInteractor */
  private Action action;

  public BattleData(Player player, NPC rival) {
    this.player = player;
    this.rival = rival;
    this.typeMap = new TypeMap();
    this.action = Action.BEGIN;
  }

    public Player getPlayer() {
    return player;
  }

    public NPC getRival() {
    return rival;
  }

    public Pokemon getCurrPlayerPoke() {
    return currPlayerPoke;
  }

  void setCurrPlayerPoke(Pokemon currPlayerPoke) {
    this.currPlayerPoke = currPlayerPoke;
  }

  Pokemon getCurrRivalPoke() {
    return currRivalPoke;
  }

  void setCurrRivalPoke(Pokemon currRivalPoke) {
    this.currRivalPoke = currRivalPoke;
  }

  Pokemon getAttacker() {
    return attacker;
  }

  void setAttacker(Pokemon attacker) {
    this.attacker = attacker;
  }

  Pokemon getDefender() {
    return defender;
  }

  void setDefender(Pokemon defender) {
    this.defender = defender;
  }

  Skill getSkill() {
    return skill;
  }

  void setSkill(Skill skill) {
    this.skill = skill;
  }

  double getTypeIndex(TypeMap.TypeEnum attackType, TypeMap.TypeEnum defendType) {
    return typeMap.getTypeIndex(attackType, defendType);
  }

  Action getAction() {
    return action;
  }

  void setAction(Action action) {
    this.action = action;
  }

  boolean isSecondSkillUsed() {
    return secondSkillUsed;
  }

  void setSecondSkillUsed(boolean secondSkillUsed) {
    this.secondSkillUsed = secondSkillUsed;
  }

  /** clear the observer of all pokemons engaged during this battle */
  public void clearObserver() {
    for (Pokemon pokemon : player.getPokemonList()) {
      pokemon.setObserver(null);
    }
    for (Pokemon pokemon : rival.getPokemonList()) {
      pokemon.setObserver(null);
    }
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
}
