package csc207.phase2.UTFantasy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.Pet.Psyduck;
import csc207.phase2.UTFantasy.Pet.Squirtle;

public class NPCManager implements Serializable {

  /** A HashMap that keys are UserName, values are User instance. */
  private HashMap<String, NPC> npcHashMap;

  /** Constructor of npcManager. */
  public NPCManager() {
    npcHashMap = new HashMap<>();
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
  public void addNPC(String NPCname, NPC npc) {
    npcHashMap.put(NPCname, npc);
  }
}
