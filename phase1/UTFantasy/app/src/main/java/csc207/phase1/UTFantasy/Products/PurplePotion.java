package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class PurplePotion extends Product {
    /**
     * the name of PurplePotion
     */
    private static String name = "Potion";
    /**
     * the price of this product
     */
    private static int price = 100;
    /**
     * the profileID of this product
     */
    private static int profileID = R.drawable.purple;
    /**
     * static variable single_instance of PurplePotion
     */
    private static PurplePotion purple;

    /**
     * private constructor restricted to this class itself
     */
    private PurplePotion() {
        super("Potion", 100, R.drawable.purple);
    }

    /**
     * static method to create instance of Singleton class
     *
     * @return a PurplePotion
     */
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
