package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class QuickAttack extends Skill {
    /**
     * Constructor of a QuickAttack Skill.
     */
    public QuickAttack() {
        power = 40;
        pp = 30;
        effect = "";
        type = "normal";
        name = "Quick Attack";
    }

    /**
     * A description of the Skill.
     * @return a String which is a short description of the Skill
     */
    @NonNull
    @Override
    public String toString() {
        return name + ": An extremely fast attack that always strikes first.";
    }
}
