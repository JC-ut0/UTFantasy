package csc207.phase2.UTFantasy.BattleUseCase;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Pet.Pokemon;

import static java.lang.StrictMath.max;

/**
 * A fightTurnNode that is responsible for updating the damage of skill usage Return text informing
 * the effect of this skill usage
 */
class DMGCalculator extends FightTurnNode {
  DMGCalculator(BattleData battleData) {
    this.battleData = battleData;
  }

  private int calculateDMG(Pokemon attacker, Pokemon defender, Skill skill, double typeIndex) {
    // calculate damage without modifier
    double damage = (2 * attacker.getLevel()) / 5 + 2;
    damage = damage * attacker.getAttack() / defender.getDefense();
    damage = ((damage * skill.getPower()) / 50) + 2;

    // calculate the modifier
    double random = Math.random() * (1 - 0.85) + 0.85;
    double r = Math.random();
    double rate = 1;
    if (r < 0.03125) {
      rate = 1.5;
    }
    float stab = 1;
    if (skill.getType().equals(attacker.getType1())) {
      stab = (float) 1.5;
    }
    double modifier = random * rate * typeIndex * stab;

    return (int) Math.floor(modifier * damage);
  }

  /** @return the message informing the effect of this skill usage */
  @Override
  public String getText() {
    Pokemon attacker = battleData.getAttacker();
    Pokemon defender = battleData.getDefender();
    Skill skill = battleData.getSkill();
    double typeIndex = battleData.getTypeIndex(skill.getType(), defender.getType1());
    typeIndex = typeIndex * battleData.getTypeIndex(skill.getType(), defender.getType2());
    int dmg = calculateDMG(attacker, defender, skill, typeIndex);
    defender.setHp(max(defender.getHp() - dmg, 0));
    defender.notifyObserverHpChange();
    if (typeIndex > 1) {
      return ("It is super effective!");
    } else if (typeIndex == 1) {
      return ("Nice shot.");
    } else {
      return ("It is not very effective...");
    }
  }
}
