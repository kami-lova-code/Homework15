package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {



    private final double basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name,double basePrice,int discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException(" Базовая цена должна быть строго больше нуля");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException(" Скидка должна быть от 0 до 100 включительно");


        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }




    @Override
    public double getPrice() {return basePrice * (100 - discountPercent) / 100.0;
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
