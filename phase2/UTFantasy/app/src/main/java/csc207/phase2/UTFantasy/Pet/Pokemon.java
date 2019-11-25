package csc207.phase2.UTFantasy.Pet;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Random;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Character.Person;

public abstract class Pokemon implements Serializable {
  /** the name of the Pokemon */
  protected String pokemonName;
  /** The first type of this pokemon */
  protected String type1;
  /** The second type of this pokemon */
  protected String type2;
  /** Level growing type */
  protected String growType;
  /** The unique profile id for each Pokemon. ID can be used to draw this Pokemon. */
  protected int profileID;
  /** Base stat of hp */
  protected int baseHp;
  /** Base stat of attack */
  protected int baseAttack;
  /** Base stat of defense */
  protected int baseDefense;
  /** Base stat of speed */
  protected int baseSpeed;
  /** level of the Pokemon */
  protected int level;
  /** the value of level when the Pokemon will be able to evolve */
  protected int levelToEvolve;
  /** total experience points the pokemon has */
  protected int totalExp;
  /** the value of experience the Pokemon has at the current level */
  protected int expAtCurrentLevel;
  /** the value of experience the Pokemon needs to level up */
  protected int expToLevelUp;
  /** person that the Pokemon belongs to */
  protected Person master;
  /** the health point of the Pokemon */
  protected int hp;
  /** the attack of this pokemon */
  protected int attack;
  /** the defense of this pokemon */
  protected int defense;
  /** the speed of this pokemon */
  protected int speed;
  /** Individual value of hp */
  protected int ivHp;
  /** Individual value of attack */
  protected int ivAttack;
  /** Individual value of defense */
  protected int ivDefense;
  /** Individual value of speed */
  protected int ivSpeed;
  /** Maximum health point */
  protected int maximumHp;
  /** skills the Pokemon have there are four different skills */
  protected Skill[] skills;

  /** Constructor of Pokemon. */
  Pokemon() {
    level = 1;
    totalExp = 0;
    skills = new Skill[4];
    Random r = new Random();
    ivHp = r.nextInt(32);
    ivAttack = r.nextInt(32);
    ivDefense = r.nextInt(32);
    ivSpeed = r.nextInt(32);
  }

  /**
   * Get the name of the Pokemon.
   *
   * @return a String which is the Pokemon's name.
   */
  public String getPokemonName() {
    return pokemonName;
  }

  /**
   * Set Pokemon's name.
   *
   * @param pokemonName the name of Pokemon to set.
   */
  public void setPokemonName(String pokemonName) {
    this.pokemonName = pokemonName;
  }

  /**
   * Get the type1 of the Pokemon.
   *
   * @return a String which is the type1 of the Pokemon.
   */
  public String getType1() {
    return type1;
  }

  /**
   * Set the type1 of the Pokemon.
   *
   * @param type1 a String which is the type of Pokemon to set.
   */
  public void setType1(String type1) {
    this.type1 = type1;
  }

  /**
   * Get the type2 of the Pokemon.
   *
   * @return a String which is the type2 of the Pokemon.
   */
  public String getType2() {
    return type2;
  }

  /**
   * Set the type2 of the Pokemon.
   *
   * @param type2 a String which is the type of Pokemon to set.
   */
  public void setType2(String type2) {
      this.type2 = type2;
  }

  /**
   * Get the grow type of this Pokemon.
   *
   * @return a String represents the grow type of this Pokemon.
   */
  public String getGrowType() {
    return growType;
  }

  /**
   * Set the grow type of this Pokemon.
   *
   * @param growType a String represents the grow type of this Pokemon to be set.
   */
  public void setGrowType(String growType) {
    this.growType = growType;
  }

  /**
   * Get the profile ID of the Pokemon.
   *
   * @return a integer which is the profile ID of the Pokemon.
   */
  public int getProfileID() {
    return profileID;
  }

  /**
   * Set the profile ID for thr pokemon.
   *
   * @param profileID the profile ID to be set.
   */
  public void setProfileID(int profileID) {
    this.profileID = profileID;
  }

  /**
   * Get the the value of base health point of the Pokemon.
   *
   * @return an integer represents the base health point of the Pokemon.
   */
  public int getBaseHp() {
    return baseHp;
  }

  /**
   * Set the value of base health point of the Pokemon.
   *
   * @param baseHp the value to be set as the base health point of the Pokemon.
   */
  public void setBaseHp(int baseHp) {
    this.baseHp = baseHp;
  }

  /**
   * Get the value of base attack of the Pokemon.
   *
   * @return an integer represents the base attack of the Pokemon
   */
  public int getBaseAttack() {
    return baseAttack;
  }

  /**
   * Set the value of base attack of the Pokemon.
   *
   * @param baseAttack the value to be set as the base attack of the Pokemon
   */
  public void setBaseAttack(int baseAttack) {
    this.baseAttack = baseAttack;
  }

  /**
   * Get the value of base defense of the Pokemon.
   *
   * @return an integer represents the base defense of the Pokemon.
   */
  public int getBaseDefense() {
    return baseDefense;
  }

  /**
   * Set the value of base defense of the Pokemon.
   *
   * @param baseDefense the value to be set as the base defense of the Pokemon.
   */
  public void setBaseDefense(int baseDefense) {
    this.baseDefense = baseDefense;
  }

  /**
   * Get the value of base speed of the Pokemon.
   *
   * @return an integer represents the base speed of the Pokemon.
   */
  public int getBaseSpeed() {
    return baseSpeed;
  }

  /**
   * Set the value of base speed of the Pokemon.
   *
   * @param baseSpeed the value to be set as the base speed of the Pokemon.
   */
  public void setBaseSpeed(int baseSpeed) {
    this.baseSpeed = baseSpeed;
  }

  /**
   * Get the value of Pokemon's current level.
   *
   * @return the value of level of the Pokemon.
   */
  public int getLevel() {
    return level;
  }

  /**
   * Set Pokemon's current value.
   *
   * @param level the value of level to set.
   */
  public void setLevel(int level) {
    this.level = level;
    setAttack(calculateStatistic("attack"));
    setDefense(calculateStatistic("defense"));
    setSpeed(calculateStatistic("speed"));
    setHp(calculateStatistic("hp"));
  }

  /**
   * Get the the value of level needed for this Pokemon to evolve.
   *
   * @return the value of level needed for this Pokemon to evolve.
   */
  public int getLevelToEvolve() {
    return levelToEvolve;
  }

  /**
   * Set the value of level to evolve.
   *
   * @param levelToEvolve the value of level needed for this Pokemon to evolve.
   */
  public void setLevelToEvolve(int levelToEvolve) {
    this.levelToEvolve = levelToEvolve;
  }

  /**
   * Get the value of Pokemon's current experience point.
   *
   * @return an integer which is the value of Pokemon's experience point.
   */
  public int getTotalExp() {
    return totalExp;
  }

  /**
   * Set the experience point of the Pokemon.
   *
   * @param exp the value of experience point to set.
   */
  public void setTotalExp(int exp) {
    this.totalExp = exp;
  }

  /**
   * Add the amount of experience point to this Pokemon.
   *
   * @param exp the value of experience to be added.
   */
  public void addExp(int exp) {
    if (this.getLevel() < 100) {
      this.totalExp += exp;
    }
  }

  /**
   * Get the value of experience point this Pokemon currently has at the current level.
   *
   * @return the value of experience point Pokemon currently has.
   */
  public int getExpAtCurrentLevel() {
    return expAtCurrentLevel;
  }

  /**
   * Set the value of experience point this Pokemon currently has at the current level.
   *
   * @param exp the value of experience point to be set.
   */
  public void setExpAtCurrentLevel(int exp) {
    this.expAtCurrentLevel = exp;
  }

  /**
   * Get the amount of experience point this Pokemon needs to level up.
   *
   * @return the value of exp needs to level up.
   */
  public int getExpToLevelUp() {
    return expToLevelUp;
  }

  /**
   * Set the value of experience for this Pokemon to level up.
   *
   * @param exp the value of experience to be set.
   */
  public void setExpToLevelUp(int exp) {
    this.expToLevelUp = exp;
  }

  /**
   * Get the master of the Pokemon.
   *
   * @return a Person which is the master of the Pokemon.
   */
  public Person getMaster() {
    return master;
  }

  /**
   * Set the Pokemon's master.
   *
   * @param master a master to be set.
   */
  public void setMaster(Person master) {
    this.master = master;
  }

  /**
   * Get the current health point of the Pokemon.
   *
   * @return a integer which is the value of current health point.
   */
  public int getHp() {
    return hp;
  }

  /**
   * Set the hp of the Pokemon.
   *
   * @param hp the value of health point to set.
   */
  public void setHp(int hp) {
    this.hp = hp;
  }

  /**
   * Get the value of Pokemon's attack statistic.
   *
   * @return an integer which is the value of Pokemon's attack statistic.
   */
  public int getAttack() {
    return attack;
  }

  /**
   * Set the attack statistic of the Pokemon.
   *
   * @param attack the value of attack to set.
   */
  public void setAttack(int attack) {
    this.attack = attack;
  }

  /**
   * Get the value of Pokemon's defense statistic.
   *
   * @return an integer which is the value of Pokemon's defense statistic.
   */
  public int getDefense() {
    return defense;
  }

  /**
   * Set the defense statistic of the Pokemon.
   *
   * @param defense the value of defense to set.
   */
  void setDefense(int defense) {
    this.defense = defense;
  }

  /**
   * Get the value of speed statistic of the Pokemon.
   *
   * @return an integer which is the value of speed statistic of the Pokemon.
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Set the speed statistic of the Pokemon.
   *
   * @param speed the value of speed to set.
   */
  void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Get the individual value of health point of the Pokemon.
   *
   * @return the value of individual value of health point of the Pokemon.
   */
  public int getIvHp() {
    return ivHp;
  }

  /**
   * Set the individual value of health point of the Pokemon.
   *
   * @param hp the value of individual value of health point to set.
   */
  public void setIvHp(int hp) {
    this.ivHp = hp;
  }

  /**
   * Get the individual value of attack of the Pokemon.
   *
   * @return the value of individual value of attack of the Pokemon.
   */
  public int getIvAttack() {
    return ivAttack;
  }

  /**
   * Set the individual value of attack of the Pokemon.
   *
   * @param ivAttack the value to be set as the individual value of attack of the Pokemon.
   */
  public void setIvAttack(int ivAttack) {
    this.ivAttack = ivAttack;
  }

  /**
   * Get the individual value of defense of the Pokemon.
   *
   * @return the value of individual value of defense of the Pokemon.
   */
  public int getIvDefense() {
    return ivDefense;
  }

  /**
   * Set the individual value of attack of the Pokemon.
   *
   * @param ivDefense the value to be set as the individual value of attack of the Pokemon.
   */
  public void setIvDefense(int ivDefense) {
    this.ivDefense = ivDefense;
  }

  /**
   * Get the individual value of speed of the Pokemon.
   *
   * @return the value of individual value of speed of the Pokemon.
   */
  public int getIvSpeed() {
    return ivSpeed;
  }

  /**
   * Set the individual value of attack of the Pokemon.
   *
   * @param ivSpeed the value to be set as the individual value of attack of the Pokemon.
   */
  public void setIvSpeed(int ivSpeed) {
    this.ivSpeed = ivSpeed;
  }

  /**
   * Get the maximum health point of the Pokemon.
   *
   * @return the value of the maximum health point.
   */
  public int getMaximumHp() {
    return maximumHp;
  }

  /**
   * Set the value of Pokemon's maximum health point.
   *
   * @param maximumHp the value of maximum health point to set.
   */
  public void setMaximumHp(int maximumHp) {
    this.maximumHp = maximumHp;
  }

  /**
   * Get the skills which the Pokemon currently has.
   *
   * @return an arrayList of current skills.
   */
  public Skill[] getSkills() {
    return skills;
  }




  /**
   * Get if the Pokemon has a Master or not.
   *
   * @return a boolean represent the Pokemon has Master or not.
   */
  public boolean hasMaster() {
    return this.master == null;
  }

  /**
   * calculate the value of a statType of a pokemon.
   *
   * @param statType the type of statistic of pokemon will calculate.
   * @return the value of responding statistic.
   */
  public int calculateStatistic(String statType) {
    switch (statType) {
      case "attack":
      {
        float base = ((baseAttack + ivAttack) * 2 * level) / 100;
        return (int) Math.floor(base) + 5;
      }
      case "defense":
      {
        float base = ((baseDefense + ivDefense) * 2 * level) / 100;
        return (int) Math.floor(base) + 5;
      }
      case "speed":
      {
        float base = ((baseSpeed + ivSpeed) * 2 * level) / 100;
        return (int) Math.floor(base) + 5;
      }
      case "hp":
      {
        float base = ((baseHp + ivHp) * 2 * level) / 100;
        hp = (int) Math.floor(base) + level + 10;
        setMaximumHp(hp);
        return hp;
      }
      default:
        return 0;
    }
  }

  /**
   * Calculate the value of experience point this Pokemon currently has at current level.
   *
   * @return the value of experience point pokemon currently has.
   */
  public int calculateExpAtCurrentLevel() {
    int exp = this.getTotalExp();
    int level = this.getLevel();
    double modifier = 1;
    if (this.getGrowType().equals("slow")) {
      modifier = 1.25;
    }
    double thisLevelTotalExp = Math.pow(level, 3) * modifier;
    return (int) Math.floor(exp - thisLevelTotalExp);
  }


  /**
   * Calculate the value of experience point needed for this pokemon to level up.
   *
   * @return the value of experience point needed for this pokemon to level up.
   */
  public int calculateExpToLevelUp() {
    int thisLevel = this.getLevel();
    double modifier = 1;
    double thisLevelToTalExp = Math.pow(thisLevel, 3);
    double nextLevelToTalExp = Math.pow((thisLevel + 1), 3);
    if (this.getGrowType().equals("slow")) {
      modifier = 1.25;
    }
    double expDistinct = nextLevelToTalExp - thisLevelToTalExp;
    return (int) Math.floor(modifier * expDistinct);
  }

  /**
   * Replace the removeSkill with addSkill in the Pokemon's skill list.
   *
   * @param addSkill the Skill to be added in Pokemon's skill list.
   * @param removeSkill the Skill to be replaced in Pokemon's skill list.
   */
  public void updateSkills(Skill addSkill, Skill removeSkill) {
    for (int i = 0; i < 4; i++) {
      if (skills[i] == removeSkill) {
        skills[i] = addSkill;
        break;
      }
    }
  }

  /**
   * Get the number of Skills the Pokemon has.
   *
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
   *
   * @return a String of description of the Pokemon.
   */
  @NonNull
  @Override
  public String toString() {
    return pokemonName + "    LV" + level;
  }

  /**
   * Check if the Pokemon is fainted or alive.
   *
   * @return a boolean. If true then the Pokemon is still alive. If false then the Pokemon is
   *     fainted.
   */
  public boolean isAlive() {
    return hp != 0;
  }
}
