package csc207.phase1.UTFantasy;

public abstract class Skill {

    int damage;
    String status;
    /**
     * power points of this skill */
    int PP;

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
