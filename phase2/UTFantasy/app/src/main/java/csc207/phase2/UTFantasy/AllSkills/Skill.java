package csc207.phase2.UTFantasy.AllSkills;

import androidx.annotation.NonNull;

import java.io.Serializable;

public abstract class  Skill implements Serializable {
  /** The maximum amount of times of the Skill could be used. */
  public int maximumPp;
  /** The power of the skill. */
  protected int power;
  /** power points of this skill */
  protected int pp;
  /** The type of the skill. */
  protected String type;
  /** The name of the skill. */
  protected String name;

  /**
   * Get the value of the power of the Skill.
   *
   * @return an integer which is the value of the power if the Skill.
   */
  public int getPower() {
    return power;
  }

  /**
   * Set the power of the Skill.
   *
   * @param power a integer which is the value of the power of the Skill.
   */
  public void setPower(int power) {
    this.power = power;
  }

  /**
   * Get the value of possible using times of the Skill.
   *
   * @return an integer which is the amount of times the Skill could be used.
   */
  public int getPp() {
    return pp;
  }

  /**
   * Set the value of possible using times of the Skills.
   *
   * @param pp the value of the amount of times the Skill could be used.
   */
  public void setPp(int pp) {
    this.pp = pp;
  }

  /**
   * Get the value of maximumPp of the Skill.
   *
   * @return an integer which is the value of maximumPp.
   */
  public int getMaximumPp() {
    return maximumPp;
  }

  /**
   * Set the maximumpp of the skill.
   * @param pp the value to be set.
   */
  public void setMaximumPp(int pp) {
    this.maximumPp = pp;
  }

  /**
   * Get the name of the Skill.
   *
   * @return a String of name of the Skill.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the Skill.
   *
   * @param name a String to be set as the name of the skill.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the type of the Skill.
   *
   * @return a String which is the type of the Skill.
   */
  public String getType() {
    return type;
  }

  /**
   * Set the type of the Skill.
   *
   * @param type a String which the type of the Skill.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * The description the Skill.
   *
   * @return a String which describes the Skill.
   */
  @NonNull
  @Override
  public String toString() {
    return name + " is a powerful move.";
  }
}
