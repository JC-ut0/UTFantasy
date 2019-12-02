package csc207.phase2.UTFantasy.Activities.mapUI;

public interface MainActivityInterface {
  void fight();

  void popText(String text);

  void openDialogue(String dialogue);

  void closeDialogue();

  void display(int iconId);

  void goToBattleActivity(String npcName);

  void goToShopActivity(String npcName);

  void showButtons();

  void hideButtons();

  void goToEvolutionActivity(int pokemonIndex);
}
