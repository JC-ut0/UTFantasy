package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class ThunderWave extends Skill {
    /**
     * Constructor of a ThunderWave Skill.
     */
    public ThunderWave() {
        power = 15;
        effect = "paralyzed";
        pp = 20;
        type = "electric";
        name = "Thunder Wave";
    }

    /**
     * A description of the Skill.
     *
     * @return a String which is a short description of the Skill
     */
    @NonNull
    @Override
    public String toString() {
        return name + ": A weak jolt of electricity that paralyzes the foe.";
    }
}
