package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Pound;
import csc207.phase2.UTFantasy.R;

public class Jigglypuff extends Pokemon {
    /**
     * Constructor of a Jigglypuff.
     */
    public Jigglypuff() {
        super();
        type = "normal";
        skills[0] = new Pound();
        profileID = R.drawable.jigglypuff;
        pokemonName = "Jigglypuff";
        base_hp = 115;
        base_attack = 45;
        base_defense = 25;
        base_speed = 20;
        setHp(calculateStatistic("hp"));
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));
    }

    /**
     * Get the profile ID of Jigglypuff.
     *
     * @return an integer which the profile ID of Jigglypuff.
     */
    @Override
    public int getProfileID() {
        return R.drawable.jigglypuff;
    }
}
