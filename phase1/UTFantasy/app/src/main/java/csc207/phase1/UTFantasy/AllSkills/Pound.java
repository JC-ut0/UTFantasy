package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Pound extends Skill {
    /**
     * Constructor of a Pound Skill.
     */
    public Pound() {
        name = "Pound";
        power = 40;
        pp = 35;
        type = "normal";
        effect = "";
    }

    /**
     * A description of the Skill.
     *
     * @return a String which is a short description of the Skill
     */
    @NonNull
    @Override
    public String toString() {
        return name + ": Pounds the foe with forelegs or tail.";
    }
}
