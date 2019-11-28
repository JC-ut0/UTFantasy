package csc207.phase2.UTFantasy.Pet;

import csc207.phase2.UTFantasy.AllSkills.DragonRage;
import csc207.phase2.UTFantasy.AllSkills.Flamethrower;
import csc207.phase2.UTFantasy.Battle.TypeMap;
import csc207.phase2.UTFantasy.R;

public class Charizard extends Pokemon {
    /** Constructor of a Charizard. */
    public Charizard() {
        super();
        setType1(TypeMap.type.FIRE);
        setType2(TypeMap.type.FLYING);
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
