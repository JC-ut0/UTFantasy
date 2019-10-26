package csc207.phase1.UTFantasy.Character;

import java.util.ArrayList;

import csc207.phase1.UTFantasy.Character.NPC;
import csc207.phase1.UTFantasy.Products.Product;

public class SalerNPC extends NPC {
    public SalerNPC(String name, String gender) {
        super(name, gender);
    }
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private Player player;

    public void addItem(Product product){
        shoppingCart.add(product);
    }

    public void removeItem(Product product) {
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
        }
    }

    private int calculateTotal(){
        int total = 0;
        for (int i = 0; i < shoppingCart.size(); i++){
           total += shoppingCart.get(i).getPrice();
        }
        return total;
    }

    private void clearShoppingCart(){
        shoppingCart.clear();
    }

    public void function(){
        if (player.getMoney() > calculateTotal()){
            ArrayList<Product> arr = new ArrayList<>(shoppingCart);
            player.addAll(arr);
            int money = player.getMoney();
            int total = calculateTotal();
            money -= total;
            player.setMoney(money);
        }else{
            System.out.println("You can not afford these.");
        }
        clearShoppingCart();
    }

}
