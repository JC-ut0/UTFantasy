package csc207.phase1.UTFantasy;

import java.io.Serializable;
import java.util.HashMap;

import csc207.phase1.UTFantasy.Character.NPC;

public class NPCManager implements Serializable {

    /**
     * A  HashMap that keys are UserName, values are User instance.
     */
    private HashMap<String, NPC> npcHashMap;

    /**
     * A unique NPCManager that will be only created once.
     */
    private static csc207.phase1.UTFantasy.NPCManager NPCManager;

    /**
     * Where all user data are stored.
     */

    /**
     * Singleton Constructor of NPCManager.
     */
    private NPCManager() {
        npcHashMap = new HashMap<>();
    }

    /**
     * always return a same NPCManager.
     *
     * @return a NPCManager
     */
    public static csc207.phase1.UTFantasy.NPCManager getNPCManager() {
        if (NPCManager == null) {
            NPCManager = new csc207.phase1.UTFantasy.NPCManager();
        }
        return NPCManager;
    }

    /**
     * Get the User in npcHashMap if the username is in the userHapMap.
     *
     * @param NPCname the NPcname of the User.
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