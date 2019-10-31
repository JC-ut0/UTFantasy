package csc207.phase1.UTFantasy.Products;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    protected String name;
    protected int price;
    protected int profileID;

    Product(String name, int price, int photoId) {
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
        return "This is a product.";
    }

    public int getProfile_id() {
        return profileID;
    }

}
