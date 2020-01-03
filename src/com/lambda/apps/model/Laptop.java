package com.lambda.apps.model;

public class Laptop {

    private String brand;
    private int price;

    public Laptop(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop [make=" + brand + ", price=" + price + "]";
    }
}
