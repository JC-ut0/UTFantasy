package csc207.phase1.UTFantasy.Products;

import csc207.phase1.UTFantasy.R;

public class PinkPotion extends Product {
    private static String name = "Pink Potion";
    private static int price = 300;
    private static int photoId = R.drawable.pink;


    private static PinkPotion pink;

    private PinkPotion() {
        super("Pink Potion", 300, R.drawable.pink);
    }

    public static PinkPotion getPink() {
        if (pink == null) {
            pink = new PinkPotion();
        }
        return pink;
    }


    public static int getProfile_id() {
        //The unique profile id for each PinkPotion. ID can be used to draw this Pokemon.
        return photoId;
    }
}
