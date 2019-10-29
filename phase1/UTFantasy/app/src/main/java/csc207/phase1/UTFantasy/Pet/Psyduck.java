package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Scratch;
import csc207.phase1.UTFantasy.R;

public class Psyduck extends Pokemon {
    /**
     * Constructor of a Psyduck.
     */
    public Psyduck(){
        super();
        pokemonName = "Psyduck";
        skills[0] = new Scratch();
        profileID = R.drawable.psyduck;
        base_hp = 50;
        base_attack = 58;
        base_defense = 48;
        base_speed = 55;
        setHp(calculateStatistic("hp"));
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));
    }

    /**
     * Get the profile ID of Psyduck.
     * @return an integer which the profile ID of Psyduck.
     */
    @Override
    public int getProfileID() {
        return R.drawable.psyduck;
    }
}
