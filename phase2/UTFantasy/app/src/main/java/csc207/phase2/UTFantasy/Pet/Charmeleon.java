package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.Ember;
import csc207.phase2.UTFantasy.AllSkills.Flamethrower;
import csc207.phase2.UTFantasy.R;

public class Charmeleon extends Pokemon {
    /** Constructor of a Charmeleon. */
    public Charmeleon(){
        super();
        setType1("fire");
        skills[0] = new Ember();
        skills[1] = new Flamethrower();
        setProfileID(R.drawable.charmeleon);
        setPokemonName("Charmeleon");
        setBaseHp(58);
        setBaseAttack(72);
        setBaseDefense(62);
        setBaseSpeed(80);
        setHp(calculateStatistic("hp"));
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));
        setGrowType("quick");
        setExpToLevelUp(calculateExpToLevelUp());
        setExpAtCurrentLevel(calculateExpAtCurrentLevel());
        setLevelToEvolve(36);

    }

    /**
     * Get the profile ID of Charmeleon.
     *
     * @return an integer which the profile ID of Charmeleon.
     */
    @Override
    public int getProfileID() {
        return R.drawable.charmeleon;
    }
}
