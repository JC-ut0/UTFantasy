package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

public class Confusion extends Skill {
    /**
     * Constructor of a Confusion Skill.
     */
    public Confusion() {
        name = "Confusion";
        type = "Psychic";
        power = 50;
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
        return name + ":  psychic attack that may cause confusion.";
    }
}
