package csc207.phase1.UTFantasy;

import java.io.Serializable;
import java.util.HashMap;

import csc207.phase1.UTFantasy.Character.FighterNPC;
import csc207.phase1.UTFantasy.Character.HealerNPC;
import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Character.SalerNPC;

public class NPCManager implements Serializable {

    /**
     * A  HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, NPC> npcHashMap;

    /**
     * A unique npcManager that will be only created once.
     */
    private static csc207.phase1.UTFantasy.NPCManager npcManager;

    /**
     * Where all user data are stored.
     */

    /**
     * Singleton Constructor of npcManager.
     */
    private NPCManager() {
        npcHashMap = new HashMap<>();
    }

    /**
     * always return a same npcManager.
     *
     * @return a npcManager
     */
    public static csc207.phase1.UTFantasy.NPCManager getNpcManager() {
        if (npcManager == null) {
            npcManager = new csc207.phase1.UTFantasy.NPCManager();
            String saler = "Alice";
            String fighter = "Professor. P";
            String healer = "SecondCup";
            SalerNPC salerNPC = new SalerNPC(saler);
            FighterNPC fighterNPC = new FighterNPC(fighter);
            HealerNPC healerNPC = new HealerNPC(healer);
            npcManager.addNPC(saler, salerNPC);
            npcManager.addNPC(fighter, fighterNPC);
            npcManager.addNPC(healer, healerNPC);

        }
        return npcManager;
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
     * @return A new User.
     */
    public void addNPC(String NPCname, NPC npc) {
        npcHashMap.put(NPCname, npc);
    }
}