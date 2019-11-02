package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.QuickAttack;
import csc207.phase1.UTFantasy.AllSkills.Thunder;
import csc207.phase1.UTFantasy.R;

public class Pikachu extends Pokemon {
    /**
     * Constructor of a Pikachu.
     */
    public Pikachu() {
        // set its first skill to be QuickAttack
        super();
        skills[0] = new QuickAttack();
        skills[1] = new Thunder();
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

    /**
     * Get the profile ID of Pikachu.
     *
     * @return an integer which the profile ID of Pikachu.
     */
    @Override
    public int getProfileID() {
        //The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
        return R.drawable.pikachu;
    }

}
