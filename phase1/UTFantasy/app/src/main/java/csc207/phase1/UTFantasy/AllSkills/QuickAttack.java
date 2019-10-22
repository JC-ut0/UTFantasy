package csc207.phase1.UTFantasy.AllSkills;

public class QuickAttack implements Skill {
    /**
     * The damage of the skill.
     */
    private int damage;

    /**
     * The special status of this skill.
     */
    private String status;

    /**
     * power points of this skill
     */
    private int pp;

    /**
     * The type of the skill.
     */
    private String type;

    public QuickAttack() {
        damage = 20;
        pp = 3;
        status = "available";
        type = "normal";
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getPp() {
        return pp;
    }

    @Override
    public void setPp(int pp) {
        this.pp = pp;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
