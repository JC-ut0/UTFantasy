package csc207.phase1.UTFantasy.Character;

import android.graphics.Bitmap;

import csc207.phase1.UTFantasy.Map.MapView;
import csc207.phase1.UTFantasy.Products.Product;

public abstract class NPC extends Person {
    NPC(String name){
        super(name);
    }

    /**
     * Special ability of this NPC, default to be nothing.
     * @param player the player interact with this NPC.
     */
    public void ability(Player player) {
    }

    public String trade(Player player, int num, Product product){
        return "You don't deserve to trade with me.";
    }

    public abstract Bitmap bitmapDraw(MapView mapView);
}
