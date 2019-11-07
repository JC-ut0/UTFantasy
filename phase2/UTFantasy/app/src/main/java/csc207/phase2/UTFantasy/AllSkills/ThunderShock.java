package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class ThunderShock extends Skill {
    /**
     * Constructor of a ThunderShock Skill.
     */
    public ThunderShock() {
        power = 40;
        effect = "paralyzed";
        pp = 30;
        type = "electric";
        name = "Thunder Shock";
    }

    /**
     * A description of the Skill.
     *
     * @return a String which is a short description of the Skill
     */
    @NonNull
    @Override
    public String toString() {
        return name + ": An electrical attack that may paralyze the foe.";
    }
}
