package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class RedPotion extends Product {
    private static String name = "Super Potion";
    private static int price = 200;
    private static int rofileID = R.drawable.red;

    private static RedPotion red;

    private RedPotion() {
        super("Super Potion", 200, R.drawable.red);
    }

    public static RedPotion getRed() {
        if (red == null) {
            red = new RedPotion();
        }
        return red;
    }

    public String toString(){
        return "This is a super potion, it can restore 50 hp.";
    }


}
