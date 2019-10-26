package csc207.phase1.UTFantasy.Pet;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.Person;
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
    protected ArrayList<Skill> skills;
    /**
     * level of this pokemonList
     */
    protected int level;
    /**
     * status of this pokemonList
     */
    protected String status;
    /**
     * the attack of this pokemon
     */
    protected int attack;
    /**
     * the defense of this pokemon
     */
    protected int defense;
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
    protected Person master;
    /**
     * The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
     */
    protected int profileID;

    /**
     * The list of types of this pokemon
     */
    protected String type;


    /**
     * Speed determines
     */
    protected int speed;

    Pokemon() {
        this.level = 1;
        this.exp = 0;
        skills = new ArrayList<>();
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getLevel() {
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

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void addSkills(Skill skills) {
        this.skills.add(skills);
    }

    public void updateSkills(Skill addSkill, Skill removeSkill) {
    }

    public Person getMaster() {
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

    public int getAttack(){
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getSkillNum(){
        return skills.size();
    }
    @NonNull
    @Override
    public String toString() {
        return pokemonName + "    LV" + level;
    }

    public void setMaster(Person master) {
        this.master = master;
    }

    public boolean isAlive() {
        return hp == 0;
    }
}
