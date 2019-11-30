package csc207.phase2.UTFantasy.Battle;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.Pet.Pokemon;

public class BattleData {
    private Player player;
    private NPC rival;
    private Pokemon currPlayerPoke;
    private Pokemon currRivalPoke;
    private Pokemon attacker;
    private Pokemon defender;
    private Skill skill;
    private boolean secondSkillUsed;
    private TypeMap typeMap;
    /**
     * the action that supposed to be done in next updateText() call inside BattleInteractor
     */
    private Action action;


    public BattleData(Player player, NPC rival) {
        this.player = player;
        this.rival = rival;
        this.typeMap = new TypeMap();
        this.action = Action.OPENMENU;
    }

    public Player getPlayer() {
        return player;
    }

    public NPC getRival() {
        return rival;
    }

    public Pokemon getCurrPlayerPoke() {
        return currPlayerPoke;
    }

    public Pokemon getCurrRivalPoke() {
        return currRivalPoke;
    }

    public void setCurrPlayerPoke(Pokemon currPlayerPoke) {
        this.currPlayerPoke = currPlayerPoke;
    }

    public void setCurrRivalPoke(Pokemon currRivalPoke) {
        this.currRivalPoke = currRivalPoke;
    }


    public Pokemon getAttacker() {
        return attacker;
    }

    public Pokemon getDefender() {
        return defender;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setAttacker(Pokemon attacker) {
        this.attacker = attacker;
    }

    public void setDefender(Pokemon defender) {
        this.defender = defender;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public double getTypeIndex(TypeMap.TypeEnum attackType, TypeMap.TypeEnum defendType) {
        return typeMap.getTypeIndex(attackType, defendType);
    }

    enum Action {
        FIGHT,
        USEITEM,
        CATCH,
        CATCHDECISION,
        HEAL,
        CHANGEPOKEMON,
        OPENMENU,
        END
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }

    public boolean isSecondSkillUsed() {
        return secondSkillUsed;
    }

    public void setSecondSkillUsed(boolean secondSkillUsed) {
        this.secondSkillUsed = secondSkillUsed;
    }

    void clearOberser() {
        for (Pokemon pokemon : player.getPokemonList()) {
            pokemon.setObserver(null);
        }
        for (Pokemon pokemon : rival.getPokemonList()) {
            pokemon.setObserver(null);
        }
    }
}
