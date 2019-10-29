package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.QuickAttack;
import csc207.phase1.UTFantasy.R;

public class Pikachu extends Pokemon {

    public Pikachu() {
        // set its first skill to be QuickAttack
        super();
        skills[0] = new QuickAttack();
        profileID = R.drawable.pikachu;
        pokemonName = "Pikachu";
        base_hp = 35;
        base_attack = 55;
        base_defense = 30;
        base_speed = 90;
        calculateStatistic("attack");
        calculateStatistic("defense");
        calculateStatistic("speed");
        calculateStatistic("hp");
        hp = maximumHp;
    }

    public static int getProfile_id() {
        //The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
        return R.drawable.pikachu;
    }

}
