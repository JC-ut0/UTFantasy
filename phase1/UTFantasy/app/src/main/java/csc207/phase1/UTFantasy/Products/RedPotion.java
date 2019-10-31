package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class RedPotion extends Product {
    /**
     * the name of RedPotion
     */
    private static String name = "Super Potion";
    /**
     * the price of this product
     */
    private static int price = 200;
    /**
     * the profileID of this product
     */
    private static int rofileID = R.drawable.red;


    /**
     * static variable single_instance of RedPotion
     */
    private static RedPotion red;

    /**
     * private constructor restricted to this class itself
     */
    private RedPotion() {
        super("Super Potion", 200, R.drawable.red);
    }

    /**
     * static method to create instance of Singleton class
     *
     * @return a RedPotion
     */
    public static RedPotion getRed() {
        if (red == null) {
            red = new RedPotion();
        }
        return red;
    }

    public String toString() {
        return "This is a super potion, it can restore 50 hp.";
    }


}
