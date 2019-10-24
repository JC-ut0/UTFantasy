package csc207.phase1.UTFantasy.Pet;

import android.app.Person;

import csc207.phase1.UTFantasy.AllSkills.Skill;

public abstract class Pokemon {

    /**
     * first coordinate
     */
    protected int x;
    /**
     * second coordinate
     */
    protected int y;
    /**
     * skills this pokemon have
     * there are four different skills
     */
    protected Skill[] skills = new Skill[4];
    /**
     * level of this pokemon
     */
    protected int level;
    /**
     * status of this pokemon
     */
    protected String status;
    /**
     * health point of this pokemon
     */
    protected int HP;
    /**
     * experience this pokemon has
     */
    protected int EXP;
    /**
     * person that this pokemon belongs to
     */
    protected Person master;

    Pokemon() {
        this.level = 1;
        this.EXP = 0;
    }


    int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    void setStatus(String status) {
        this.status = status;
    }

    String getStatus() {
        return status;
    }

    void setHP(int hp) {
        HP = hp;
    }

    int getHP() {
        return HP;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    public void updateSkills(Skill addSkill, Skill removeSkill) {
    }

    public Person getMaster() {
        return master;
    }

    public void setMaster(Person master) {
        this.master = master;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }


}
