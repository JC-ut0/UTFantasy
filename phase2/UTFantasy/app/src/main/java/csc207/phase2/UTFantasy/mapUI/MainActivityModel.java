package csc207.phase2.UTFantasy.mapUI;

public interface MainActivityModel {
  void fight();

  void trade();

  void popText(String text);

    void openDialogue(String dialogue);

  void closeDialogue();

  void display(int iconId);

    void goToBattleActivity(String npcName);

    void goToShopActivity(String npcName);

    void showButtons();

    void hideButtons();
}
