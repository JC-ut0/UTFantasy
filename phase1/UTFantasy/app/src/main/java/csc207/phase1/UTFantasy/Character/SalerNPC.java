package csc207.phase1.UTFantasy.Character;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.jetbrains.annotations.NotNull;

import csc207.phase1.UTFantasy.MapView;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.R;

public class SalerNPC extends NPC {
    public static Bitmap BITMAPSALER;

    public SalerNPC(String npcName) {
        super(npcName);
    }
    @Override
    public String trade(@NotNull Player player, int num, Product product) {
        if (isPlayerAffordable(player,num,product)){
            int total = num * product.getPrice();
            player.setMoney(player.getMoney() - total);
            player.setBag(product, num);
            return "You have purchased " + num +" "+ product.getName()+"(s)";
        }
        return "You don't have enough money!";
    }

    private boolean isPlayerAffordable(@NotNull Player player, int num, @NotNull Product product) {
        int total = num * product.getPrice();
        int playerMoney = player.getMoney() ;
        return playerMoney >= total;

    }

    @Override
    public Bitmap bitmapDraw(MapView mapView) {
        BITMAPSALER = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.professor);
        return BITMAPSALER;
    }
}
