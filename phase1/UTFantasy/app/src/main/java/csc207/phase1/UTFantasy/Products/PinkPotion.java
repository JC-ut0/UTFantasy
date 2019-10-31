package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class PinkPotion extends Product {
    /**
     * the name of pinkPotion
     */
    private static String name = "Hyper Potion";
    /**
     * the price of this product
     */
    private static int price = 300;
    /**
     * the profileID of this product
     */
    private static int profileID = R.drawable.pink;

    /**
     * static variable single_instance of PinkPotion
     */
    private static PinkPotion pink;

    /**
     * private constructor restricted to this class itself
     */
    private PinkPotion() {
        super("Hyper Potion", 300, R.drawable.pink);
    }

    /**
     * static method to create instance of Singleton class
     *
     * @return a PinkPotion
     */
    public static PinkPotion getPink() {
        if (pink == null) {
            pink = new PinkPotion();
        }
        return pink;
    }

    public String toString() {
        return "This is a hyper potion, it can restore 200 hp.";
    }


}
