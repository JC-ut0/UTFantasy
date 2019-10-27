package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Bubble extends Skill {
    public Bubble(){
        name = "Bubble";
        type = "water";
        power = 20;
        pp = 30;
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": An attack using bubbles. May lower the foe's SPEED.";
    }
}
