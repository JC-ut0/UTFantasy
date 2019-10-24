package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.QuickAttack;
import csc207.phase1.UTFantasy.AllSkills.Skill;

public class Pikachu extends Pokemon {
    public Pikachu() {
        setHP(10);
        // set its first skill to be QuickAttack
        skills[0] = new QuickAttack();
    }

}
