package com.designPAttern.decorator;

public class SugarDecorator extends CoffeeDecorator{
    SugarDecorator(Coffee coffeeObject) {
        super(coffeeObject);
    }

    @Override
    public void addMilk() {
        System.out.println("Added sugar for sweet");
        coffeeObject.addMilk();
    }

    @Override
    public double getPrice() {

        return coffeeObject.getPrice()*2;
    }
}
