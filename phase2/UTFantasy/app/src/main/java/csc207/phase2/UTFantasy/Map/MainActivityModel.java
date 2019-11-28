package csc207.phase2.UTFantasy.Map;

public interface MainActivityModel {
  void fight();

  void trade();

  void popText(String text);

    void openDialogue(String dialogue);

    void closeDiagloue();

    void goToBattleActivity(String npcName);

    void goToShopActivity(String npcName);

    void showButtons();

    void hideButtons();
}
