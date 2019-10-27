package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Scratch;
import csc207.phase1.UTFantasy.R;

public class Psyduck extends Pokemon {
    public Psyduck(){
        pokemonName = "Psyduck";
        skills[0] = new Scratch();
        profileID = R.drawable.psyduck;
        base_hp = 50;
        base_attack = 58;
        base_defense = 48;
        base_speed = 55;
        calculateStatistic("hp");
        calculateStatistic("attack");
        calculateStatistic("defense");
        calculateStatistic("speed");
    }
}
