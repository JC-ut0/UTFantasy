package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.AllSkills.Skill;

public class BattleController {
    private BattleInteractor interactor;

    public BattleController(BattleInteractor interactor, BattlePresenter presenter) {
        this.interactor = interactor;
    }

    public void skillClick(int i) {
        Skill skill = interactor.getBattleData().getCurrPlayerPoke().getSkills()[i];
        if (skill != null) {
            interactor.useSkill(skill);
        }
        updateText();
    }

    public void updateText() {
        interactor.updateText();
    }

    public void openPokemonChoose() {
        interactor.openPokemonChoose();
    }

    public void choosePokemon(int i) {
        interactor.choosePokemon(i);
    }

    public void useItem() {
        interactor.useItem();
    }

    public void fight(){
        interactor.fight();
    }
}
