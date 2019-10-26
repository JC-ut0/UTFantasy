package csc207.phase1.UTFantasy.Products;

public class Product {
    private String name;
    private int price;

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }

}
