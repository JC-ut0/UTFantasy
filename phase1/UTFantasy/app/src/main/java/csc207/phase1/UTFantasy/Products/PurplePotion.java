package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class PurplePotion extends Product {

    private static PurplePotion purple;

    private PurplePotion() {
        super("Potion", 100, R.drawable.purple);
    }

    public static PurplePotion getPurple() {
        if (purple == null) {
            purple = new PurplePotion();
        }
        return purple;
    }

    public String toString() {
        return "This is a potion, it can restore 30 hp.";
    }

}
