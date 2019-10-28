package csc207.phase1.UTFantasy.Character;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Products.Product;

public class SalerNPC extends NPC {
    private static SalerNPC alice;

    private SalerNPC() {
        super("Alice");
    }

    public static SalerNPC getAlice() {
        if (alice == null) {
            alice = new SalerNPC();
        }
        return alice;
    }

    private boolean affordable;

    public void ability(Player player, int num, Product product) {
        int total = num * product.getPrice();
        if (player.getMoney() > total) {
            int money = player.getMoney();
            money -= total;
            player.setMoney(money);
            affordable = true;
        } else {
            affordable = false;
        }
    }

    public boolean isAffordable() {
        return affordable;
    }

}
