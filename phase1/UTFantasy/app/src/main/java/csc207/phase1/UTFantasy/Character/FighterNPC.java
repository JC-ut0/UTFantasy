package csc207.phase1.UTFantasy.Character;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import csc207.phase1.UTFantasy.Interface.Fighter;
import csc207.phase1.UTFantasy.MapView;
import csc207.phase1.UTFantasy.R;

public class FighterNPC extends NPC implements Fighter {

    public static Bitmap bitmapFighterNPC;
    public FighterNPC(String name) {
        super(name);
    }

    /**
     * FighterNPC's ability is Fight.
     */
    void ability(){}

    @Override
    public Bitmap bitmapDraw(MapView mapView) {
        bitmapFighterNPC = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.professor);
        return bitmapFighterNPC;
    }
}
