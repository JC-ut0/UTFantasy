package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Pound;
import csc207.phase1.UTFantasy.R;

public class Jigglypuff extends Pokemon {

    public Jigglypuff(){
        skills[0] = new Pound();
        profileID = R.drawable.jigglypuff;
        pokemonName = "Jigglypuff";
        base_hp = 115;
        base_attack = 45;
        base_defense = 25;
        base_speed = 20;
        calculateStatistic("hp");
        calculateStatistic("attack");
        calculateStatistic("defense");
        calculateStatistic("speed");
    }
}
