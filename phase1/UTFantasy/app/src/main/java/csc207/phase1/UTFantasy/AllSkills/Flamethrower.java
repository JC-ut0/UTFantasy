package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Flamethrower extends Skill {

    public Flamethrower() {
        power = 95;
        pp = 15;
        effect = "burned";
        type = "fire";
        name = "Flamethrower";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": A powerful fire attack that may inflict a burn.";
    }
}
