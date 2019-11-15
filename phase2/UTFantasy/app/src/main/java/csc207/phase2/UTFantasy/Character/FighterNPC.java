package csc207.phase2.UTFantasy.Character;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import csc207.phase2.UTFantasy.Interface.Fighter;
import csc207.phase2.UTFantasy.Map.MapView;
import csc207.phase2.UTFantasy.Pet.Pokemon;
import csc207.phase2.UTFantasy.R;

public class FighterNPC extends NPC implements Fighter {

  public static Bitmap bitmapFighterNPC;

  public FighterNPC(String name) {
    super(name);
    fightable = true;
  }

  /** FighterNPC's ability is Fight. */
  void ability() {}

  /** @return true iff there is at least one non-fainted pokemon. */
  public boolean isFightAble() {
    for (Pokemon pokemon : getPokemonList()) {
      if (pokemon.isAlive()) return true;
    }
    return false;
  }

  @Override
  public Bitmap bitmapDraw(MapView mapView) {
    bitmapFighterNPC = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.professor);
    return bitmapFighterNPC;
  }
}
