package DesignPatterns.decorator.cakes.filling;

import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.CakeDecorator;

public class BerryFilling extends CakeDecorator {

    public BerryFilling(CakeComponent cakeComponent) {
        super(cakeComponent);
    }

    @Override
    public String getCoreDescription() {
        return "- Ягодная начинка\n";
    }
}
