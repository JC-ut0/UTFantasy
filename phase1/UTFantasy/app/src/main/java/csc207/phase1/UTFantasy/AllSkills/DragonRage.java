package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class DragonRage extends Skill {
    /**
     * Constructor of a DragonRage Skill.
     */
    public DragonRage() {
        power = 40;
        pp = 10;
        effect = "";
        type = "Dragon";
        name = "Dragon Rage";
    }

    /**
     * A description of the Skill.
     *
     * @return a String which is a short description of the Skill
     */
    @NonNull
    @Override
    public String toString() {
        return name + "Launches shock waves that always inflict 40 HP damage.";
    }
}
