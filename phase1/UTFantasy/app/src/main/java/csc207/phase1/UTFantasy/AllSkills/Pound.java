package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Pound extends Skill {

    public Pound(){
        name = "Pound";
        power = 40;
        pp = 35;
        type = "normal";
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": Pounds the foe with forelegs or tail.";
    }
}
