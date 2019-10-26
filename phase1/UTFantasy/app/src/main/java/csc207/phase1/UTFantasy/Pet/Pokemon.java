package csc207.phase1.UTFantasy.Pet;

import android.app.Person;

import androidx.annotation.NonNull;

import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.R;

public abstract class Pokemon {

    protected String pokemonName;

    /**
     * first coordinate
     */
    protected int x;
    /**
     * second coordinate
     */
    protected int y;
    /**
     * skills this pokemonList have
     * there are four different skills
     */
    protected Skill[] skills = new Skill[4];
    /**
     * level of this pokemonList
     */
    protected int level;
    /**
     * status of this pokemonList
     */
    protected String status;
    /**
     * health point of this pokemonList
     */
    protected int hp;
    /**
     * experience this pokemonList has
     */
    protected int exp;
    /**
     * person that this pokemonList belongs to
     */
    protected csc207.phase1.UTFantasy.Character.Person master;
    /**
     * The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
     */
    protected int profileID;
    /**
     * Speed determines
     */
    protected int speed;

    Pokemon() {
        this.level = 1;
        this.exp = 0;
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

    void setHp(int hp) {
        this.hp = hp;
    }

    int getHp() {
        return hp;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    public void updateSkills(Skill addSkill, Skill removeSkill) {
    }

    public csc207.phase1.UTFantasy.Character.Person getMaster() {
        return master;
    }


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getProfileID() {
        return profileID;
    }

    @NonNull
    @Override
    public String toString() {
        return pokemonName + "    LV" + level;
    }

    public void setMaster(csc207.phase1.UTFantasy.Character.Person master) {
        this.master = master;
    }
}
