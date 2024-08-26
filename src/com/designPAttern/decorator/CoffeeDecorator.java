package com.designPAttern.decorator;

public abstract class CoffeeDecorator implements Coffee {
    Coffee coffeeObject;
    CoffeeDecorator(Coffee coffeeObject){
        this.coffeeObject=coffeeObject;
    }

}
