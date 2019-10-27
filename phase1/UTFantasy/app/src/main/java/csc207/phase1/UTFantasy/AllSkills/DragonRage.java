package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class DragonRage extends Skill {

    public DragonRage() {
        power = 40;
        pp = 10;
        effect = "";
        type = "Dragon";
        name = "Dragon Rage";
    }

    @NonNull
    @Override
    public String toString() {
        return name + "Launches shock waves that always inflict 40 HP damage.";
    }
}
