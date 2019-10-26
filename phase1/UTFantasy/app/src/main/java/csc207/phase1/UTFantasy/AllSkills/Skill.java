package csc207.phase1.UTFantasy.AllSkills;

public abstract class Skill {
    /**
     * The damage of the skill.
     */
    protected int damage;

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

    public int getDamage() {
        return damage;
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

}
