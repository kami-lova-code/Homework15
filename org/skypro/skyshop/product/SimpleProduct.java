package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final double price;



    public SimpleProduct(String name,double price) {
        super(name);
        this.price = price;
        if (price <= 0) {
            throw new IllegalArgumentException(" Цена не может быть ниже нуля и равняться нулю");
        }
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() +": " + getPrice();

    }
}
