package csc207.phase2.UTFantasy.Battle;


import java.util.List;

import csc207.phase2.UTFantasy.Pet.Pokemon;

public class BattlePresenter implements BattleOutputBoundary {
    private BattleActivityModel activityModel;

    public BattlePresenter(BattleActivityModel activityModel) {
        this.activityModel = activityModel;
    }

    @Override
    public void showText(String text) {
        activityModel.showText(text);
    }

    @Override
    public void openMenu() {
        activityModel.openMenu();
    }

    @Override
    public void showPokeList(List<Pokemon> pokeList, Pokemon currPlayerPoke) {
        for (int i = 0; i < 6; i++) {
            Pokemon pokemon;
            try {
                pokemon = pokeList.get(i);
            } catch (IndexOutOfBoundsException e) {
                pokemon = null;
            }
            if (pokemon != null) {

                activityModel.showSinglePokemonForChoose(
                        i,
                        pokemon == currPlayerPoke,
                        pokemon.getProfileID(),
                        pokemon.getHp(),
                        pokemon.getMaximumHp());
            }
        }
    }

    @Override
    public void closeSkillMenu() {
        activityModel.closeSkillMenu();
    }

    @Override
    public void closePokemonChoose() {
        activityModel.closePokemonChoose();
    }

    @Override
    public void updatePlayerPokeView(int pokeId) {
        activityModel.updatePlayerPoke(pokeId);
    }

    @Override
    public void updateRivalPokeView(int pokeId) {
        activityModel.updateRivalPoke(pokeId);
    }

    @Override
    public void updatePlayerHpBar(int hp, int maxHp) {
        activityModel.updatePlayerPokeHp(hp, maxHp);
    }

    @Override
    public void updateRivalHpBar(int hp, int maxHp) {
        activityModel.updateRivalPokeHp(hp, maxHp);
    }

    @Override
    public void endFight() {
        activityModel.endFight();
    }

    ;

    @Override
    public void warnPokeNotAlive() {
        activityModel.warnPokeNotAlive();
    }

    @Override
    public void setSkill1(String skill1) {
        activityModel.setSkill1(skill1);
    }

    @Override
    public void setSkill2(String skill2) {
        activityModel.setSkill2(skill2);
    }

    @Override
    public void setSkill3(String skill3) {
        activityModel.setSkill3(skill3);
    }

    @Override
    public void setSkill4(String skill4) {
        activityModel.setSkill4(skill4);
    }

    @Override
    public void showCatch() {
        activityModel.showCatch();
    }

    @Override
    public void hideCatch() {
        activityModel.hideCatch();
    }

    @Override
    public void showCaught() {
        activityModel.showCaught();
    }

}
