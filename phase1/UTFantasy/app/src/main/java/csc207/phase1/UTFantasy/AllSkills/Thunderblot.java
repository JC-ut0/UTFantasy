package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Thunderblot extends Skill {

    public Thunderblot() {
        power = 95;
        pp = 15;
        effect = "paralyzed";
        type = "electric";
        name = "Thunder Blot";
    }
    @NonNull
    @Override
    public String toString() {
        return name + ": A strong electrical attack that may paralyze the foe.";
    }
}
