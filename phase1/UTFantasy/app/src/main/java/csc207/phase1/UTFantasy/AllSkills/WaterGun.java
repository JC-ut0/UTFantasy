package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class WaterGun extends Skill {
    public WaterGun(){
        name = "Water Gun";
        type = "water";
        power = 40;
        pp = 25;
        effect = "";
    }

    @NonNull
    @Override
    public String toString() {
        return name + ": Squirts water to attack the foe.";
    }
}
