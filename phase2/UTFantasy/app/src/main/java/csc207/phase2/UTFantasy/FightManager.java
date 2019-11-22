package csc207.phase2.UTFantasy;

import java.util.HashMap;
import java.util.Random;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Interface.Fighter;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class FightManager {
//
//  /**
//   * A HashMap which is the type matchup chart, reflects the effectiveness that different types has
//   * against each others.
//   */
//  private static HashMap<String, HashMap<String, Float>> typeMap = new HashMap<>();
//  /** The player which involves in fight. */
//  private Player player;
//  /** Player's Pokemon used in fight. */
//  private Pokemon playerPokemon;
//  /** Player's opponent which is a NPC. */
//  private NPC opponent;
//  /** Opponent NPC's Pokemon used in the fight. */
//  private Pokemon opponentPokemon;
//  /** Boolean which reflects is the Pokemon fainted. */
//  private boolean fainted;
//  /** String which describes either opponent NPC's or player's Pokemon is fainted. */
//  private String faintedSide;
//  /** Boolean which reflects that is the battle continuable. */
//  private boolean continuable = true;
//  /** String which describes either Player or Opponent can use a move first. */
//  private String priority;
//  /**
//   * An integer which reflects the progress of a fight. Different integer means the battle is in
//   * different situation. Default value is -1.
//   */
//  private int progress = -1;
//  /** The Skill that will be used by Player's Pokemon. */
//  private Skill skill;
//  /** The Skill that will be used by opponent NPC. */
//  private Skill rivalSkill;
//
//  /**
//   * Constructor of FightManager
//   *
//   * @param player The player involves in this battle.
//   * @param npc The opponent NPC involves in this battle.
//   */
//  public FightManager(Player player, NPC npc) {
//    this.player = player;
//    playerPokemon = player.getPokemonList().get(0);
//    this.opponent = npc;
//    opponentPokemon = opponent.getPokemonList().get(0);
//    determineTurn();
//    setTypeMap();
//  }
//
//  /**
//   * Get the skill of the Pokemon
//   *
//   * @return the Skill that user Pokemon will be used.
//   */
//  public Skill getSkill() {
//    return skill;
//  }
//
//  /**
//   * Set the Skill of user's Pokemon
//   *
//   * @param skill the Skill to be set.
//   */
//  public void setSkill(Skill skill) {
//    this.skill = skill;
//  }
//
//  /** Set a type matchup chart. */
//  private void setTypeMap() {
//    // the outer hash map for self is type water
//    HashMap<String, Float> waterMap = new HashMap<String, Float>();
//    typeMap.put("water", waterMap);
//    // the inner hash maps for water key
//    waterMap.put("fire", (float) 2);
//    waterMap.put("normal", (float) 1);
//    waterMap.put("water", (float) 0.5);
//    waterMap.put("electric", (float) 1);
//
//    // the outer hash map for self is type fire
//    HashMap<String, Float> fireMap = new HashMap<String, Float>();
//    typeMap.put("fire", fireMap);
//    // the inner hash maps for fire key
//    fireMap.put("fire", (float) 0.5);
//    fireMap.put("normal", (float) 1);
//    fireMap.put("water", (float) 0.5);
//    fireMap.put("electric", (float) 1);
//
//    // the outer hash map for self is type normal
//    HashMap<String, Float> normalMap = new HashMap<String, Float>();
//    typeMap.put("normal", normalMap);
//    // the inner hash maps for water key
//    normalMap.put("fire", (float) 1);
//    normalMap.put("normal", (float) 1);
//    normalMap.put("water", (float) 1);
//    normalMap.put("electric", (float) 1);
//
//    // the outer hash map for self is type electric
//    HashMap<String, Float> electricMap = new HashMap<String, Float>();
//    typeMap.put("electric", electricMap);
//    // the inner hash maps for water key
//    electricMap.put("fire", (float) 1);
//    electricMap.put("normal", (float) 1);
//    electricMap.put("water", (float) 2);
//    electricMap.put("electric", (float) 0.5);
//  }
//
//  /** Decide either user's or NPC's Pokemon will move first. */
//  public void determineTurn() {
//    if (playerPokemon.getSpeed() > opponentPokemon.getSpeed()) {
//      priority = "player";
//    } else if (opponentPokemon.getSpeed() > playerPokemon.getSpeed()) {
//      priority = "opponent";
//    } else {
//      double r = Math.random();
//      if (r >= 0.5) {
//        priority = "player";
//      } else {
//        priority = "opponent";
//      }
//    }
//  }
//
//  /**
//   * Get user's Pokemon.
//   *
//   * @return the Pokemon user will used in the battle.
//   */
//  public Pokemon getPlayerPokemon() {
//    return playerPokemon;
//  }
//
//  public void setPlayerPokemon(Pokemon playerPokemon) {
//    this.playerPokemon = playerPokemon;
//  }
//
//  /**
//   * Get NPC's Pokemon.
//   *
//   * @return the Pokemon NPC will used in the battle.
//   */
//  public Pokemon getRivalPokemon() {
//    return opponentPokemon;
//  }
//
//  /**
//   * Calculate the damage caused by the move used by a Pokemon.
//   *
//   * @param pokemon the Pokemon which is attacking and made the move.
//   * @param rival the Pokemon which is defending the move.
//   * @param skill the Skill that the attacking Pokemon used.
//   * @return a float which is the certain amount of damage on the defending Pokemon.
//   */
//  private int calculateDMG(Pokemon pokemon, Pokemon rival, Skill skill) {
//    // calculate damage without modifier
//    double damage = (2 * pokemon.getLevel()) / 5 + 2;
//    damage = damage * pokemon.getAttack() / rival.getDefense();
//    damage = ((damage * skill.getPower()) / 50) + 2;
//
//    // calculate the modifier
//    double random = Math.random() * (1 - 0.85) + 0.85;
//    double r = Math.random();
//    double rate = 1;
//    if (r < 0.03125) {
//      rate = 1.5;
//    }
//    float type = checkType(skill, rival);
//    float stab = 1;
//    if (skill.getType().equals(pokemon.getType())) {
//      stab = (float) 1.5;
//    }
//    double modifier = random * rate * type * stab;
//
//    return (int) Math.floor(modifier * damage);
//  }
//
//  /**
//   * Get the boolean reflects whether there is a Pokemon fainted after a Skill used.
//   *
//   * @return A boolean reflects whether there is a fainted Pokemon.
//   */
//  public boolean getFainted() {
//    return fainted;
//  }
//
//  /**
//   * Get whether the battle is still continuable, which means the user and opponent both has at
//   * least one Pokemon that is not fainted.
//   *
//   * @return A boolean whether the battle is continuable.
//   */
//  public boolean getContinuable() {
//    return continuable;
//  }
//
//  /**
//   * Get the progress integer of this battle.
//   *
//   * @return An integer which reflects the stage of progress of a fight.
//   */
//  public int getProgress() {
//    return progress;
//  }
//
//  /**
//   * Set the progress integer of this battle.
//   *
//   * @param progress the integer to be set.
//   */
//  public void setProgress(int progress) {
//    this.progress = progress;
//  }
//
//  /**
//   * @param skill the Skill used by attacking Pokemon.
//   * @param rival the opponent Pokemon.
//   * @return a float which is a modifier of type matchups.
//   */
//  private float checkType(Skill skill, Pokemon rival) {
//    float typeIndex = 1;
//    if (typeMap.containsKey(skill.getType())
//        && typeMap.get(skill.getType()).containsKey(rival.getType())) {
//      typeIndex = typeMap.get(skill.getType()).get(rival.getType());
//    }
//    return typeIndex;
//  }
//
//  /** Decide a Skill to be used by opponent NPC. */
//  public void setRivalSkill() {
//    Skill result = null;
//    while (result == null) {
//      result = opponentPokemon.getSkills()[(new Random().nextInt(opponentPokemon.getSkillNum()))];
//    }
//    this.rivalSkill = result;
//  }
//
//  /**
//   * Determine whether the battle is continuable by checking if a fighter has not fainted Pokemon.
//   *
//   * @param p the fighter(either a user or NPC) to be checked.
//   * @return A boolean reflects whether the fight is continuable.
//   */
//  private boolean determineContinue(Fighter p) {
//    for (Pokemon pokemon : p.getPokemonList()) {
//      if (pokemon.isAlive()) {
//        return true;
//      }
//    }
//    return false;
//  }
//
//  /**
//   * Update battle progress with different cases.
//   *
//   * @param progress the progress integer reflects battle situations.
//   * @return Information in a fight. Such as battle result, Pokemon fainted etc.
//   */
//  public String updateInfo(int progress) {
//    String text;
//    switch (progress) {
//      case 0:
//        text = "What do you wanna do right now?";
//        setProgress(1);
//        return text;
//
//      case 1:
//        // informing the skill of first attack
//        determineTurn();
//        if (priority.equals("player")) {
//          text = playerPokemon.getPokemonName() + " uses " + skill.getName();
//        } else {
//          text = opponentPokemon.getPokemonName() + " uses " + rivalSkill.getName();
//        }
//        setProgress(2);
//        return text;
//
//      case 2:
//        // showing the effect of first attack
//        if (priority.equals("player")) {
//          text = updateSkillInfo(playerPokemon, opponentPokemon, skill);
//          if (fainted) {
//            continuable = determineContinue(opponent);
//            faintedSide = "opponent";
//          }
//        } else {
//          text = updateSkillInfo(opponentPokemon, playerPokemon, rivalSkill);
//          if (fainted) {
//            continuable = determineContinue(player);
//            faintedSide = "player";
//          }
//        }
//        setProgress(3);
//        return text;
//
//      case 3:
//        // informing the skill of second attack or informing fainted pokemon if there is such one
//        if (!fainted) {
//          // not fainted
//          if (priority.equals("opponent")) {
//            text = playerPokemon.getPokemonName() + " used " + skill.getName();
//          } else {
//            text = opponentPokemon.getPokemonName() + " used " + rivalSkill.getName();
//          }
//          setProgress(4);
//        } else {
//          // fainted
//          if (faintedSide.equals("opponent")) {
//            text = opponentPokemon.getPokemonName() + " fainted.";
//            setProgress(4);
//          } else {
//            text = playerPokemon.getPokemonName() + " fainted.";
//            setProgress(0);
//          }
//        }
//        return text;
//
//      case 4:
//        // effect of second attack or informing if opponent chose next pokemon or if the battle is
//        // end
//        if (!fainted) {
//          // not fainted
//          if (priority.equals("opponent")) {
//            text = updateSkillInfo(playerPokemon, opponentPokemon, skill);
//            if (fainted) {
//              continuable = determineContinue(opponent);
//              faintedSide = "opponent";
//            }
//          } else {
//            text = updateSkillInfo(opponentPokemon, playerPokemon, rivalSkill);
//            if (fainted) {
//              continuable = determineContinue(player);
//              faintedSide = "player";
//            }
//          }
//          // check if the pokemon fainted after second attack
//          if (fainted) {
//            setProgress(5);
//          } else {
//            setProgress(0);
//          }
//        } else {
//          // one pokemon fainted during first attack
//          if (continuable) {
//            if (faintedSide.equals("opponent")) {
//              // opponent fainted && continuable
//              for (Pokemon pokemon : opponent.getPokemonList()) {
//                if (pokemon.isAlive()) {
//                  opponentPokemon = pokemon;
//                }
//              }
//              assert opponentPokemon != null;
//              setProgress(7);
//              text = updateInfo(7);
//            } else {
//              // player fainted && continuable
//              text = updateInfo(0);
//              setProgress(0);
//            }
//          } else {
//            // non continuable
//            if (faintedSide.equals("opponent")) {
//              text = "You win the battle!!";
//            } else {
//              text = "You lost...";
//            }
//            setProgress(-1);
//          }
//        }
//        return text;
//
//      case 5:
//        // there is progress == 5 iff the pokemon didn't faint during first attack
//        // and the pokemon after second attack is fainted
//        // used to inform the pokemon that faint
//        if (faintedSide.equals("opponent")) {
//          text = opponentPokemon.getPokemonName() + " fainted.";
//        } else {
//          text = playerPokemon.getPokemonName() + " fainted.";
//        }
//        setProgress(6);
//        return text;
//
//      case 6:
//        // there is progress == 6 iff the pokemon didn't faint during first attack
//        // and the pokemon after second attack is fainted
//        // used to exchange the pokemon or end the fight
//        text = updateInfo(4);
//        if (player.isFightAble() && opponent.isFightAble()) {
//          setProgress(0);
//        } else {
//          setProgress(-1);
//        }
//        return text;
//
//      case 7:
//        reset();
//        text = opponent.getName() + " send out " + opponentPokemon.getPokemonName();
//        setProgress(0);
//        return text;
//    }
//    return "Back...";
//  }
//
//  /**
//   * update p1 used skill on p2
//   *
//   * @param attackPokemon pokemon who used the skill
//   * @param damagedPokemon pokemon who are attacked
//   * @param skill the skill got used
//   */
//  private String updateSkillInfo(Pokemon attackPokemon, Pokemon damagedPokemon, Skill skill) {
//
//    // update the damage
//    int dmg = calculateDMG(attackPokemon, damagedPokemon, skill);
//    damagedPokemon.setHp(damagedPokemon.getHp() - dmg);
//    if (damagedPokemon.getHp() <= 0) {
//      damagedPokemon.setHp(0);
//      fainted = true;
//    }
//
//    float typeIndex = checkType(skill, damagedPokemon);
//    if (typeIndex > 1) {
//      return ("It is super effective!");
//    } else if (typeIndex == 1) {
//      return ("Nice shot.");
//    } else {
//      return ("It is not very effective...");
//    }
//  }
//
//  /**
//   * Change the current pokemon to a new pokemon.
//   *
//   * @param pokemon new pokemon instance.
//   */
//  public void changeCurrentPokemon(Pokemon pokemon) {
//    if (pokemon != null && playerPokemon != pokemon && pokemon.getHp() != 0) {
//      playerPokemon = pokemon;
//      // todo: end your round.
//    }
//  }
//
//  /** reset fainted and continuable of this round */
//  public void reset() {
//    fainted = false;
//    continuable = true;
//  }
}
