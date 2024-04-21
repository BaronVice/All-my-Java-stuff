package DesignPatterns.decorator.cakes.crust;

import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.CakeDecorator;

public class ClassicCrust extends CakeDecorator {

    public ClassicCrust(CakeComponent cakeComponent) {
        super(cakeComponent);
    }

    @Override
    public String getCoreDescription() {
        return "- Классический корж\n";
    }
}
