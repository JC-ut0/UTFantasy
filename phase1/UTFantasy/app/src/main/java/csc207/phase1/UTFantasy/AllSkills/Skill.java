package csc207.phase1.UTFantasy.AllSkills;

public abstract class Skill {

    int damage;
    String status;
    /**
     * power points of this skill */
    int PP;
    String type;

    Skill() {}

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDamage() {
        return damage;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public String getStatus() {
        return status;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
