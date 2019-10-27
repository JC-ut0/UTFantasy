package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class ThunderWave extends Skill {


    public ThunderWave() {
        power = 15;
        effect = "paralyzed";
        pp = 20;
        type = "electric";
        name = "Thunder Wave";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": A weak jolt of electricity that paralyzes the foe.";
    }
}
