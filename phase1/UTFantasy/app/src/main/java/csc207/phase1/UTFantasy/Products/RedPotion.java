package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class RedPotion extends Product {
    private static String name = "Read Potion";
    private static int price = 200;
    private static int photoId = R.drawable.red;

    private static RedPotion red;

    private RedPotion() {
        super("Pink Potion", 200, R.drawable.red);
    }

    public static RedPotion getRed() {
        if (red == null) {
            red = new RedPotion();
        }
        return red;
    }


    public static int getProfile_id() {
        //The unique profile id for each PinkPotion. ID can be used to draw this Pokemon.
        return photoId;
    }
}
