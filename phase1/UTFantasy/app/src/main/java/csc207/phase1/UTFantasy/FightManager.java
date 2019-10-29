package csc207.phase1.UTFantasy;

import android.app.Person;
import android.content.Intent;

import csc207.phase1.UTFantasy.Activities.FightActivity;
import csc207.phase1.UTFantasy.Activities.MainActivity;
import csc207.phase1.UTFantasy.AllSkills.Skill;
import csc207.phase1.UTFantasy.Character.FighterNPC;
import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.Interface.Fighter;
import csc207.phase1.UTFantasy.Pet.Pokemon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.ToDoubleBiFunction;

public class FightManager {

    private Player player;
    private Pokemon playerPokemon;
    private FighterNPC opponent;
    private Pokemon opponentPokemon;
    private boolean fainted;
    private String faintedSide;
    private boolean continuable = true;
    private String priority;
    private int progress = -1;
    private Skill skill;
    private Skill rivalSkill;
    //    private boolean continueFight = true;
//    private String lostSide;
    static HashMap<String, HashMap<String, Float>> typeMap = new HashMap<>();

    public FightManager(Player player, FighterNPC npc) {
        this.player = player;
        playerPokemon = player.getPokemonList().get(0);
        this.opponent = npc;
        opponentPokemon = opponent.getPokemonList().get(0);
        determineTurn();
        setTypeMap();
    }

    //
//    public boolean toBeContinued(){
//        return continueFight;
//    }
//
//    public String getLoser(){
//        return lostSide;
//    }
//
//    public void setOpponentPokemon(Pokemon opponentPokemon) {
//        this.opponentPokemon = opponentPokemon;
//    }
//
//    public void setPlayerPokemon(Pokemon playerPokemon){
//        this.playerPokemon = playerPokemon;
//    }
    public Skill getSkill(){
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    private void setTypeMap() {
        // the outer hash map for self is type water
        HashMap<String, Float> waterMap = new HashMap<String, Float>();
        typeMap.put("water", waterMap);
        // the inner hash maps for water key
        waterMap.put("fire", (float) 2);
        waterMap.put("normal", (float) 1);
        waterMap.put("water", (float) 0.5);
        waterMap.put("electric", (float) 1);

        // the outer hash map for self is type fire
        HashMap<String, Float> fireMap = new HashMap<String, Float>();
        typeMap.put("fire", fireMap);
        // the inner hash maps for fire key
        waterMap.put("fire", (float) 0.5);
        waterMap.put("normal", (float) 1);
        waterMap.put("water", (float) 0.5);
        waterMap.put("electric", (float) 1);

        // the outer hash map for self is type water
        HashMap<String, Float> normalMap = new HashMap<String, Float>();
        typeMap.put("normal", normalMap);
        // the inner hash maps for water key
        waterMap.put("fire", (float) 1);
        waterMap.put("normal", (float) 1);
        waterMap.put("water", (float) 1);
        waterMap.put("electric", (float) 1);

        // the outer hash map for self is type water
        HashMap<String, Float> electricMap = new HashMap<String, Float>();
        typeMap.put("electric", electricMap);
        // the inner hash maps for water key
        waterMap.put("fire", (float) 1);
        waterMap.put("normal", (float) 1);
        waterMap.put("water", (float) 2);
        waterMap.put("electric", (float) 0.5);
    }

    public void determineTurn() {
        if (playerPokemon.getSpeed() > opponentPokemon.getSpeed()) {
            priority = "player";
        } else if (opponentPokemon.getSpeed() > playerPokemon.getSpeed()) {
            priority = "opponent";
        } else {
            double r = Math.random();
            if (r >= 0.5) {
                priority = "player";
            } else {
                priority = "opponent";
            }
        }
    }

    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }

    public Pokemon getRivalPokemon() {
        return opponentPokemon;
    }

    public int calculateDMG(Pokemon pokemon, Pokemon rival, Skill skill) {
        // calculate damage without modifier
        int damage = (2 * rival.getLevel() + 10) / 250;
        damage = damage * pokemon.getAttack() / rival.getDefense();
        damage = damage * skill.getpower() + 2;

        // calculate the modifier
        double random = Math.random() * (1 - 0.85) + 0.85;
        double r = Math.random();
        double rate = 1;
        if (r < 0.03125) {
            rate = 1.5;
        }
        float type = checkType(skill, rival);
        float stab = 1;
        if (skill.getType().equals(pokemon.getType())) {
            stab = (float) 1.5;
        }
        double modifier = random * rate * type * stab;

        return 4 * (int) Math.floor(modifier * damage);
    }

    public boolean getFainted() {
        return fainted;
    }

    public boolean getContinuable() {
        return continuable;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public float checkType(Skill skill, Pokemon rival) {
        float typeIndex = 1;
        if (typeMap.containsKey(skill.getType()) && typeMap.get(skill.getType()).containsKey(rival.getType())) {
            typeIndex = typeMap.get(skill.getType()).get(rival.getType());
        }
        return typeIndex;
    }

    public void setRivalSkill() {
        Skill result = null;
        while (result == null) {
            result = opponentPokemon.getSkills()[(new Random().nextInt(opponentPokemon.getSkillNum()))];
        }
        this.rivalSkill = result;
    }

    public boolean determineContinue(Fighter p) {
        for (Pokemon pokemon : p.getPokemonList()) {
            if (pokemon.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public String updateInfo(int progress) {
        String text;
        switch (progress) {
            case 0:
                text = "What do you wanna do right now?";
                setProgress(1);
                return text;

            case 1:
                // informing the skill of first attack
                determineTurn();
                if (priority.equals("player")) {
                    text = playerPokemon.getPokemonName() + " uses " + skill.getName();
                } else {
                    text = opponentPokemon.getPokemonName() + " uses " + rivalSkill.getName();
                }
                setProgress(2);
                return text;

            case 2:
                // showing the effect of first attack
                if (priority.equals("player")) {
                    text = useSkill(playerPokemon, opponentPokemon, skill);
                    if (fainted) {
                        continuable = determineContinue(opponent);
                        faintedSide = "opponent";
                    }
                } else {
                    text = useSkill(opponentPokemon, playerPokemon, rivalSkill);
                    if (fainted) {
                        continuable = determineContinue(player);
                        faintedSide = "player";
                    }
                }
                setProgress(3);
                return text;

            case 3:
                // informing the skill of second attack or informing fainted pokemon if there is such one
                if (!fainted) {
                    // not fainted
                    if (priority.equals("opponent")) {
                        text = playerPokemon.getPokemonName() + " used " + skill.getName();
                    } else {
                        text = opponentPokemon.getPokemonName() + " used " + rivalSkill.getName();
                    }
                } else {
                    // fainted
                    if (faintedSide.equals("opponent")) {
                        text = opponentPokemon.getPokemonName() + " fainted.";
                    } else {
                        text = playerPokemon.getPokemonName() + " fainted.";
                    }
                }
                setProgress(4);
                return text;

            case 4:
                // effect of second attack or informing if opponent chose next pokemon or if the battle is end
                if (!fainted) {
                    // not fainted
                    if (priority.equals("opponent")) {
                        text = useSkill(playerPokemon, opponentPokemon, skill);
                        if (fainted) {
                            continuable = determineContinue(opponent);
                            faintedSide = "opponent";
                        }
                    } else {
                        text = useSkill(opponentPokemon, playerPokemon, rivalSkill);
                        if (fainted) {
                            continuable = determineContinue(player);
                            faintedSide = "player";
                        }
                    }
                    // check if the pokemon fainted after second attack
                    if (fainted) {
                        setProgress(5);
                    } else {
                        setProgress(0);
                    }
                } else {
                    // one pokemon fainted during first attack
                    if (continuable) {
                        if (faintedSide.equals("opponent")) {
                            // opponent fainted && continuable
                            for (Pokemon pokemon : opponent.getPokemonList()) {
                                if (pokemon.isAlive()) {
                                    opponentPokemon = pokemon;
                                }
                            }
                            assert opponentPokemon != null;
                            setProgress(7);
                            text = updateInfo(7);
                        } else {
                            // player fainted && continuable
                            setProgress(0);
                            text = updateInfo(0);
                        }
                    } else {
                        // non continuable
                        if (faintedSide.equals("opponent")) {
                            text = "You win the battle!!";
                        } else {
                            text = "You lost...";
                        }
                        setProgress(-1);
                    }
                }
                return text;

            case 5:
                // there is progress == 5 iff the pokemon didn't faint during first attack
                // and the pokemon after second attack is fainted
                // used to inform the pokemon that faint
                if (faintedSide.equals("opponent")) {
                    text = opponentPokemon.getPokemonName() + " fainted.";
                } else {
                    text = playerPokemon.getPokemonName() + " fainted.";
                }
                setProgress(6);
                return text;

            case 6:
                // there is progress == 6 iff the pokemon didn't faint during first attack
                // and the pokemon after second attack is fainted
                // used to exchange the pokemon or end the fight
                return updateInfo(4);

            case 7:
                text = opponent.getName() + " send out " + opponentPokemon.getPokemonName();
                setProgress(0);
                return text;
        }
        return "A bug occurred...";

    }


    /**
     * update p1 used skill on p2
     *
     * @param p1    pokemon who used the skill
     * @param p2    pokemon who are attacked
     * @param skill the skill got used
     */
    private String useSkill(Pokemon p1, Pokemon p2, Skill skill) {

        // update the damage
        int dmg = calculateDMG(p1, p2, skill);
        p2.setHp(p2.getHp() - dmg);
        if (p2.getHp() <= 0) {
            p2.setHp(0);
            fainted = true;
        }

        float typeIndex = checkType(skill, p2);
        if (typeIndex > 1) {
            return ("It is super effective!");
        } else if (typeIndex == 1) {
            return ("Nice shot.");
        } else {
            return ("It is not very effective...");
        }
    }
//
//    public ArrayList<String> updateResult(Skill skill) {
//        ArrayList<String> result = new ArrayList<>();
//        double r = Math.random();
//        Random rand = new Random();
//        Skill skillRival = opponentPokemon.getSkills()[(rand.nextInt(opponentPokemon.getSkillNum()))];
//        if (priority.equals("player")) {
//            ArrayList<String> text = useSkill(playerPokemon, opponentPokemon, skill);
//            result.addAll(text);
//            if (text.size() == 3){
//                // if the opponentPokemon fainted
//                for (Pokemon pokemon : opponent.getPokemonList()) {
//                    if (pokemon.isAlive()) {
//                        opponentPokemon = pokemon;
//                        break;
//                    }
//                }
//                // check if the opponent still has available pokemon
//                if (opponentPokemon.isAlive()) {
//                    result.add(opponent.getName() + " sent out " + opponentPokemon.getPokemonName());
//                } else {
//                    result.add("You win the battle!!");
//                    continueFight = false;
//                }
//            }
//            text = useSkill(opponentPokemon, playerPokemon, skillRival);
//            result.addAll(text);
//            if (text.size() == 3){
//                // check if the player still has available pokemon
//                continueFight = false;
//                for (Pokemon pokemon : player.getPokemonList()) {
//                    if (pokemon.isAlive()) {
//                        continueFight = true;
//                        break;
//                    }
//                }
//            }
//        // if the priority is opponent
//        } else {
//            ArrayList<String> text = useSkill(opponentPokemon, playerPokemon, skillRival);
//            result.addAll(text);
//            if (text.size() == 3){
//                // check if the player still has available pokemon
//                continueFight = false;
//                for (Pokemon pokemon : player.getPokemonList()) {
//                    if (pokemon.isAlive()) {
//                        continueFight = true;
//                        break;
//                    }
//                }
//            }
//            text = useSkill(playerPokemon, opponentPokemon, skill);
//            result.addAll(text);
//            if (text.size() == 3){
//                // if the opponentPokemon fainted
//                for (Pokemon pokemon : opponent.getPokemonList()) {
//                    if (pokemon.isAlive()) {
//                        opponentPokemon = pokemon;
//                        break;
//                    }
//                }
//                // check if the opponent still has available pokemon
//                if (opponentPokemon.isAlive()) {
//                    result.add(opponent.getName() + " sent out " + opponentPokemon.getPokemonName());
//                } else {
//                    result.add("You win the battle!!");
//                    continueFight = false;
//                }
//            }
//
//        }
//        return result;
//    }
}
