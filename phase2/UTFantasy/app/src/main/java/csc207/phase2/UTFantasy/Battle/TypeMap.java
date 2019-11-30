package csc207.phase2.UTFantasy.Battle;

import java.util.HashMap;

public class TypeMap {
  private HashMap<type, HashMap<type, Double>> typeMap = new HashMap<>();

  public TypeMap() {
    setTypeMap();
  }

  private void setTypeMap() {
    // the outer hash map for self is type water
    HashMap<type, Double> waterMap = new HashMap<>();
    typeMap.put(type.WATER, waterMap);
    // the inner hash maps for water key
    waterMap.put(type.FIRE, 2.0);
    waterMap.put(type.NORMAL, 1.0);
    waterMap.put(type.WATER, 0.5);
    waterMap.put(type.ELECTRIC, 1.0);
    waterMap.put(type.PSYCHIC, 1.0);
    waterMap.put(type.DRAGON, 0.5);
    waterMap.put(type.FLYING, 1.0);
    waterMap.put(type.GRASS, 0.5);
    waterMap.put(type.GHOST, 1.0);
    waterMap.put(type.GROUND, 2.0);
    waterMap.put(type.ROCK, 2.0);
    waterMap.put(type.ICE, 1.0);
    waterMap.put(type.FIGHT, 1.0);
    waterMap.put(type.POISON, 1.0);
    waterMap.put(type.STEEL, 1.0);

    // the outer hash map for self is type fire
    HashMap<type, Double> fireMap = new HashMap<>();
    typeMap.put(type.FIRE, fireMap);
    // the inner hash maps for fire key
    fireMap.put(type.FIRE, 0.5);
    fireMap.put(type.NORMAL, 1.0);
    fireMap.put(type.WATER, 0.5);
    fireMap.put(type.ELECTRIC, 1.0);
    fireMap.put(type.PSYCHIC, 1.0);
    fireMap.put(type.DRAGON, 0.5);
    fireMap.put(type.FLYING, 1.0);
    fireMap.put(type.GRASS, 2.0);
    fireMap.put(type.GHOST, 1.0);
    fireMap.put(type.GROUND, 1.0);
    fireMap.put(type.ROCK, 0.5);
    fireMap.put(type.ICE, 0.5);
    fireMap.put(type.FIGHT, 1.0);
    fireMap.put(type.POISON, 1.0);
    fireMap.put(type.STEEL, 2.0);

    // the outer hash map for self is type normal
    HashMap<type, Double> normalMap = new HashMap<>();
    typeMap.put(type.NORMAL, normalMap);
    // the inner hash maps for normal key
    normalMap.put(type.FIRE, 1.0);
    normalMap.put(type.NORMAL, 1.0);
    normalMap.put(type.WATER, 1.0);
    normalMap.put(type.ELECTRIC, 1.0);
    normalMap.put(type.PSYCHIC, 1.0);
    normalMap.put(type.DRAGON, 1.0);
    normalMap.put(type.FLYING, 1.0);
    normalMap.put(type.GRASS, 1.0);
    normalMap.put(type.GHOST, 0.0);
    normalMap.put(type.GROUND, 1.0);
    normalMap.put(type.ROCK, 0.5);
    normalMap.put(type.ICE, 1.0);
    normalMap.put(type.FIGHT, 1.0);
    normalMap.put(type.POISON, 1.0);
    normalMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type electric
    HashMap<type, Double> electricMap = new HashMap<>();
    typeMap.put(type.ELECTRIC, electricMap);
    // the inner hash maps for electric key
    electricMap.put(type.FIRE, 1.0);
    electricMap.put(type.NORMAL, 1.0);
    electricMap.put(type.WATER, 2.0);
    electricMap.put(type.ELECTRIC, 0.5);
    electricMap.put(type.PSYCHIC, 1.0);
    electricMap.put(type.DRAGON, 0.5);
    electricMap.put(type.FLYING, 2.0);
    electricMap.put(type.GRASS, 0.5);
    electricMap.put(type.GHOST, 1.0);
    electricMap.put(type.GROUND, 0.0);
    electricMap.put(type.ROCK, 1.0);
    electricMap.put(type.ICE, 1.0);
    electricMap.put(type.FIGHT, 1.0);
    electricMap.put(type.POISON, 1.0);
    electricMap.put(type.STEEL, 1.0);

    // the outer hash map for self is type grass
    HashMap<type, Double> grassMap = new HashMap<>();
    typeMap.put(type.GRASS, grassMap);
    // the inner hash maps for grass key
    grassMap.put(type.WATER, 2.0);
    grassMap.put(type.FIRE, 0.5);
    grassMap.put(type.ELECTRIC, 1.0);
    grassMap.put(type.NORMAL, 1.0);
    grassMap.put(type.PSYCHIC, 1.0);
    grassMap.put(type.DRAGON, 0.5);
    grassMap.put(type.FLYING, 0.5);
    grassMap.put(type.GRASS, 0.5);
    grassMap.put(type.GHOST, 1.0);
    grassMap.put(type.GROUND, 2.0);
    grassMap.put(type.ROCK, 2.0);
    grassMap.put(type.ICE, 1.0);
    grassMap.put(type.FIGHT, 1.0);
    grassMap.put(type.POISON, 0.5);
    grassMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type psychic
    HashMap<type, Double> psychicMap = new HashMap<>();
    typeMap.put(type.PSYCHIC, psychicMap);
    // the inner hash maps for psychic key
    psychicMap.put(type.FIRE, 1.0);
    psychicMap.put(type.WATER, 1.0);
    psychicMap.put(type.ELECTRIC, 1.0);
    psychicMap.put(type.NORMAL, 1.0);
    psychicMap.put(type.PSYCHIC, 0.5);
    psychicMap.put(type.DRAGON, 1.0);
    psychicMap.put(type.FLYING, 1.0);
    psychicMap.put(type.GRASS, 1.0);
    psychicMap.put(type.GHOST, 1.0);
    psychicMap.put(type.GROUND, 1.0);
    psychicMap.put(type.ROCK, 1.0);
    psychicMap.put(type.ICE, 1.0);
    psychicMap.put(type.FIGHT, 2.0);
    psychicMap.put(type.POISON, 2.0);
    psychicMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type dragon
    HashMap<type, Double> dragonMap = new HashMap<>();
    typeMap.put(type.DRAGON, dragonMap);
    // the inner hash maps for dragon key
    dragonMap.put(type.FIRE, 1.0);
    dragonMap.put(type.WATER, 1.0);
    dragonMap.put(type.ELECTRIC, 1.0);
    dragonMap.put(type.NORMAL, 1.0);
    dragonMap.put(type.PSYCHIC, 1.0);
    dragonMap.put(type.DRAGON, 2.0);
    dragonMap.put(type.FLYING, 1.0);
    dragonMap.put(type.GRASS, 1.0);
    dragonMap.put(type.GHOST, 1.0);
    dragonMap.put(type.GROUND, 1.0);
    dragonMap.put(type.ROCK, 1.0);
    dragonMap.put(type.ICE, 1.0);
    dragonMap.put(type.FIGHT, 1.0);
    dragonMap.put(type.POISON, 1.0);
    dragonMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type flying
    HashMap<type, Double> flyingMap = new HashMap<>();
    typeMap.put(type.FLYING, flyingMap);
    // the inner hash maps for flying key
    flyingMap.put(type.FIRE, 1.0);
    flyingMap.put(type.NORMAL, 1.0);
    flyingMap.put(type.WATER, 1.0);
    flyingMap.put(type.ELECTRIC, 0.5);
    flyingMap.put(type.PSYCHIC, 1.0);
    flyingMap.put(type.DRAGON, 1.0);
    flyingMap.put(type.FLYING, 1.0);
    flyingMap.put(type.GRASS, 2.0);
    flyingMap.put(type.GHOST, 1.0);
    flyingMap.put(type.GROUND, 1.0);
    flyingMap.put(type.ROCK, 0.5);
    flyingMap.put(type.ICE, 1.0);
    flyingMap.put(type.FIGHT, 2.0);
    flyingMap.put(type.POISON, 1.0);
    flyingMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type ghost
    HashMap<type, Double> ghostMap = new HashMap<>();
    typeMap.put(type.GHOST, ghostMap);
    // the inner hash maps for ghost key
    ghostMap.put(type.FIRE, 1.0);
    ghostMap.put(type.NORMAL, 0.0);
    ghostMap.put(type.WATER, 1.0);
    ghostMap.put(type.ELECTRIC, 1.0);
    ghostMap.put(type.PSYCHIC, 2.0);
    ghostMap.put(type.DRAGON, 1.0);
    ghostMap.put(type.FLYING, 1.0);
    ghostMap.put(type.GRASS, 1.0);
    ghostMap.put(type.GHOST, 2.0);
    ghostMap.put(type.GROUND, 1.0);
    ghostMap.put(type.ROCK, 1.0);
    ghostMap.put(type.ICE, 1.0);
    ghostMap.put(type.FIGHT, 1.0);
    ghostMap.put(type.POISON, 1.0);
    ghostMap.put(type.STEEL, 1.0);

    // the outer hash map for self is type ground
    HashMap<type, Double> groundMap = new HashMap<>();
    typeMap.put(type.GROUND, groundMap);
    // the inner hash maps for ground key
    groundMap.put(type.FIRE, 2.0);
    groundMap.put(type.NORMAL, 1.0);
    groundMap.put(type.WATER, 1.0);
    groundMap.put(type.ELECTRIC, 2.0);
    groundMap.put(type.PSYCHIC, 1.0);
    groundMap.put(type.DRAGON, 1.0);
    groundMap.put(type.FLYING, 0.0);
    groundMap.put(type.GRASS, 0.5);
    groundMap.put(type.GHOST, 1.0);
    groundMap.put(type.GROUND, 1.0);
    groundMap.put(type.ROCK, 2.0);
    groundMap.put(type.ICE, 1.0);
    groundMap.put(type.FIGHT, 1.0);
    groundMap.put(type.POISON, 2.0);
    groundMap.put(type.STEEL, 2.0);

    // the outer hash map for self is type rock
    HashMap<type, Double> rockMap = new HashMap<>();
    typeMap.put(type.ROCK, rockMap);
    // the inner hash maps for rock key
    rockMap.put(type.FIRE, 2.0);
    rockMap.put(type.NORMAL, 1.0);
    rockMap.put(type.WATER, 1.0);
    rockMap.put(type.ELECTRIC, 1.0);
    rockMap.put(type.PSYCHIC, 1.0);
    rockMap.put(type.DRAGON, 1.0);
    rockMap.put(type.FLYING, 2.0);
    rockMap.put(type.GRASS, 1.0);
    rockMap.put(type.GHOST, 1.0);
    rockMap.put(type.GROUND, 0.5);
    rockMap.put(type.ROCK, 1.0);
    rockMap.put(type.ICE, 2.0);
    rockMap.put(type.FIGHT, 0.5);
    rockMap.put(type.POISON, 1.0);
    rockMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type ice
    HashMap<type, Double> iceMap = new HashMap<>();
    typeMap.put(type.ICE, iceMap);
    // the inner hash maps for ice key
    iceMap.put(type.FIRE, 0.5);
    iceMap.put(type.NORMAL, 1.0);
    iceMap.put(type.WATER, 0.5);
    iceMap.put(type.ELECTRIC, 1.0);
    iceMap.put(type.PSYCHIC, 1.0);
    iceMap.put(type.DRAGON, 2.0);
    iceMap.put(type.FLYING, 2.0);
    iceMap.put(type.GRASS, 2.0);
    iceMap.put(type.GHOST, 1.0);
    iceMap.put(type.GROUND, 2.0);
    iceMap.put(type.ROCK, 1.0);
    iceMap.put(type.ICE, 0.5);
    iceMap.put(type.FIGHT, 1.0);
    iceMap.put(type.POISON, 1.0);
    iceMap.put(type.STEEL, 0.5);

    // the outer hash map for self is type fight
    HashMap<type, Double> fightMap = new HashMap<>();
    typeMap.put(type.FIGHT, fightMap);
    // the inner hash maps for fight key
    fightMap.put(type.FIRE, 1.0);
    fightMap.put(type.NORMAL, 2.0);
    fightMap.put(type.WATER, 1.0);
    fightMap.put(type.ELECTRIC, 1.0);
    fightMap.put(type.PSYCHIC, 0.5);
    fightMap.put(type.DRAGON, 1.0);
    fightMap.put(type.FLYING, 0.5);
    fightMap.put(type.GRASS, 1.0);
    fightMap.put(type.GHOST, 1.0);
    fightMap.put(type.GROUND, 1.0);
    fightMap.put(type.ROCK, 2.0);
    fightMap.put(type.ICE, 2.0);
    fightMap.put(type.FIGHT, 1.0);
    fightMap.put(type.POISON, 0.5);
    fightMap.put(type.STEEL, 2.0);

    // the outer hash map for self is type poison
    HashMap<type, Double> poisonMap = new HashMap<>();
    typeMap.put(type.POISON, poisonMap);
    // the inner hash maps for poison key
    poisonMap.put(type.FIRE, 1.0);
    poisonMap.put(type.NORMAL, 1.0);
    poisonMap.put(type.WATER, 1.0);
    poisonMap.put(type.ELECTRIC, 1.0);
    poisonMap.put(type.PSYCHIC, 1.0);
    poisonMap.put(type.DRAGON, 1.0);
    poisonMap.put(type.FLYING, 1.0);
    poisonMap.put(type.GRASS, 2.0);
    poisonMap.put(type.GHOST, 0.5);
    poisonMap.put(type.GROUND, 0.5);
    poisonMap.put(type.ROCK, 0.5);
    poisonMap.put(type.ICE, 1.0);
    poisonMap.put(type.FIGHT, 1.0);
    poisonMap.put(type.POISON, 0.5);
    poisonMap.put(type.STEEL, 0.0);

    // the outer hash map for self is type steel
    HashMap<type, Double> steelMap = new HashMap<>();
    typeMap.put(type.STEEL, steelMap);
    // the inner hash maps for steel key
    steelMap.put(type.FIRE, 0.5);
    steelMap.put(type.NORMAL, 1.0);
    steelMap.put(type.WATER, 0.5);
    steelMap.put(type.ELECTRIC, 0.5);
    steelMap.put(type.PSYCHIC, 1.0);
    steelMap.put(type.DRAGON, 1.0);
    steelMap.put(type.FLYING, 1.0);
    steelMap.put(type.GRASS, 1.0);
    steelMap.put(type.GHOST, 1.0);
    steelMap.put(type.GROUND, 1.0);
    steelMap.put(type.ROCK, 2.0);
    steelMap.put(type.ICE, 2.0);
    steelMap.put(type.FIGHT, 1.0);
    steelMap.put(type.POISON, 1.0);
    steelMap.put(type.STEEL, 0.5);
  }

  public double getTypeIndex(type attackType, type defenseType) {
    if (typeMap.containsKey(attackType) && typeMap.get(attackType).containsKey(defenseType)) {
      return typeMap.get(attackType).get(defenseType);
    } else {
      return 1.0;
    }
  }

  public enum type {
    FIRE,
    WATER,
    ELECTRIC,
    NORMAL,
    PSYCHIC,
    DRAGON,
    FLYING,
    GRASS,
    GHOST,
    GROUND,
    ROCK,
    ICE,
    FIGHT,
    POISON,
    STEEL;
  }
}
