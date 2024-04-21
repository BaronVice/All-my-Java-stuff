package DesignPatterns.decorator.cakes.crust;

import DesignPatterns.decorator.cakes.CakeComponent;
import DesignPatterns.decorator.cakes.CakeDecorator;

public class ChocolateCrust extends CakeDecorator {

    public ChocolateCrust(CakeComponent cakeComponent) {
        super(cakeComponent);
    }

    @Override
    public String getCoreDescription() {
        return "- Шоколадный корж\n";
    }
}
