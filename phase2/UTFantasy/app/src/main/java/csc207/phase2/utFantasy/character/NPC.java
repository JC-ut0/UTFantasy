package csc207.phase2.utFantasy.character;

public class NPC extends Person {
  private Duty duty;

  public NPC(String name, Duty duty) {
    super(name);
    this.duty = duty;
  }

  public Duty getDuty() {
    return duty;
  }
}