package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.QuickAttack;
import csc207.phase1.UTFantasy.R;

public class Pikachu extends Pokemon {

    public Pikachu() {
        setHp(10);
        // set its first skill to be QuickAttack
        skills.set(0, new QuickAttack());
        profileID = R.drawable.pikachu;
        pokemonName = "Pikachu";
    }

    public static int getProfile_id() {
        //The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
        return R.drawable.pikachu;
    }

}
