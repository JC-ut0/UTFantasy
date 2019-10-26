package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Scratch;
import csc207.phase1.UTFantasy.R;

public class Psyduck extends Pokemon {
    public Psyduck(){
        pokemonName = "Psyduck";
        setHp(10);
        skills[0] = new Scratch();
        profileID = R.drawable.psyduck;
    }
}
