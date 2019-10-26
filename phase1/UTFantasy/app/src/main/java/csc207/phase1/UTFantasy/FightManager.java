package csc207.phase1.UTFantasy;

import android.app.Person;
import android.content.Intent;

import csc207.phase1.UTFantasy.Activities.FightActivity;
import csc207.phase1.UTFantasy.Activities.MainActivity;
import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.FighterNPC;
import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Pet.Pokemon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FightManager {

    private Player player;
    private Pokemon playerPokemon = player.getPokemonList().get(0);
    private FighterNPC opponent;
    private Pokemon opponentPokemon = opponent.getPokemonList().get(0);
    private String priority;
    static HashMap<String, HashMap<String, Float>> typeMap = new HashMap<>();

    public FightManager(Player player, NPC npc) {
        this.player = player;
        this.opponent = opponent;
        determineTurn();
        setTypeMap();
    }

    private void setTypeMap(){
        // the outer hash map for self is type water
        HashMap<String, Float> waterMap = new HashMap<String, Float>();
        typeMap.put("water", waterMap);
        // the inner hash maps for water key
        waterMap.put("fire", (float) 2);
        waterMap.put("normal", (float)1);
        waterMap.put("water", (float) 0.5);
        waterMap.put("electric", (float)1);

        // the outer hash map for self is type fire
        HashMap<String, Float> fireMap = new HashMap<String, Float>();
        typeMap.put("fire", fireMap);
        // the inner hash maps for fire key
        waterMap.put("fire", (float) 0.5);
        waterMap.put("normal", (float)1);
        waterMap.put("water", (float) 0.5);
        waterMap.put("electric", (float)1);

        // the outer hash map for self is type water
        HashMap<String, Float> normalMap = new HashMap<String, Float>();
        typeMap.put("normal", normalMap);
        // the inner hash maps for water key
        waterMap.put("fire", (float) 1);
        waterMap.put("normal", (float)1);
        waterMap.put("water", (float) 1);
        waterMap.put("electric", (float)1);

        // the outer hash map for self is type water
        HashMap<String, Float> electricMap = new HashMap<String, Float>();
        typeMap.put("electric", electricMap);
        // the inner hash maps for water key
        waterMap.put("fire", (float) 1);
        waterMap.put("normal", (float)1);
        waterMap.put("water", (float) 2);
        waterMap.put("electric", (float)0.5);
    }

    public void determineTurn() {
        if (playerPokemon.getSpeed() > opponentPokemon.getSpeed()) {
            priority = "player";
        } else if (playerPokemon.getSpeed() == opponentPokemon.getSpeed()) {
            double r = Math.random();
            if (r >= 0.5) {
                priority = "player";
            }
        } else {
            priority = "opponent";
        }
    }

    public int calculateDMG(Pokemon pokemon, Pokemon rival, Skill skill){
        // calculate damage without modifier
        int damage = (2 * rival.getLevel() + 10)/250;
        damage = damage * pokemon.getAttack() / rival.getDefense();
        damage = damage * skill.getpower() + 2;

        // calculate the modifier
        double random = Math.random() * (1-0.85)+0.85;
        double r = Math.random();
        double rate = 1;
        if (r < 0.03125){
            rate = 1.5;
        }
        float type = (float)checkType(skill, rival)[0];
        float stab = 1;
        if(skill.getType().equals(pokemon.getType())){
            stab = (float)1.5;
        }
        double modifier = random * rate * type * stab;

        return (int) Math.floor(modifier * damage);
    }

    public Object[] checkType(Skill skill, Pokemon rival){
        float typeIndex = 1;
        if(typeMap.containsKey(skill.getType()) && typeMap.get(skill.getType()).containsKey(rival.getType())){
            typeIndex = typeMap.get(skill.getType()).get(rival.getType());
        }
        String note = "";
        if(typeIndex < 1 ){
            note = "It is not very effective on " + rival.getPokemonName();
        } else if(typeIndex == 1){
            note = "";
        } else {
            note = "It is super effective on " + rival.getPokemonName();
        }
        Object[] result = new Object[2];
        result[0] = typeIndex;
        result[1] = note;
        return result;
    }
    public String[] updateResult(Skill skill){
        String[] result = new String[4];
        double r = Math.random();
        Random rand = new Random();
        Skill skillRival = opponentPokemon.getSkills().get(rand.nextInt(opponentPokemon.getSkillNum()));
        if (priority.equals("player")){
            result[0] = playerPokemon.getPokemonName() + " used " + skill.getName();
            result[1] = (String)checkType(skill,opponentPokemon)[1];
            result[2] = opponentPokemon.getPokemonName() + " used " + skillRival.getName();
            result[3] = (String)checkType(skillRival,playerPokemon)[1];
        } else{
            result[2] = playerPokemon.getPokemonName() + " used " + skill.getName();
            result[3] = (String)checkType(skill,opponentPokemon)[1];
            result[0] = opponentPokemon.getPokemonName() + " used " + skillRival.getName();
            result[1] = (String)checkType(skillRival,playerPokemon)[1];
        }
        return result;
    }
}
