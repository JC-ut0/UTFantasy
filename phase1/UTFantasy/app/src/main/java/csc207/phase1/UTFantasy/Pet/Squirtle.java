package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Tackle;
import csc207.phase1.UTFantasy.R;

public class Squirtle extends Pokemon {
    /**
     * Constructor of a Squirtle.
     */
    public Squirtle(){
        super();
        pokemonName = "Squirtle";
        skills[0] = new Tackle();
        profileID = R.drawable.squirtle;
        base_hp = 44;
        base_attack = 48;
        base_defense = 65;
        base_speed = 43;
        setHp(calculateStatistic("hp"));
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));
    }
    /**
     * Get the profile ID of Squirtle.
     * @return an integer which the profile ID of Squirtle.
     */
    @Override
    public int getProfileID() {
        return R.drawable.squirtle;
    }
}
