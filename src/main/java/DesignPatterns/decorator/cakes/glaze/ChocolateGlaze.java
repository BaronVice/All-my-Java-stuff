package DesignPatterns.decorator.cakes.glaze;

import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.CakeDecorator;

public class ChocolateGlaze extends CakeDecorator {

    public ChocolateGlaze(CakeComponent cakeComponent) {
        super(cakeComponent);
    }

    @Override
    public String getCoreDescription() {
        return "- Шоколадная глазурь\n";
    }
}
