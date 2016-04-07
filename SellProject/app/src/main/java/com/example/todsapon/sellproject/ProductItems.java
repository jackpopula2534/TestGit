package com.example.todsapon.sellproject;

/**
 * Created by todsapon on 3/18/2016 AD.
 */
public class ProductItems {

    private String nameProduct;
    private int price,priceIn;
    private int amount;
    private int count;
    private int current;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public ProductItems() {
    }

    public ProductItems(int amount) {
        this.amount = amount;
    }

    public ProductItems(String nameProduct, int price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(int priceIn) {
        this.priceIn = priceIn;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }


    public int getPrice() {
        return price;
    }

}
