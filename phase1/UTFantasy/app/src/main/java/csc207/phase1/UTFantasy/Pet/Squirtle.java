package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Tackle;
import csc207.phase1.UTFantasy.R;

public class Squirtle extends Pokemon {
    public Squirtle(){
        pokemonName = "Squirtle";
        setHp(10);
        skills.set(0, new Tackle());
        profileID = R.drawable.squirtle;
    }
}
