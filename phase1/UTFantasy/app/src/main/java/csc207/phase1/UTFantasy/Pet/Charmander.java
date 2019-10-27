package csc207.phase1.UTFantasy.Pet;

import csc207.phase1.UTFantasy.AllSkills.Scratch;
import csc207.phase1.UTFantasy.R;

public class Charmander extends Pokemon {

    public Charmander() {
        setHp(10);
        skills[0] = new Scratch();
        profileID = R.drawable.charmander;
        pokemonName = "Charmander";

    }
}
