package csc207.phase2.UTFantasy.Character;

public class NPC extends Person {
  private String dialogue;
  private String interactedDialogue;
  private Duty duty;
  private boolean interacted;

  public NPC(String name, Duty duty) {
    super(name);
    this.duty = duty;
  }

  public void setDialog(String dialogue) {
    this.dialogue = dialogue;
  }

  public String getDialogue() {
    return dialogue;
  }

  public void setInteractedDialogue(String interactedDialogue) {
    this.interactedDialogue = interactedDialogue;
  }

  public String getInteractedDialogue() {
    return interactedDialogue;
  }

  public Duty getDuty() {
    return duty;
  }

  public boolean isInteracted() {
    return interacted;
  }

  public void setInteracted(boolean interacted) {
    this.interacted = interacted;
  }
}