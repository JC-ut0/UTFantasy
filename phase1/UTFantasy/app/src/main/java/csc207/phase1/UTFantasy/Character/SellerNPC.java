package csc207.phase1.UTFantasy.Character;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import csc207.phase1.UTFantasy.Map.MapView;
import csc207.phase1.UTFantasy.Products.Product;
import csc207.phase1.UTFantasy.R;

public class SellerNPC extends NPC {
    /**
     * the Bitmap of the character sellerNPC
     */
    public static Bitmap BITMAPSELLER;

    /**
     * Constructor of SellerNPC
     */
    public SellerNPC(String npcName) {
        super(npcName);
        tradeable = true;
    }

    @Override

    /**
     *@param player the player with who this seller NPC trades.
     *@param num the number of products purchased.
     *@param product the product that player chooses to buy.
     *@return a String*/
    public String trade(Player player, int num, Product product) {
        if (isPlayerAffordable(player, num, product)) {
            int total = num * product.getPrice();
            player.setMoney(player.getMoney() - total);
            player.addItem(product, num);
            return "You have purchased " + num + " " + product.getName() + "(s)";
        }
        return "You don't have enough money!";
    }

    /**
     * Check if the player has enough money to buy the products.
     *
     * @param player  the player who buys products.
     * @param num     the number of products purchased.
     * @param product the product that player chooses to buy.
     * @return true if the player has enough money to buy given numbers of products, false if not.
     */
    private boolean isPlayerAffordable(Player player, int num, Product product) {
        int total = num * product.getPrice();
        int playerMoney = player.getMoney();
        return playerMoney >= total;

    }

    @Override
    public Bitmap bitmapDraw(MapView mapView) {
        BITMAPSELLER = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.professor);
        return BITMAPSELLER;
    }
}
