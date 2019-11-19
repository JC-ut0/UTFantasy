package csc207.phase2.UTFantasy.Character;

import android.graphics.Bitmap;

import csc207.phase2.UTFantasy.Map.MapView;
import csc207.phase2.UTFantasy.Products.Product;

public class NPC extends Person {
  /** if this npc is fight able */
  boolean fightable;
  /** if this npc can trade */
  boolean tradeable;
  /** if this npc can heal */
  boolean healable;

  NPC(String name) {
    super(name);
  }

  /**
   * Special ability of this NPC, default to be nothing.
   *
   * @param player the player interact with this NPC.
   */
  public void ability(Player player) {}

//  public String trade(Player player, int num, Product product) {
//    return "You don't deserve to trade with me.";
//  }

  /** @return true if this npc can fight */
  public boolean canFight() {
    return fightable;
  }

  /** @return true if this npc can trade */
  public boolean canTrade() {
    return tradeable;
  }

  /** @return true if this npc can heal */
  public boolean canHeal() {
    return healable;
  }

}
