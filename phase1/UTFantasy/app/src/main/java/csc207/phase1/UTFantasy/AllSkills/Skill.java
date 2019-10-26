package csc207.phase1.UTFantasy.AllSkills;

public abstract class Skill {
    /**
     * The power of the skill.
     */
    protected int power;

    /**
     * The special status of this skill.
     */
    protected String status;

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

    public void setStatus(String status) {
        this.status = status;
    }

    public int getpower() {
        return power;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public String getStatus() {
        return status;
    }

    public void setpower(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}