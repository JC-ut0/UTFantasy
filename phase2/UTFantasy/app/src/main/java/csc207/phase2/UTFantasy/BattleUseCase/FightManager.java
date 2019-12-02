package csc207.phase2.UTFantasy.BattleUseCase;

import java.util.LinkedList;
import java.util.Random;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Pet.Pokemon;

/**
 * A manager responsible for updating text of fight action Each skill usage has a corresponding
 * linked list of FightTurnNode with fixed size and order Each FightTurnNode is responsible for
 * returning one corresponding message or null
 */
class FightManager {
  private BattleData battleData;
  /**
   * tempAttacker, tempDefender and tempSkill not representing the current ones, they are used for
   * memory of the slower attack
   */
  private Pokemon tempAttacker;

  private Pokemon tempDefender;
  private Skill tempSkill;
  /** the current node that is updating text */
  private FightTurnNode curr;

  FightManager(BattleData battleData) {
    this.battleData = battleData;
  }

  void useSkill(Skill playerSkill) {
    battleData.setSecondSkillUsed(false);
    battleData.setAction(BattleData.Action.FIGHT);
    // set rivalSkill to be a random skill of all skills owned by rivalPokemon
    Skill rivalSkill = null;
    while (rivalSkill == null) {
      rivalSkill =
          battleData.getCurrRivalPoke()
              .getSkills()[(new Random().nextInt(battleData.getCurrRivalPoke().getSkillNum()))];
    }
    Skill secondSkill;
    // determine which pokemon attacks first
    if (battleData.getCurrPlayerPoke().getSpeed() >= battleData.getCurrRivalPoke().getSpeed()) {
      tempAttacker = battleData.getCurrPlayerPoke();
      tempDefender = battleData.getCurrRivalPoke();
      tempSkill = playerSkill;
      secondSkill = rivalSkill;
    } else {
      tempAttacker = battleData.getCurrRivalPoke();
      tempDefender = battleData.getCurrPlayerPoke();
      tempSkill = rivalSkill;
      secondSkill = playerSkill;
    }
    updateBattleData(tempAttacker, tempDefender, tempSkill);
    directFightTurnBuild();

    // assign values for the second attack
    Pokemon temp = tempAttacker;
    tempAttacker = tempDefender;
    tempDefender = temp;
    tempSkill = secondSkill;
  }

  private void updateBattleData(Pokemon tempAttacker, Pokemon tempDefender, Skill tempSkill) {
    battleData.setAttacker(tempAttacker);
    battleData.setDefender(tempDefender);
    battleData.setSkill(tempSkill);
  }

  /** @return the text that is supposed to be shown return null iff two skills both are used */
  String updateText() {
    String text = null;
    // get the next text that is supposed to be displayed
    while (text == null && curr != null) {
      text = curr.getText();
      curr = curr.next();
    }
    if (text != null) {
      return text;
    } else {
      // the linked list of FightTurnNode has reached its end
      if (!battleData.isSecondSkillUsed()) {
        // the second pokemon should be using skills
        updateBattleData(tempAttacker, tempDefender, tempSkill);
        directFightTurnBuild();
        battleData.setSecondSkillUsed(true);
        return updateText();
      } else {
        // both pokemons should not use skills anymore
        battleData.setAction(BattleData.Action.OPENMENU);
        return "What to do next?";
      }
    }
  }

  /**
   * Build the linked list of FightTurnNode using battle data Set curr to be the first node of the
   * linkedList
   */
  private void directFightTurnBuild() {
    FightTurnBuilder fightTurnBuilder = new FightTurnBuilder(battleData);
    LinkedList<FightTurnNode> fightTurn =
        fightTurnBuilder
            .buildSkillCaller()
            .buildDMGCalculator()
            .buildFaintedChecker()
            .buildLevelUPChecker()
            .buildEndChecker()
            .buildRivalPokemonUpdater()
            .getProduct();
    curr = fightTurn.getFirst();
  }
}
