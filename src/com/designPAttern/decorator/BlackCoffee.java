package com.designPAttern.decorator;

public class BlackCoffee implements Coffee{
    @Override
    public void addMilk() {
        System.out.println("Milk not needed");
    }

    @Override
    public double getPrice() {
        return 5.2;
    }
}
