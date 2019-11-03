package csc207.phase1.UTFantasy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import csc207.phase1.UTFantasy.Character.FighterNPC;
import csc207.phase1.UTFantasy.Character.HealerNPC;
import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Character.SellerNPC;
import csc207.phase1.UTFantasy.Pet.Pokemon;
import csc207.phase1.UTFantasy.Pet.Psyduck;
import csc207.phase1.UTFantasy.Pet.Squirtle;

public class NPCManager implements Serializable {

    /**
     * A  HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, NPC> npcHashMap;

    /**
     * The array list of all npc
     */
    private ArrayList<NPC> npcArrayList = new ArrayList<>();


    /**
     * Constructor of npcManager.
     */
    public NPCManager() {
        npcHashMap = new HashMap<>();
        String seller = "Alice";
        String fighter = "Professor. P";
        String healer = "SecondCup";
        SellerNPC sellerNPC = new SellerNPC(seller);
        FighterNPC fighterNPC = new FighterNPC(fighter);
        HealerNPC healerNPC = new HealerNPC(healer);
        Pokemon squirtle = new Squirtle();
        Pokemon psyduck = new Psyduck();
        psyduck.setLevel(5);
        fighterNPC.addPokemon(psyduck);
        squirtle.setLevel(5);
        fighterNPC.addPokemon(squirtle);
        addNPC(seller, sellerNPC);
        addNPC(fighter, fighterNPC);
        addNPC(healer, healerNPC);
        npcArrayList.add(sellerNPC);
        npcArrayList.add(fighterNPC);
        npcArrayList.add(healerNPC);
        sellerNPC.setLocation(7, 7);
        fighterNPC.setLocation(12, 7);
        healerNPC.setLocation(17, 7);
    }


    /**
     * Get the User in npcHashMap if the username is in the userHapMap.
     *
     * @param NPCname the NPCname of the User.
     * @return a User if the NPCname is in the npcHashMap, null if not.
     */
    public NPC getNPC(String NPCname) {
        if (npcHashMap.containsKey((NPCname))) {
            return npcHashMap.get(NPCname);
        }
        return null;
    }

    /**
     * Register using username and password. Update the userHapMap after resisting.
     *
     * @param NPCname the username of the User.
     */
    private void addNPC(String NPCname, NPC npc) {
        npcHashMap.put(NPCname, npc);
    }

    /**
     * @return the array list of all npc
     */
    ArrayList<NPC> getNpcArrayList() {
        return npcArrayList;
    }
}