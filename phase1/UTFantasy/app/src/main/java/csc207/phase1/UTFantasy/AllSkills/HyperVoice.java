package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class HyperVoice extends Skill {
    public HyperVoice(){
        name = "Hyper Voice";
        power = 90;
        pp = 10;
        type = "normal";
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": A loud attack that uses sound waves to injure.";
    }
}
