package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Tackle;
import csc207.phase1.UTFantasy.R;

public class Squirtle extends Pokemon {
    public Squirtle(){
        pokemonName = "Squirtle";
        skills[0] = new Tackle();
        profileID = R.drawable.squirtle;
        base_hp = 44;
        base_attack = 48;
        base_defense = 65;
        base_speed = 43;
        calculateStatistic("hp");
        calculateStatistic("attack");
        calculateStatistic("defense");
        calculateStatistic("speed");
    }

    @Override
    public int getProfileID() {
        return R.drawable.squirtle;
    }
}
