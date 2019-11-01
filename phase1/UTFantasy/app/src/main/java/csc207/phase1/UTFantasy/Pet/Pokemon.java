package csc207.phase1.UTFantasy.Pet;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Random;

import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.Person;

public abstract class Pokemon implements Serializable {

    /**
     * names of a certain Pokemon
     */
    String pokemonName;
    /**
     * skills this pokemonList have
     * there are four different skills
     */
    Skill[] skills;
    /**
     * level of this pokemonList
     */
    private int level;
    /**
     * status of this pokemonList
     */
    private String status;
    /**
     * the attack of this pokemon
     */
    protected int attack;
    /**
     * the defense of this pokemon
     */
    private int defense;
    /**
     * health point of this pokemonList
     */
    protected int hp;
    /**
     * experience this pokemonList has
     */
    private int exp;
    /**
     * person that this pokemonList belongs to
     */
    private Person master;
    /**
     * The unique profile id for each Pokemon. ID can be used to draw this Pokemon.
     */
    int profileID;

    /**
     * The list of types of this pokemon
     */
    protected String type;


    /**
     * Speed determines
     */
    private int speed;

    /**
     * Individual value of hp
     */
    private int iv_hp;

    /**
     * Individual value of attack
     */
    private int iv_attack;

    /**
     * Individual value of defense
     */
    private int iv_defense;

    /**
     * Individual value of speed
     */
    private int iv_speed;

    /**
     * Base stat of hp
     */
    int base_hp;

    /**
     * Base stat of attack
     */
    int base_attack;

    /**
     * Base stat of defense
     */
    int base_defense;

    /**
     * Base stat of speed
     */
    int base_speed;

    /**
     * Level growing type
     */
    protected String grow_type;

    /**
     * Maximum health point
     */
    public int maximumHp;

    /**
     * Constructor of Pokemon.
     */
    Pokemon() {
        level = 1;
        exp = 0;
        skills = new Skill[4];
        Random r = new Random();
        iv_hp = r.nextInt(32);
        iv_attack = r.nextInt(32);
        iv_defense = r.nextInt(32);
        iv_speed = r.nextInt(32);
    }

    /**
     * calculate the value of a statType of a pokemon.
     *
     * @param statType the type of statistic of pokemon will calculate.
     * @return the value of responding statistic.
     */
    int calculateStatistic(String statType) {
        switch (statType) {
            case "attack": {
                float base = ((base_attack + iv_attack) * 2 * level) / 100;
                return (int) Math.floor(base) + 5;
            }
            case "defense": {
                float base = ((base_defense + iv_defense) * 2 * level) / 100;
                return (int) Math.floor(base) + 5;
            }
            case "speed": {
                float base = ((base_speed + iv_speed) * 2 * level) / 100;
                return (int) Math.floor(base) + 5;
            }
            case "hp": {
                float base = ((base_hp + iv_hp) * 2 * level) / 100;
                hp = (int) Math.floor(base) + level + 10;
                setMaximumHp(hp);
                return hp;
            }
            default:
                return 0;

        }
    }

    /**
     * Set the hp of the Pokemon.
     * @param hp the value of health point to set.
     */
    public void setHp(int hp){this.hp = hp;}

    /**
     * Set the attack statistic of the Pokemon.
     * @param attack the value of attack to set.
     */
    public void setAttack(int attack){this.attack = attack;}

    /**
     * Set the defense statistic of the Pokemon.
     * @param defense the value of defense to set.
     */
    void setDefense(int defense){this.defense = defense;}

    /**
     * Set the speed statistic of the Pokemon.
     * @param speed the value of speed to set.
     */
    void setSpeed(int speed){this.speed = speed;}

    /**
     * Get the Individual value of health point of the Pokemon.
     * @return the value of Individual value of health point of the Pokemon.
     */
    public int getIv_hp() {
        return hp;
    }

    /**
     * Set the Individual value of health point of the Pokemon.
     * @param hp the value of Individual value of health point to set.
     */
    public void setIv_hp(int hp) {
        this.hp = hp;
    }

    /**
     * Get the value of Pokemon's current level.
     * @return the value of level of the Pokemon.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set Pokemon's current value.
     * @param level the value of level to set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Set the status of Pokemon's status.
     * @param status the description of Pokemon's status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the description of Pokemon's status.
     * @return a String which is the description of Pokemon's status.
     */
    String getStatus() {
        return status;
    }

    /**
     * Get the current health point of the Pokemon.
     * @return a integer which is the value of current health point.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Get the skills which the Pokemon currently has.
     * @return an arrayList of current skills.
     */
    public Skill[] getSkills() {
        return skills;
    }

    /**
     * Replace the removeSkill with addSkill in the Pokemon's skill list.
     * @param addSkill the Skill to be added in Pokemon's skill list.
     * @param removeSkill the Skill to be replaced in Pokemon's skill list.
     */
    public void updateSkills(Skill addSkill, Skill removeSkill) {
        for (int i = 0; i < 4; i++) {
            if (skills[i] == removeSkill) {
                skills[i] = addSkill;
            }
        }
    }

    /**
     * Get the master of the Pokemon.
     * @return a Person which is the master of the Pokemon.
     */
    public Person getMaster() {
        return master;
    }

    /**
     * Get the maximum health point of the Pokemon.
     * @return the value of the maximum health point.
     */
    public int getMaximumHp() {
        return maximumHp;
    }

    /**
     * Set the value of Pokemon's maximum health point.
     * @param maximumHp the value of maximum health point to set.
     */
    private void setMaximumHp(int maximumHp) {
        this.maximumHp = maximumHp;
    }

    /**
     * Get the value of Pokemon's current experience point.
     * @return an integer which is the value of Pokemon's experience point.
     */
    public int getExp() {
        return exp;
    }

    /**
     * Set the experience point of the Pokemon.
     * @param exp the value of exoerience point to set.
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * Get the name of the Pokemon.
     * @return a String which is the Pokemon's name.
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * Set Pokemon's name.
     * @param pokemonName the name of Pokemon to set.
     */
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    /**
     * Get the profile ID of the Pokemon.
     * @return a integer which is the profile ID of the Pokemon.
     */
    public int getProfileID() {
        return profileID;
    }

    /**
     * Get the value of Pokemon's attack statistic.
     * @return an integer which is the value of Pokemon's attack statistic.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Get the value of Pokemon's defense statistic.
     * @return an integer which is the value of Pokemon's defense statistic.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Get the type of the Pokemon.
     * @return a String which is the type of the Pokemon.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set the type of the Pokemon.
     * @param type a String which is the type of Pokemon to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the number of Skills the Pokemon has.
     * @return an integer which is the number of Skills Pokemon currently has.
     */
    public int getSkillNum() {
        int result = 0;
        for (Skill skill : skills) {
            if (skill != null) {
                result += 1;
            }
        }
        return result;
    }

    /**
     * Return a String which contains Pokemon's name and current level.
     * @return a String of description of the Pokemon.
     */
    @NonNull
    @Override
    public String toString() {
        return pokemonName + "    LV" + level;
    }

    /**
     * Set the Pokemon's master.
     * @param master a master to be set.
     */
    public void setMaster(Person master) {
        this.master = master;
    }

    /**
     * Check if the Pokemon is fainted or alive.
     * @return a boolean. If true then the Pokemon is still alive. If false then the Pokemon is fainted.
     */
    public boolean isAlive() {
        return hp != 0;
    }

    /**
     * Get the value of speed statistic of the Pokemon.
     * @return an integer which is the value of speed statistic of the Pokemon.
     */
    public int getSpeed() {
        return speed;
    }
}
