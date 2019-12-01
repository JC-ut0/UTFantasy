package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Pet.BattleObserver;
import csc207.phase2.UTFantasy.Pet.Pokemon;

import static csc207.phase2.UTFantasy.Battle.BattleData.Action.CATCHDECISION;

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
    Pokemon rivalPoke = battleData.getCurrRivalPoke();
    String text;
      if (!rivalPoke.isWild()) {
      text = battleData.getRival().getName() + " sent out " + rivalPoke.getPokemonName();
    } else {
      text = "A wild " + rivalPoke.getPokemonName() + " has appeared!";
    }
    presenter.showText(text);
  }

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

  public void useSkill(Skill skill) {
    fightManager.useSkill(skill);
    presenter.closeSkillMenu();
  }

  public void updateText() {
    switch (battleData.getAction()) {
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
        battleData.clearOberser();
        break;
    }
  }

  public void openPokemonChoose() {
    presenter.showPokeList(battleData.getPlayer().getPokemonList(), battleData.getCurrPlayerPoke());
  }

  public void choosePokemon(int i) {
    Pokemon pokemon;
    try {
      pokemon = battleData.getPlayer().getPokemonList().get(i);
    } catch (IndexOutOfBoundsException e) {
      pokemon = null;
    }
    if (pokemon != null) {
      if (!pokemon.isAlive()) {
        presenter.warnPokeNotAlive();
      } else {
        battleData.setCurrPlayerPoke(pokemon);
        updatePokemon();
        updateHpBar();
        updateSkillButtons();
        presenter.closePokemonChoose();
        presenter.showText(pokemon.getPokemonName() + " go!");
      }
    }
  }

  public void useItem() {
    battleData.setAction(BattleData.Action.USEITEM);
    presenter.showText("...");
  }

  public BattleData getBattleData() {
    return battleData;
  }

  private void updatePokemon() {
    Pokemon myPoke = battleData.getCurrPlayerPoke();
    Pokemon rivalPoke = battleData.getCurrRivalPoke();
    myPoke.setObserver(this);
    rivalPoke.setObserver(this);
      presenter.updatePlayerPokeView(battleData.getCurrPlayerPoke().getProfileBackID());
    presenter.updateRivalPokeView(battleData.getCurrRivalPoke().getProfileID());
  }

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

  @Override
  public void updateExpBar() {
  }
}
