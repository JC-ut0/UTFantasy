package csc207.phase2.UTFantasy.Products;

public class PotionFactory {
    public Product makePotion(String color){
        switch (color){
            case "red":
                return RedPotion.getRed();
            case "pink":
                return PinkPotion.getPink();
            case "purple":
                return PurplePotion.getPurple();
        }
        return null;
    }
}
