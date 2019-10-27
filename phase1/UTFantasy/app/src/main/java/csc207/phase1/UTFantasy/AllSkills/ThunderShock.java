package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class ThunderShock extends Skill {

    public ThunderShock() {
        power = 40;
        effect = "paralyzed";
        pp = 30;
        type = "electric";
        name = "Thunder Shock";
    }
    @NonNull
    @Override
    public String toString() {
        return name + ": An electrical attack that may paralyze the foe.";
    }
}
