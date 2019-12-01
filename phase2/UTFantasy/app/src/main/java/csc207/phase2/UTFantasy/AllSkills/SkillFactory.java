package csc207.phase2.UTFantasy.AllSkills;

public class SkillFactory {
  public Skill getSkill(SkillFactory.SkillClass skillClass) {
    switch (skillClass) {
      case BODYSLAM:
        return new BodySlam();
      case BUBBLE:
        return new Bubble();
      case CONFUSION:
        return new Confusion();
      case DOUBLESLAP:
        return new Doubleslap();
      case DRAGONRAGE:
        return new DragonRage();
      case EMBER:
        return new Ember();
      case FLAMETHROWER:
        return new Flamethrower();
      case HYDROPUMP:
        return new HydroPump();
      case HYPERVOICE:
        return new HyperVoice();
      case POUND:
        return new Pound();
      case QUICKATTACK:
        return new QuickAttack();
      case SCARTCH:
        return new Scratch();
      case TACKLE:
        return new Tackle();
      case THUNDER:
        return new Thunder();
      case THUNDERBOLT:
        return new Thunderblot();
      case THUNDERSHOCK:
        return new ThunderShock();
      case THUNDERWAVE:
        return new ThunderWave();
      case WATERGUN:
        return new WaterGun();
    }
    return null;
  }

  public enum SkillClass {
    BODYSLAM,
    BUBBLE,
    CONFUSION,
    DOUBLESLAP,
    DRAGONRAGE,
    EMBER,
    FLAMETHROWER,
    HYDROPUMP,
    HYPERVOICE,
    POUND,
    QUICKATTACK,
    SCARTCH,
    TACKLE,
    THUNDER,
    THUNDERBOLT,
    THUNDERSHOCK,
    THUNDERWAVE,
    WATERGUN,
  }
}
