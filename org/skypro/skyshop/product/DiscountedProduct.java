package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final double basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name,double basePrice,int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        return basePrice * (100 - discountPercent) / 100.0;
    }


    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public boolean isSpecial() {
        return  true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "( " + discountPercent + "%) ";
    }


}
