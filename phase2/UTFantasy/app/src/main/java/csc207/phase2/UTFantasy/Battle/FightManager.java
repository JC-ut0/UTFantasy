package csc207.phase2.UTFantasy.Battle;

import java.util.LinkedList;
import java.util.Random;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class FightManager {
  private BattleData battleData;
  /**
   * tempAttacker, tempDefender and tempSkill not representing the current ones, they are used for
   * memory of the slower attack
   */
  private Pokemon tempAttacker;

  private Pokemon tempDefender;
  private Skill tempSkill;

  private FightTurnNode curr;

  public FightManager(BattleData battleData) {
    this.battleData = battleData;
  }

  public void useSkill(Skill playerSkill) {
    battleData.setSecondSkillUsed(false);
    battleData.setAction(BattleData.Action.FIGHT);
    // set rivalSkill to be random
    Skill rivalSkill = null;
    while (rivalSkill == null) {
      rivalSkill =
              battleData.getCurrRivalPoke()
                      .getSkills()[(new Random().nextInt(battleData.getCurrRivalPoke().getSkillNum()))];
    }
    Skill secondSkill;
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
    setBattleData(tempAttacker, tempDefender, tempSkill);
    directFightTurnBuild();

    // assign values for the second attack
    Pokemon temp = tempAttacker;
    tempAttacker = tempDefender;
    tempDefender = temp;
    tempSkill = secondSkill;
  }

  private void setBattleData(Pokemon tempAttacker, Pokemon tempDefender, Skill tempSkill) {
    battleData.setAttacker(tempAttacker);
    battleData.setDefender(tempDefender);
    battleData.setSkill(tempSkill);
  }

  /**
   * @return the text that is supposed to be shown return null iff two skills both are used
   */
  public String updateText() {
    String text = null;
    while (text == null && curr != null) {
      text = curr.getText();
      curr = curr.next();
    }
    if (text != null) {
      return text;
    } else {
      if (!battleData.isSecondSkillUsed()) {
        setBattleData(tempAttacker, tempDefender, tempSkill);
        directFightTurnBuild();
        battleData.setSecondSkillUsed(true);
        return updateText();
      } else {
        battleData.setAction(BattleData.Action.OPENMENU);
        return "What to do next?";
      }
    }
  }

  public void directFightTurnBuild() {
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
