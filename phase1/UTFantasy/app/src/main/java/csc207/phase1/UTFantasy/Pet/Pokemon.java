package csc207.phase1.UTFantasy.Pet;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

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
    protected Skill[] skills;
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

    /**
     * Individual value of hp
     */
    protected int iv_hp;

    /**
     * Individual value of attack
     */
    protected int iv_attack;

    /**
     * Individual value of defense
     */
    protected int iv_defense;

    /**
     * Individual value of speed
     */
    protected int iv_speed;

    /**
     * Base stat of hp
     */
    protected static int base_hp;

    /**
     * Base stat of attack
     */
    protected static int base_attack;

    /**
     * Base stat of defense
     */
    protected static int base_defense;

    /**
     * Base stat of speed
     */
    protected static int base_speed;

    /**
     * Level growing type
     */
    protected String grow_type;

    Pokemon() {
        this.level = 1;
        this.exp = 0;
        skills = new Skill[4];
        Random r = new Random();
        iv_hp = r.nextInt(32);
        iv_attack = r.nextInt(32);
        iv_defense = r.nextInt(32);
        iv_speed = r.nextInt(32);
    }

    public void calculateStatistic(String statType){
        if (statType.equals("attack")){
            float base = ((base_attack + iv_attack) * 2 * level) / 100;
            this.attack = (int) Math.floor(base) + 5;
        } else if(statType.equals("defense")){
            float base = ((base_defense + iv_defense) * 2 * level) / 100;
            this.defense = (int) Math.floor(base) + 5;
        } else if(statType.equals("speed")){
            float base = ((base_speed + iv_speed) * 2 * level) / 100;
            this.speed = (int) Math.floor(base) + 5;
        } else if(statType.equals("hp")){
            float base = ((base_hp + iv_hp) * 2 * level) / 100;
            this.hp = (int) Math.floor(base) + level + 10;
        }

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

    public int getIv_hp(){
        return hp;
    }

    public void setIv_hp(int hp){
        this.hp = hp;
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

    int getHp() {
        return hp;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void updateSkills(Skill addSkill, Skill removeSkill) {
        for(int i = 0; i < 4; i ++){
            if(skills[i] == removeSkill){
                skills[i] = addSkill;
            }
        }
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


    public int getDefense() {
        return defense;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getSkillNum(){
       int result = 0;
       for(Skill skill : skills){
           if (skill != null){
               result +=1 ;
           }
       }
       return result;
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

    public int getSpeed(){
        return speed;
    }
}
