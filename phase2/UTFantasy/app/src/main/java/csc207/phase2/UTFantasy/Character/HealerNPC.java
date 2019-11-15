package csc207.phase2.UTFantasy.Character;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import csc207.phase2.UTFantasy.AllSkills.Skill;
import csc207.phase2.UTFantasy.Map.MapView;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.R;

public class HealerNPC extends NPC {
  public static Bitmap bitmapHealerNPC;

  public HealerNPC(String name) {
    super(name);
    healable = true;
  }

  /**
   * HealerNPC's ability is heal.
   *
   * @param player the player interact with this NPC.
   */
  public void ability(Player player) {
    for (Pokemon pkm : player.getPokemonList()) {
      pkm.setHp(pkm.getMaximumHp());
      pkm.setStatus("");
      Skill[] skills = pkm.getSkills();
      for (Skill s : skills) {
        s.setPp(s.getMaximumPp());
      }
    }
  }

  @Override
  public Bitmap bitmapDraw(MapView mapView) {
    bitmapHealerNPC = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.professor);
    return bitmapHealerNPC;
  }
}
