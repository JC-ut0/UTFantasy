package csc207.phase1.UTFantasy.Character;

import java.util.ArrayList;
import java.util.Iterator;
import csc207.phase1.UTFantasy.AllSkills.Skill;

import csc207.phase1.UTFantasy.Pet.Pokemon;

public class HealerNPC extends NPC {
    public HealerNPC(String name) {
        super(name);
    }

    /**
     * HealerNPC's ability is heal.
     */
    public void ability(Player player){
        for(Pokemon pkm: player.getPokemonList()){
            pkm.setHp(pkm.maximumHp);
            pkm.setStatus("");
            Skill[] skills = pkm.getSkills();
            for(Skill s : skills) {
                s.setPp(s.getMaximumPp());
            }
        }
        }
}
