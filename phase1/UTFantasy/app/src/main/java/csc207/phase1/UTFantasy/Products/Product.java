package csc207.phase1.UTFantasy.Products;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    /**
     * the name of this product
     */
    private String name;
    /**
     * the price of this product
     */
    private int price;
    /**
     * the profileID of this product
     */
    private int profileID;

    /**
     * the constructor of product
     */
    Product(String name, int price, int photoId) {
        this.name = name;
        this.price = price;
        this.profileID = photoId;
    }

    /**
     * the getter of price
     */
    public int getPrice() {
        return price;
    }

    /**
     * the getter of name
     */
    public String getName() {
        return name;
    }


    public String toString() {
        return "This is a product.";
    }

    /**
     * the getter of ProfileID
     */
    public int getProfile_id() {
        return profileID;
    }

}
