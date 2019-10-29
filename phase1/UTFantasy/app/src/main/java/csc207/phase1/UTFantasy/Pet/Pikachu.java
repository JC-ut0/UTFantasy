package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.QuickAttack;
import csc207.phase1.UTFantasy.R;

public class Pikachu extends Pokemon {

    public Pikachu() {
        // set its first skill to be QuickAttack
        skills[0] = new QuickAttack();
        profileID = R.drawable.pikachu;
        pokemonName = "Pikachu";
        base_hp = 35;
        base_attack = 55;
        base_defense = 30;
        base_speed = 90;
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));
        setHp(calculateStatistic("hp"));
    }

    public static int getProfile_id() {
        //The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
        return R.drawable.pikachu;
    }

}
