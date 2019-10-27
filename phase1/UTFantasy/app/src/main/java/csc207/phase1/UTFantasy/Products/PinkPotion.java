package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class PinkPotion extends Product {
    private static String name = "Hyper Potion";
    private static int price = 300;
    private static int profileID = R.drawable.pink;


    private static PinkPotion pink;

    private PinkPotion() {
        super("Hyper Potion", 300, R.drawable.pink);
    }

    public static PinkPotion getPink() {
        if (pink == null) {
            pink = new PinkPotion();
        }
        return pink;
    }

    public String toString(){
        return "This is a hyper potion, it can restore 200 hp.";
    }


}
