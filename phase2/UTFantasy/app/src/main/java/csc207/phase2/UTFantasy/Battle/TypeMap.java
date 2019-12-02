package csc207.phase2.UTFantasy.Battle;

import java.util.HashMap;

/**
 * the entity that stores data about the type index of skill usage
 * damage of skill usage is affected by type index
 */
public class TypeMap {
  private HashMap<TypeEnum, HashMap<TypeEnum, Double>> typeMap = new HashMap<>();

  public TypeMap() {
    setTypeMap();
  }

  private void setTypeMap() {
    // the outer hash map for self is type water
    HashMap<TypeEnum, Double> waterMap = new HashMap<>();
    typeMap.put(TypeEnum.WATER, waterMap);
    // the inner hash maps for water key
    waterMap.put(TypeEnum.FIRE, 2.0);
    waterMap.put(TypeEnum.NORMAL, 1.0);
    waterMap.put(TypeEnum.WATER, 0.5);
    waterMap.put(TypeEnum.ELECTRIC, 1.0);
    waterMap.put(TypeEnum.PSYCHIC, 1.0);
    waterMap.put(TypeEnum.DRAGON, 0.5);
    waterMap.put(TypeEnum.FLYING, 1.0);
    waterMap.put(TypeEnum.GRASS, 0.5);
    waterMap.put(TypeEnum.GHOST, 1.0);
    waterMap.put(TypeEnum.GROUND, 2.0);
    waterMap.put(TypeEnum.ROCK, 2.0);
    waterMap.put(TypeEnum.ICE, 1.0);
    waterMap.put(TypeEnum.FIGHT, 1.0);
    waterMap.put(TypeEnum.POISON, 1.0);
    waterMap.put(TypeEnum.STEEL, 1.0);

    // the outer hash map for self is type fire
    HashMap<TypeEnum, Double> fireMap = new HashMap<>();
    typeMap.put(TypeEnum.FIRE, fireMap);
    // the inner hash maps for fire key
    fireMap.put(TypeEnum.FIRE, 0.5);
    fireMap.put(TypeEnum.NORMAL, 1.0);
    fireMap.put(TypeEnum.WATER, 0.5);
    fireMap.put(TypeEnum.ELECTRIC, 1.0);
    fireMap.put(TypeEnum.PSYCHIC, 1.0);
    fireMap.put(TypeEnum.DRAGON, 0.5);
    fireMap.put(TypeEnum.FLYING, 1.0);
    fireMap.put(TypeEnum.GRASS, 2.0);
    fireMap.put(TypeEnum.GHOST, 1.0);
    fireMap.put(TypeEnum.GROUND, 1.0);
    fireMap.put(TypeEnum.ROCK, 0.5);
    fireMap.put(TypeEnum.ICE, 0.5);
    fireMap.put(TypeEnum.FIGHT, 1.0);
    fireMap.put(TypeEnum.POISON, 1.0);
    fireMap.put(TypeEnum.STEEL, 2.0);

    // the outer hash map for self is type normal
    HashMap<TypeEnum, Double> normalMap = new HashMap<>();
    typeMap.put(TypeEnum.NORMAL, normalMap);
    // the inner hash maps for normal key
    normalMap.put(TypeEnum.FIRE, 1.0);
    normalMap.put(TypeEnum.NORMAL, 1.0);
    normalMap.put(TypeEnum.WATER, 1.0);
    normalMap.put(TypeEnum.ELECTRIC, 1.0);
    normalMap.put(TypeEnum.PSYCHIC, 1.0);
    normalMap.put(TypeEnum.DRAGON, 1.0);
    normalMap.put(TypeEnum.FLYING, 1.0);
    normalMap.put(TypeEnum.GRASS, 1.0);
    normalMap.put(TypeEnum.GHOST, 0.0);
    normalMap.put(TypeEnum.GROUND, 1.0);
    normalMap.put(TypeEnum.ROCK, 0.5);
    normalMap.put(TypeEnum.ICE, 1.0);
    normalMap.put(TypeEnum.FIGHT, 1.0);
    normalMap.put(TypeEnum.POISON, 1.0);
    normalMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type electric
    HashMap<TypeEnum, Double> electricMap = new HashMap<>();
    typeMap.put(TypeEnum.ELECTRIC, electricMap);
    // the inner hash maps for electric key
    electricMap.put(TypeEnum.FIRE, 1.0);
    electricMap.put(TypeEnum.NORMAL, 1.0);
    electricMap.put(TypeEnum.WATER, 2.0);
    electricMap.put(TypeEnum.ELECTRIC, 0.5);
    electricMap.put(TypeEnum.PSYCHIC, 1.0);
    electricMap.put(TypeEnum.DRAGON, 0.5);
    electricMap.put(TypeEnum.FLYING, 2.0);
    electricMap.put(TypeEnum.GRASS, 0.5);
    electricMap.put(TypeEnum.GHOST, 1.0);
    electricMap.put(TypeEnum.GROUND, 0.0);
    electricMap.put(TypeEnum.ROCK, 1.0);
    electricMap.put(TypeEnum.ICE, 1.0);
    electricMap.put(TypeEnum.FIGHT, 1.0);
    electricMap.put(TypeEnum.POISON, 1.0);
    electricMap.put(TypeEnum.STEEL, 1.0);

    // the outer hash map for self is type grass
    HashMap<TypeEnum, Double> grassMap = new HashMap<>();
    typeMap.put(TypeEnum.GRASS, grassMap);
    // the inner hash maps for grass key
    grassMap.put(TypeEnum.WATER, 2.0);
    grassMap.put(TypeEnum.FIRE, 0.5);
    grassMap.put(TypeEnum.ELECTRIC, 1.0);
    grassMap.put(TypeEnum.NORMAL, 1.0);
    grassMap.put(TypeEnum.PSYCHIC, 1.0);
    grassMap.put(TypeEnum.DRAGON, 0.5);
    grassMap.put(TypeEnum.FLYING, 0.5);
    grassMap.put(TypeEnum.GRASS, 0.5);
    grassMap.put(TypeEnum.GHOST, 1.0);
    grassMap.put(TypeEnum.GROUND, 2.0);
    grassMap.put(TypeEnum.ROCK, 2.0);
    grassMap.put(TypeEnum.ICE, 1.0);
    grassMap.put(TypeEnum.FIGHT, 1.0);
    grassMap.put(TypeEnum.POISON, 0.5);
    grassMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type psychic
    HashMap<TypeEnum, Double> psychicMap = new HashMap<>();
    typeMap.put(TypeEnum.PSYCHIC, psychicMap);
    // the inner hash maps for psychic key
    psychicMap.put(TypeEnum.FIRE, 1.0);
    psychicMap.put(TypeEnum.WATER, 1.0);
    psychicMap.put(TypeEnum.ELECTRIC, 1.0);
    psychicMap.put(TypeEnum.NORMAL, 1.0);
    psychicMap.put(TypeEnum.PSYCHIC, 0.5);
    psychicMap.put(TypeEnum.DRAGON, 1.0);
    psychicMap.put(TypeEnum.FLYING, 1.0);
    psychicMap.put(TypeEnum.GRASS, 1.0);
    psychicMap.put(TypeEnum.GHOST, 1.0);
    psychicMap.put(TypeEnum.GROUND, 1.0);
    psychicMap.put(TypeEnum.ROCK, 1.0);
    psychicMap.put(TypeEnum.ICE, 1.0);
    psychicMap.put(TypeEnum.FIGHT, 2.0);
    psychicMap.put(TypeEnum.POISON, 2.0);
    psychicMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type dragon
    HashMap<TypeEnum, Double> dragonMap = new HashMap<>();
    typeMap.put(TypeEnum.DRAGON, dragonMap);
    // the inner hash maps for dragon key
    dragonMap.put(TypeEnum.FIRE, 1.0);
    dragonMap.put(TypeEnum.WATER, 1.0);
    dragonMap.put(TypeEnum.ELECTRIC, 1.0);
    dragonMap.put(TypeEnum.NORMAL, 1.0);
    dragonMap.put(TypeEnum.PSYCHIC, 1.0);
    dragonMap.put(TypeEnum.DRAGON, 2.0);
    dragonMap.put(TypeEnum.FLYING, 1.0);
    dragonMap.put(TypeEnum.GRASS, 1.0);
    dragonMap.put(TypeEnum.GHOST, 1.0);
    dragonMap.put(TypeEnum.GROUND, 1.0);
    dragonMap.put(TypeEnum.ROCK, 1.0);
    dragonMap.put(TypeEnum.ICE, 1.0);
    dragonMap.put(TypeEnum.FIGHT, 1.0);
    dragonMap.put(TypeEnum.POISON, 1.0);
    dragonMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type flying
    HashMap<TypeEnum, Double> flyingMap = new HashMap<>();
    typeMap.put(TypeEnum.FLYING, flyingMap);
    // the inner hash maps for flying key
    flyingMap.put(TypeEnum.FIRE, 1.0);
    flyingMap.put(TypeEnum.NORMAL, 1.0);
    flyingMap.put(TypeEnum.WATER, 1.0);
    flyingMap.put(TypeEnum.ELECTRIC, 0.5);
    flyingMap.put(TypeEnum.PSYCHIC, 1.0);
    flyingMap.put(TypeEnum.DRAGON, 1.0);
    flyingMap.put(TypeEnum.FLYING, 1.0);
    flyingMap.put(TypeEnum.GRASS, 2.0);
    flyingMap.put(TypeEnum.GHOST, 1.0);
    flyingMap.put(TypeEnum.GROUND, 1.0);
    flyingMap.put(TypeEnum.ROCK, 0.5);
    flyingMap.put(TypeEnum.ICE, 1.0);
    flyingMap.put(TypeEnum.FIGHT, 2.0);
    flyingMap.put(TypeEnum.POISON, 1.0);
    flyingMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type ghost
    HashMap<TypeEnum, Double> ghostMap = new HashMap<>();
    typeMap.put(TypeEnum.GHOST, ghostMap);
    // the inner hash maps for ghost key
    ghostMap.put(TypeEnum.FIRE, 1.0);
    ghostMap.put(TypeEnum.NORMAL, 0.0);
    ghostMap.put(TypeEnum.WATER, 1.0);
    ghostMap.put(TypeEnum.ELECTRIC, 1.0);
    ghostMap.put(TypeEnum.PSYCHIC, 2.0);
    ghostMap.put(TypeEnum.DRAGON, 1.0);
    ghostMap.put(TypeEnum.FLYING, 1.0);
    ghostMap.put(TypeEnum.GRASS, 1.0);
    ghostMap.put(TypeEnum.GHOST, 2.0);
    ghostMap.put(TypeEnum.GROUND, 1.0);
    ghostMap.put(TypeEnum.ROCK, 1.0);
    ghostMap.put(TypeEnum.ICE, 1.0);
    ghostMap.put(TypeEnum.FIGHT, 1.0);
    ghostMap.put(TypeEnum.POISON, 1.0);
    ghostMap.put(TypeEnum.STEEL, 1.0);

    // the outer hash map for self is type ground
    HashMap<TypeEnum, Double> groundMap = new HashMap<>();
    typeMap.put(TypeEnum.GROUND, groundMap);
    // the inner hash maps for ground key
    groundMap.put(TypeEnum.FIRE, 2.0);
    groundMap.put(TypeEnum.NORMAL, 1.0);
    groundMap.put(TypeEnum.WATER, 1.0);
    groundMap.put(TypeEnum.ELECTRIC, 2.0);
    groundMap.put(TypeEnum.PSYCHIC, 1.0);
    groundMap.put(TypeEnum.DRAGON, 1.0);
    groundMap.put(TypeEnum.FLYING, 0.0);
    groundMap.put(TypeEnum.GRASS, 0.5);
    groundMap.put(TypeEnum.GHOST, 1.0);
    groundMap.put(TypeEnum.GROUND, 1.0);
    groundMap.put(TypeEnum.ROCK, 2.0);
    groundMap.put(TypeEnum.ICE, 1.0);
    groundMap.put(TypeEnum.FIGHT, 1.0);
    groundMap.put(TypeEnum.POISON, 2.0);
    groundMap.put(TypeEnum.STEEL, 2.0);

    // the outer hash map for self is type rock
    HashMap<TypeEnum, Double> rockMap = new HashMap<>();
    typeMap.put(TypeEnum.ROCK, rockMap);
    // the inner hash maps for rock key
    rockMap.put(TypeEnum.FIRE, 2.0);
    rockMap.put(TypeEnum.NORMAL, 1.0);
    rockMap.put(TypeEnum.WATER, 1.0);
    rockMap.put(TypeEnum.ELECTRIC, 1.0);
    rockMap.put(TypeEnum.PSYCHIC, 1.0);
    rockMap.put(TypeEnum.DRAGON, 1.0);
    rockMap.put(TypeEnum.FLYING, 2.0);
    rockMap.put(TypeEnum.GRASS, 1.0);
    rockMap.put(TypeEnum.GHOST, 1.0);
    rockMap.put(TypeEnum.GROUND, 0.5);
    rockMap.put(TypeEnum.ROCK, 1.0);
    rockMap.put(TypeEnum.ICE, 2.0);
    rockMap.put(TypeEnum.FIGHT, 0.5);
    rockMap.put(TypeEnum.POISON, 1.0);
    rockMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type ice
    HashMap<TypeEnum, Double> iceMap = new HashMap<>();
    typeMap.put(TypeEnum.ICE, iceMap);
    // the inner hash maps for ice key
    iceMap.put(TypeEnum.FIRE, 0.5);
    iceMap.put(TypeEnum.NORMAL, 1.0);
    iceMap.put(TypeEnum.WATER, 0.5);
    iceMap.put(TypeEnum.ELECTRIC, 1.0);
    iceMap.put(TypeEnum.PSYCHIC, 1.0);
    iceMap.put(TypeEnum.DRAGON, 2.0);
    iceMap.put(TypeEnum.FLYING, 2.0);
    iceMap.put(TypeEnum.GRASS, 2.0);
    iceMap.put(TypeEnum.GHOST, 1.0);
    iceMap.put(TypeEnum.GROUND, 2.0);
    iceMap.put(TypeEnum.ROCK, 1.0);
    iceMap.put(TypeEnum.ICE, 0.5);
    iceMap.put(TypeEnum.FIGHT, 1.0);
    iceMap.put(TypeEnum.POISON, 1.0);
    iceMap.put(TypeEnum.STEEL, 0.5);

    // the outer hash map for self is type fight
    HashMap<TypeEnum, Double> fightMap = new HashMap<>();
    typeMap.put(TypeEnum.FIGHT, fightMap);
    // the inner hash maps for fight key
    fightMap.put(TypeEnum.FIRE, 1.0);
    fightMap.put(TypeEnum.NORMAL, 2.0);
    fightMap.put(TypeEnum.WATER, 1.0);
    fightMap.put(TypeEnum.ELECTRIC, 1.0);
    fightMap.put(TypeEnum.PSYCHIC, 0.5);
    fightMap.put(TypeEnum.DRAGON, 1.0);
    fightMap.put(TypeEnum.FLYING, 0.5);
    fightMap.put(TypeEnum.GRASS, 1.0);
    fightMap.put(TypeEnum.GHOST, 1.0);
    fightMap.put(TypeEnum.GROUND, 1.0);
    fightMap.put(TypeEnum.ROCK, 2.0);
    fightMap.put(TypeEnum.ICE, 2.0);
    fightMap.put(TypeEnum.FIGHT, 1.0);
    fightMap.put(TypeEnum.POISON, 0.5);
    fightMap.put(TypeEnum.STEEL, 2.0);

    // the outer hash map for self is type poison
    HashMap<TypeEnum, Double> poisonMap = new HashMap<>();
    typeMap.put(TypeEnum.POISON, poisonMap);
    // the inner hash maps for poison key
    poisonMap.put(TypeEnum.FIRE, 1.0);
    poisonMap.put(TypeEnum.NORMAL, 1.0);
    poisonMap.put(TypeEnum.WATER, 1.0);
    poisonMap.put(TypeEnum.ELECTRIC, 1.0);
    poisonMap.put(TypeEnum.PSYCHIC, 1.0);
    poisonMap.put(TypeEnum.DRAGON, 1.0);
    poisonMap.put(TypeEnum.FLYING, 1.0);
    poisonMap.put(TypeEnum.GRASS, 2.0);
    poisonMap.put(TypeEnum.GHOST, 0.5);
    poisonMap.put(TypeEnum.GROUND, 0.5);
    poisonMap.put(TypeEnum.ROCK, 0.5);
    poisonMap.put(TypeEnum.ICE, 1.0);
    poisonMap.put(TypeEnum.FIGHT, 1.0);
    poisonMap.put(TypeEnum.POISON, 0.5);
    poisonMap.put(TypeEnum.STEEL, 0.0);

    // the outer hash map for self is type steel
    HashMap<TypeEnum, Double> steelMap = new HashMap<>();
    typeMap.put(TypeEnum.STEEL, steelMap);
    // the inner hash maps for steel key
    steelMap.put(TypeEnum.FIRE, 0.5);
    steelMap.put(TypeEnum.NORMAL, 1.0);
    steelMap.put(TypeEnum.WATER, 0.5);
    steelMap.put(TypeEnum.ELECTRIC, 0.5);
    steelMap.put(TypeEnum.PSYCHIC, 1.0);
    steelMap.put(TypeEnum.DRAGON, 1.0);
    steelMap.put(TypeEnum.FLYING, 1.0);
    steelMap.put(TypeEnum.GRASS, 1.0);
    steelMap.put(TypeEnum.GHOST, 1.0);
    steelMap.put(TypeEnum.GROUND, 1.0);
    steelMap.put(TypeEnum.ROCK, 2.0);
    steelMap.put(TypeEnum.ICE, 2.0);
    steelMap.put(TypeEnum.FIGHT, 1.0);
    steelMap.put(TypeEnum.POISON, 1.0);
    steelMap.put(TypeEnum.STEEL, 0.5);
  }

  double getTypeIndex(TypeEnum attackTypeEnum, TypeEnum defenseTypeEnum) {
    HashMap<TypeEnum, Double> innerMap = typeMap.get(attackTypeEnum);
    if (innerMap != null) {
      Double typeIndex = innerMap.get(defenseTypeEnum);
      if (typeIndex != null) {
        return typeIndex;
      }
    }
    return 1.0;
  }

  public enum TypeEnum {
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
    STEEL
  }
}
