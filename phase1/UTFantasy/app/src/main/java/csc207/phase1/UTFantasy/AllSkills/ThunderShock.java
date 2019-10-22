package csc207.phase1.UTFantasy.AllSkills;

public class ThunderShock implements Skill {
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

    public ThunderShock() {
        damage = 1;
        status = "I know nothing about this";//不知道这个是干嘛的
        pp = 5;
        type = "electronic";
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
