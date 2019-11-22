package csc207.phase2.UTFantasy.Character;

public class NPC extends Person {
  private String duty;

  public NPC(String name, String duty) {
    super(name);
    this.duty = duty;
  }

  public String getDuty() {
    return duty;
  }
}
