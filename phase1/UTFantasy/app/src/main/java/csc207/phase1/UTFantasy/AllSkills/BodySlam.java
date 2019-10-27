package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class BodySlam extends Skill {

    public BodySlam(){
        name = "Body Slam";
        type = "normal";
        power = 85;
        pp = 15;
        effect = "paralyzed";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": A full-body slam that may cause paralysis.";
    }
}
