package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Pound;
import csc207.phase1.UTFantasy.R;

public class Jigglypuff extends Pokemon {

    public Jigglypuff(){
        setHp(10);
        skills[0] = new Pound();
        profileID = R.drawable.jigglypuff;
        pokemonName = "Jigglypuff";
    }
}
