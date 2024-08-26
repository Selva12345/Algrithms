package com.designPAttern.decorator;

public class MilkCoffee implements Coffee {
    @Override
    public void addMilk() {
        System.out.println("Milk added");
    }

    @Override
    public double getPrice() {
        return 7;
    }
}
