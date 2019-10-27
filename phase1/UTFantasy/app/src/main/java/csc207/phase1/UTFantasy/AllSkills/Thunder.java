package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Thunder extends Skill {
    public Thunder() {
        power = 120;
        effect = "paralyzed";
        pp = 10;
        type = "electronic";
        name = "Thunder";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": A lightning attack that may cause paralysis.";
    }
}
