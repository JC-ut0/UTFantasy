package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class PurplePotion extends Product {
    private static String name = "Purple Potion";
    private static int price = 100;
    private static int photoId = R.drawable.purple;

    private static PurplePotion purple;

    private PurplePotion() {
        super("Pink Potion", 100, R.drawable.purple);
    }

    public static PurplePotion getPurple() {
        if (purple == null) {
            purple = new PurplePotion();
        }
        return purple;
    }


    public static int getProfile_id() {
        //The unique profile id for each PinkPotion. ID can be used to draw this Pokemon.
        return photoId;
    }
}
