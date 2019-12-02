package csc207.phase2.UTFantasy.Battle;

import java.util.List;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Pet.BattleObserver;
import csc207.phase2.UTFantasy.Pet.Pokemon;

import static csc207.phase2.UTFantasy.Battle.BattleData.Action.CATCHDECISION;
import static csc207.phase2.UTFantasy.Battle.BattleData.Action.OPENMENU;

/**
 * the interactor of this battle responsible for the connection between updating the correct data
 * and display them
 * acting as observer of pokemon responsible for update pokemon hp bar
 */
public class BattleInteractor implements BattleObserver {
  private BattleData battleData;
  private FightManager fightManager;
  private ItemManager itemManager;
  private BattleOutputBoundary presenter;

  public BattleInteractor(BattleData battleData, BattleOutputBoundary presenter) {
    this.battleData = battleData;
    this.fightManager = new FightManager(battleData);
    this.itemManager = new ItemManager(battleData);
    this.presenter = presenter;
    initializePokes();
    updateSkillButtons();
    updateHpBar();
  }

  /**
   * check if fight action can be done fight action can be done iff the current player pokemon is
   * alive
   */
  void fight() {
    Pokemon playerPoke = battleData.getCurrPlayerPoke();
    if (playerPoke.isAlive()) presenter.openSkillBox();
    else presenter.popText(playerPoke.getPokemonName() + " is not alive...");
  }

  /** initialize the pokemons and corresponding images at the beginning of the battle */
  private void initializePokes() {
    Pokemon myPoke = battleData.getPlayer().getFirstAlivePoke();
    Pokemon rivalPoke = battleData.getRival().getFirstAlivePoke();
    myPoke.setObserver(this);
    rivalPoke.setObserver(this);
    battleData.setCurrPlayerPoke(myPoke);
    battleData.setCurrRivalPoke(rivalPoke);
    updatePokemon();
    updateHpBar();
  }

  void useSkill(Skill skill) {
    fightManager.useSkill(skill);
    presenter.closeSkillMenu();
  }

  /**
   * update the correct text information to display them to user the one that is responsible for
   * updating text depending on the situation
   */
  void updateText() {
    updatePokemon();
    updateHpBar();
    switch (battleData.getAction()) {
      case BEGIN:
        presenter.showText(getBeginningText());
        battleData.setAction(OPENMENU);
        break;
      case FIGHT:
        presenter.showText(fightManager.updateText());
        break;
      case USEITEM:
        presenter.showText(itemManager.useItem());
        break;
      case CATCH:
        presenter.showCatch();
        battleData.setAction(CATCHDECISION);
        break;
      case CATCHDECISION:
        presenter.hideCatch();
        presenter.showText(itemManager.useBall());
        if (itemManager.isCaught()) {
          presenter.showCaught();
        }
        break;
      case HEAL:
        presenter.showText(itemManager.usePotion());
        break;
      case OPENMENU:
        presenter.openMenu();
        break;
      case END:
        presenter.endFight();
        break;
    }
  }

  void openPokemonChoose() {
    presenter.showPokeList(battleData.getPlayer().getPokemonList(), battleData.getCurrPlayerPoke());
  }

  void choosePokemon(int i) {
    Pokemon pokemon = null;
    List<Pokemon> pokemonList = battleData.getPlayer().getPokemonList();
    if (0 <= i && i < battleData.getPlayer().getPokemonList().size()) {
      pokemon = pokemonList.get(i);
    }
    if (pokemon != null) {
      if (!pokemon.isAlive()) {
        presenter.popText("You can't choose a fainted pokemon.");
      } else {
        // set the current player's pokemon to be selected pokemon and update corresponding feedback
        battleData.setCurrPlayerPoke(pokemon);
        updatePokemon();
        updateHpBar();
        updateSkillButtons();
        presenter.closePokemonChoose();
        presenter.showText(pokemon.getPokemonName() + " go!");
      }
    }
  }

  void useItem() {
    battleData.setAction(BattleData.Action.USEITEM);
    presenter.showText("...");
  }

  BattleData getBattleData() {
    return battleData;
  }

  /**
   * @return the correct text at the beginning of the battle
   */
  private String getBeginningText() {
    Pokemon rivalPoke = battleData.getCurrRivalPoke();
    String text;
    if (!rivalPoke.isWild()) {
      text = battleData.getRival().getName() + " sent out " + rivalPoke.getPokemonName();
    } else {
      text = "A wild " + rivalPoke.getPokemonName() + " has appeared!";
    }
    return text;
  }

  /**
   * update pokemons' observer to be this and update the images that is displaying
   */
  private void updatePokemon() {
    Pokemon myPoke = battleData.getCurrPlayerPoke();
    Pokemon rivalPoke = battleData.getCurrRivalPoke();
    myPoke.setObserver(this);
    rivalPoke.setObserver(this);
    presenter.updatePlayerPokeView(battleData.getCurrPlayerPoke().getProfileBackID());
    presenter.updateRivalPokeView(battleData.getCurrRivalPoke().getProfileID());
  }

  /**
   * update the text of skill buttons to be name of skills of current player's pokemon
   */
  private void updateSkillButtons() {
    Pokemon pokemon = battleData.getCurrPlayerPoke();
    for (int i = 0; i < 4; i++) {
      String skillName;
      if (pokemon.getSkills()[i] != null) {
        skillName = pokemon.getSkills()[i].getName();
      } else {
        skillName = "-";
      }
      switch (i) {
        case 0:
          presenter.setSkill1(skillName);
          break;
        case 1:
          presenter.setSkill2(skillName);
          break;
        case 2:
          presenter.setSkill3(skillName);
          break;
        case 3:
          presenter.setSkill4(skillName);
          break;
      }
    }
  }

  @Override
  public void updateHpBar() {
    Pokemon playerPoke = battleData.getCurrPlayerPoke();
    Pokemon rivalPoke = battleData.getCurrRivalPoke();
    presenter.updatePlayerHpBar(playerPoke.getHp(), playerPoke.getMaximumHp());
    presenter.updateRivalHpBar(rivalPoke.getHp(), rivalPoke.getMaximumHp());
  }
}
