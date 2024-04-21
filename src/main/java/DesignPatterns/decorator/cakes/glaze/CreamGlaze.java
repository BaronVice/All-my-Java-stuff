package DesignPatterns.decorator.cakes.glaze;

import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.CakeDecorator;

public class CreamGlaze extends CakeDecorator {

    public CreamGlaze(CakeComponent cakeComponent) {
        super(cakeComponent);
    }

    @Override
    public String getCoreDescription() {
        return "- Кремовая глазурь\n";
    }
}
