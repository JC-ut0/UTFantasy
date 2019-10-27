package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Doubleslap extends Skill {
    public Doubleslap(){
        name = "Doubleslap";
        power = 35;
        pp = 10;
        type = "normal";
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": Repeatedly slaps the foe 2 to 5 times.";
    }
}
