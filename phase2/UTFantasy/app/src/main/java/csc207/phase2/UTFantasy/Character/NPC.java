package csc207.phase2.UTFantasy.Character;

public class NPC extends Person {
  private String name;
  private String dialogue;
  private Duty duty;

  public NPC(String name, Duty duty) {
    super(name);
    this.duty = duty;
  }

  public void setDialog(String dialogue) {
    this.dialogue = dialogue;
  }

  public String getDialogu() {
    return dialogue;
  }

  public Duty getDuty() {
    return duty;
  }

  ;
}