package csc207.phase2.UTFantasy.Battle;


import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Pet.BattleObserver;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class BattleInteractor implements BattleObserver {
    private BattleData battleData;
    private FightManager fightManager;
    private BattleOutputBoundary presenter;

    public BattleInteractor(BattleData battleData, BattleOutputBoundary presenter) {
        this.battleData = battleData;
        this.fightManager = new FightManager(battleData);
        this.presenter = presenter;
        initializePokes();
        updateSkillButtons();
        presenter.showText(
                battleData.getRival().getName()
                        + " sent out "
                        + battleData.getCurrRivalPoke().getPokemonName());
    }

    private void initializePokes() {
        Pokemon myPoke = battleData.getPlayer().getFirstAlivePoke();
        Pokemon rivalPoke = battleData.getRival().getFirstAlivePoke();
        myPoke.setObserver(this);
        rivalPoke.setObserver(this);
        battleData.setCurrPlayerPoke(myPoke);
        battleData.setCurrRivalPoke(rivalPoke);
        updatePokemonIcon();
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
//        case CHANGEPOKEMON:
//          presenter.
            case OPENMENU:
                presenter.openMenu();
                break;
            case END:
                presenter.endFight();
                break;
        }
        updatePokemonIcon();
        updateHpBar();
        updateExpBar();
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
                presenter.updatePlayerPokeView(pokemon.getProfileID());
                presenter.updatePlayerHpBar(pokemon.getHp(), pokemon.getMaximumHp());
                updateSkillButtons();
                presenter.closePokemonChoose();
                presenter.showText(pokemon.getPokemonName() + " go!");
            }
        }
    }

    public BattleData getBattleData() {

        return battleData;
    }

    public void updatePokemonIcon() {
        Pokemon myPoke = battleData.getCurrPlayerPoke();
        Pokemon rivalPoke = battleData.getCurrRivalPoke();
        myPoke.setObserver(this);
        rivalPoke.setObserver(this);
        presenter.updatePlayerPokeView(battleData.getCurrPlayerPoke().getProfileID());
        presenter.updateRivalPokeView(battleData.getCurrRivalPoke().getProfileID());
    }

    public void updateSkillButtons() {
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

    ;

    @Override
    public void updateExpBar() {

    }
}
