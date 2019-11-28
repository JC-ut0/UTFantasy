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

        // the outer hash map for self is type fire
        HashMap<type, Double> fireMap = new HashMap<>();
        typeMap.put(type.FIRE, fireMap);
        // the inner hash maps for fire key
        fireMap.put(type.FIRE, 0.5);
        fireMap.put(type.NORMAL, 1.0);
        fireMap.put(type.WATER, 0.5);
        fireMap.put(type.ELECTRIC, 1.0);

        // the outer hash map for self is type normal
        HashMap<type, Double> normalMap = new HashMap<>();
        typeMap.put(type.NORMAL, normalMap);
        // the inner hash maps for water key
        normalMap.put(type.FIRE, 1.0);
        normalMap.put(type.NORMAL, 1.0);
        normalMap.put(type.WATER, 1.0);
        normalMap.put(type.ELECTRIC, 1.0);

        // the outer hash map for self is type electric
        HashMap<type, Double> electricMap = new HashMap<>();
        typeMap.put(type.ELECTRIC, electricMap);
        // the inner hash maps for water key
        electricMap.put(type.FIRE, 1.0);
        electricMap.put(type.NORMAL, 1.0);
        electricMap.put(type.WATER, 2.0);
        electricMap.put(type.ELECTRIC, 0.5);
    }

    public enum type {
        FIRE,
        WATER,
        ELECTRIC,
        NORMAL,
        PSYCHIC,
        DRAGON,
        FLYING;
    }

    public double getTypeIndex(type attackType, type defenseType) {
        if (typeMap.containsKey(attackType) && typeMap.get(attackType).containsKey(defenseType)) {
            return typeMap.get(attackType).get(defenseType);
        } else {
            return 1.0;
        }
    }
}
