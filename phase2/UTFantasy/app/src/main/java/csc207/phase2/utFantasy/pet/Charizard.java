package csc207.phase2.utFantasy.pet;

import csc207.phase2.utFantasy.allSkills.DragonRage;
import csc207.phase2.utFantasy.allSkills.Flamethrower;
import csc207.phase2.utFantasy.R;

public class Charizard extends Pokemon {
    /** Constructor of a Charizard. */
    public Charizard() {
        super();
        setType1("fire");
        setType2("flying");
        setProfileID(R.drawable.charizard);
        skills[0] = new Flamethrower();
        skills[1] = new DragonRage();
        setPokemonName("Charizard");
        setBaseHp(78);
        setBaseAttack(97);
        setBaseDefense(82);
        setBaseSpeed(100);
        setHp(calculateStatistic("hp"));
        setAttack(calculateStatistic("attack"));
        setDefense(calculateStatistic("defense"));
        setSpeed(calculateStatistic("speed"));
        setGrowType("slow");
        setExpToLevelUp(calculateExpToLevelUp());
        setExpAtCurrentLevel(calculateExpAtCurrentLevel());
        setLevelToEvolve(1000);
    }

    /**
     * Get the profile ID of Charizard.
     *
     * @return an integer which the profile ID of Charizard.
     */
    @Override
    public int getProfileID() {
        return R.drawable.charizard;
    }
}
