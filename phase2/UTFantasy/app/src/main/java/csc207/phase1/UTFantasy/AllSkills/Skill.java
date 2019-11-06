package csc207.phase1.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import java.io.Serializable;

public abstract class Skill implements Serializable {
    /**
     * The power of the skill.
     */
    protected int power;

    /**
     * The special status of this skill.
     */
    protected String effect;

    /**
     * power points of this skill
     */
    protected int pp;

    /**
     * The type of the skill.
     */
    protected String type;

    /**
     * The name of the skill.
     */
    protected String name;

    /**
     * The maximum amount of times of the Skill could be used.
     */
    public int maximumPp;

    /**
     * Set the effect of the Skill.
     *
     * @param effect a String which describes the effect of the Skill.
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }

    /**
     * Get the value of the power of the Skill.
     *
     * @return an integer which is the value of the power if the Skill.
     */
    public int getPower() {
        return power;
    }

    /**
     * Get the value of possible using times of the Skill.
     *
     * @return an integer which is the amount of times the Skill could be used.
     */
    public int getPp() {
        return pp;
    }

    /**
     * Set the value of possible using times of the Skills.
     *
     * @param pp the value of the amount of times the Skill could be used.
     */
    public void setPp(int pp) {
        this.pp = pp;
    }

    /**
     * Get the value of maximumPp of the Skill.
     *
     * @return an integer which is the value of maximumPp.
     */
    public int getMaximumPp() {
        return maximumPp;
    }

    /**
     * Get the effect of the Skill.
     *
     * @return a String which describes the effect of the Skill.
     */
    public String getEffect() {
        return effect;
    }

    /**
     * Set the power of the Skill.
     *
     * @param power a integer which is the value of the power of the Skill.
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Get the name of the Skill.
     *
     * @return a String of name of the Skill.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the type of the Skill.
     *
     * @return a String which is the type of the Skill.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the Skill.
     *
     * @param type a String which the type of the Skill.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The description the Skill.
     *
     * @return a String which describes the Skill.
     */
    @NonNull
    @Override
    public String toString() {
        return name + " is a powerful move.";
    }
}
