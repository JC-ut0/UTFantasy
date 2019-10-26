package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.QuickAttack;
import csc207.phase1.UTFantasy.R;

public class Pikachu extends Pokemon {
    /**
     * The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
     */
    private static int PROFILE_ID = R.drawable.pikachu;

    public Pikachu() {
        setHP(10);
        // set its first skill to be QuickAttack
        skills[0] = new QuickAttack();
    }

    public static int getProfile_id() {
        return PROFILE_ID;
    }

}
