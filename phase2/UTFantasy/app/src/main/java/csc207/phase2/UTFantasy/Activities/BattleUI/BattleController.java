package csc207.phase2.UTFantasy.Activities.BattleUI;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.BattleUseCase.BattleInteractor;

public class BattleController {
  private BattleInteractor interactor;

  BattleController(BattleInteractor interactor) {
    this.interactor = interactor;
  }

  /**
   * called when one skill is used
   *
   * @param i the skill being used is the i-th skill of current player pokemon's skills
   */
  void skillClick(int i) {
    Skill skill = interactor.getBattleData().getCurrPlayerPoke().getSkills()[i];
    if (skill != null) {
      interactor.useSkill(skill);
    }
    updateText();
  }

  void updateText() {
    interactor.updateText();
  }

  void openPokemonChoose() {
    interactor.openPokemonChoose();
  }

  void choosePokemon(int i) {
    interactor.choosePokemon(i);
  }

  void useItem() {
    interactor.useItem();
  }

  public void fight() {
    interactor.fight();
  }
}
