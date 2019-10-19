package csc207.phase1.UTFantasy;

abstract class Skill {

    private int damage;
    private String status;
    /**
     * power points of this skill */
    private int PP;

    public Skill(int damage, int pp) {
        this.damage = damage;
        this.PP = pp;
    }

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
}
