package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Confusion extends Skill {
    public Confusion(){
        name = "Confusion";
        type = "Psychic";
        power = 50;
        pp = 25;
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ":  psychic attack that may cause confusion.";
    }
}
