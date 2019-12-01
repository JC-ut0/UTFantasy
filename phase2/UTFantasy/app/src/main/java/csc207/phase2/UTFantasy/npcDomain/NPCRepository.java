package csc207.phase2.UTFantasy.npcDomain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import csc207.phase2.UTFantasy.Character.NPC;

public class NPCRepository implements Serializable {
  // list of npc that can be give player a pokemon at the beginning of the game
  private List<NPC> beginningPokemonNPCs;

  /** A HashMap that keys are UserName, values are NPC instance. */
  private HashMap<String, NPC> npcHashMap;

  /** Constructor of npcManager. */
  public NPCRepository() {
    npcHashMap = new HashMap<>();
    beginningPokemonNPCs = new ArrayList<>();
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

  public void deleteNPC(String NPCname) {
    npcHashMap.remove(NPCname);
  }

  public void addBeginningPokemonNPC(NPC npc) {
    beginningPokemonNPCs.add(npc);
  }

  public List<NPC> getBeginningPokemonNPCs() {
    return beginningPokemonNPCs;
  }
}
