package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Ember extends Skill {

    public Ember() {
        power = 40;
        pp = 25;
        effect = "burned";
        type = "fire";
        name = "Ember";

    }

    @NonNull
    @Override
    public String toString() {
        return name + ": A weak fire attack that may inflict a burn.";
    }
}
