package csc207.phase2.UTFantasy.npcUseCase;

import csc207.phase2.UTFantasy.Character.Duty;
import csc207.phase2.UTFantasy.Character.NPC;
import csc207.phase2.UTFantasy.Character.Player;
import csc207.phase2.UTFantasy.mapUseCase.MapDrawer;

/** The interactor of NPC, including all the use case of NPC. */
public class NPCInteractor {
  private Player player;
  private MapDrawer drawer;
  private Interaction interaction;
  private InteractionFactory interactionFactory;

  public NPCInteractor(Player player) {
    this.player = player;
    this.interactionFactory = new InteractionFactory();
  }

  public void setDrawer(MapDrawer drawer) {
    this.drawer = drawer;
  }

  public void openDialogue(NPC npc) {
    Duty duty = npc.getDuty();
    switch (duty) {
      case FIGHT:
        interaction = interactionFactory.getFightInteraction(drawer, player);
        break;
      case SALE:
        interaction = interactionFactory.getSaleInteraction(drawer, player);
        break;
      case HEAL:
        interaction = interactionFactory.getHealInteraction(drawer, player);
        break;
      case CHARMANDER:
        interaction = interactionFactory.getCharmanderInteraction(drawer, player);
        break;
      case SQUIRTLE:
        interaction = interactionFactory.getSquirtleInteraction(drawer, player);
        break;
      case BULBASAUR:
        interaction = interactionFactory.getBulbasaurInteraction(drawer, player);
    }
    interaction.openDialogue(npc);
  }

  public void openInteractedDialogue(NPC npc) {
    String interactedDialogue = npc.getInteractedDialogue();
    drawer.openDialogue(interactedDialogue);
  }

  public void closeDialogue() {
    drawer.hideDialogue();
  }

  public void interact(NPC npc) {
    if (interaction != null) {
      interaction.interact(npc);
      interaction = null;
    }
  }

  public void clearObserver() {
    player.clearObserver();
  }
}
