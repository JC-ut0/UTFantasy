package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Scratch extends Skill {

    public Scratch() {
        power = 40;
        pp = 35;
        effect = "";
        type = "normal";
        name = "Scratch";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": Scratches the foe with sharp claws.";
    }
}
