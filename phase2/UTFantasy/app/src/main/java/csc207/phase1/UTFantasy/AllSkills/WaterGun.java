package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class WaterGun extends Skill {
    /**
     * Constructor of a WaterGun Skill.
     */
    public WaterGun() {
        name = "Water Gun";
        type = "water";
        power = 40;
        pp = 25;
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
        return name + ": Squirts water to attack the foe.";
    }
}
