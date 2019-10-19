package csc207.phase1.UTFantasy;

import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class Pokemon {
    /**
     * name of pokemon*/
    private String name;
    /**
     * first coordinate*/
    private int x;
    /**
     * second coordinate*/
    private int y;
    /**
     * skills this pokemon have
     * there are four different skills*/
    private Skill[] skills;
    /**
     * level of this pokemon*/
    private int level;
    /**
     * status of this pokemon*/
    private String status;
    /**
     * health point of this pokemon*/
    private int HP;
    /**
     * experience this pokemon has*/
    private int EXP;
    /**
     * person that this pokemon belongs to*/
    private Person master;

    Pokemon(String name){
        this.name = name;
        this.level = 1;
        this.HP = 10;
        this.EXP = 0;
    }

    String getName(){
        return name;
    }

    int getX(){
        return x;
    }
    void set(int x){
        this.x = x;
    }

    int getY(){
        return y;
    }
    void setY(int y){
        this.y = y;
    }

    void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getLevel(){
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    void setStatus(String status){
        this.status = status;
    }
    String getStatus(){
        return status;
    }

    void setHP(int hp){
        HP = hp;
    }
    int getHP(){
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
