package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Scratch;
import csc207.phase1.UTFantasy.R;

public class Charmander extends Pokemon {

    public Charmander() {
        skills[0] = new Scratch();
        profileID = R.drawable.charmander;
        pokemonName = "Charmander";
        base_hp = 39;
        base_attack = 56;
        base_defense = 45;
        base_speed = 65;
        setHp(calculateStatistic("hp"));
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));

    }

    @Override
    public int getProfileID() {
        return R.drawable.charmander;
    }
}
