package csc207.phase1.UTFantasy.Products;

import androidx.annotation.NonNull;

public class Product {
    private String name;
    private int price;
    private int profileID;

    Product(String name, int price, int photoId){
        this.name = name;
        this.price = price;
        this.profileID = photoId;
    }

    public int getPrice() {
        return price;
    }


    public String getName() {
        return name;
    }


    public String toString() {
        return name;
    }

    public int getProfile_id(){
        return profileID;
    }
}
