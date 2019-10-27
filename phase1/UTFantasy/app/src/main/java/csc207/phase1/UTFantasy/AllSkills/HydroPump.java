package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class HydroPump extends Skill {
    public HydroPump(){
        name = "Hydro Pump";
        type = "water";
        power = 120;
        pp = 5;
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": Blasts water at high power to strike the foe.";
    }
}
