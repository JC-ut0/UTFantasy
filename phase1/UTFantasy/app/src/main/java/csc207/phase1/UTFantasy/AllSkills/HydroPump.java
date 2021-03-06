package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class HydroPump extends Skill {
    /**
     * Constructor of a HydroPump Skill.
     */
    public HydroPump() {
        name = "Hydro Pump";
        type = "water";
        power = 120;
        pp = 5;
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
        return name + ": Blasts water at high power to strike the foe.";
    }
}
