package csc207.phase2.UTFantasy.Battle;

public interface BattleActivityModel {
    void showText(String text);

    void openMenu();

    void closePokemonChoose();

    void closeSkillMenu();

    void endFight();

    void updatePlayerPoke(int pokeId);

    void updateRivalPoke(int pokeId);

    void updatePlayerPokeHp(int hp, int maxHp);

    void updateRivalPokeHp(int hp, int maxHp);

    void showSinglePokemonForChoose(int pokeNum, boolean isAttending, int pokeId, int maxHp, int hp);

    void warnPokeNotAlive();

    void setSkill1(String skill1);

    void setSkill2(String skill2);

    void setSkill3(String skill3);

    void setSkill4(String skill4);

    void showCatch();

    void hideCatch();

    void showCaught();
}
