package csc207.phase2.UTFantasy.Products;

public class PotionFactory {

    public Product makePotion(String color){
        switch (color){
            case "red":
                return new RedPotion();
            case "pink":
                return new PinkPotion();
            case "purple":
                return new PurplePotion();
        }
        return null;
    }
}
