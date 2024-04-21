package DesignPatterns.decorator.cakes.filling;

import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.CakeDecorator;

public class FruitFilling extends CakeDecorator {

    public FruitFilling(CakeComponent cakeComponent) {
        super(cakeComponent);
    }

    @Override
    public String getCoreDescription() {
        return "- Фруктовая начинка\n";
    }
}
