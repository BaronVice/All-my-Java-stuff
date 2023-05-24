package DesignPatterns;

import java.util.HashSet;
import java.util.Set;

public class Factory implements Menu {

    @Override
    public Set<String> getNormalBurger() {
        return new HashSet<>(Set.of("Bun", "Meat", "Tomato", "Lettuce"));
    }

    @Override
    public Set<String> getVeganBurger() {
        return new HashSet<>(Set.of("Bun", "Cucumber", "Tomato", "Lettuce"));
    }

    @Override
    public Set<String> getSpecialBurger() {
        return new HashSet<>(Set.of("Bun", "Meat", "Tomato", "Lettuce", "Secret Sauce"));
    }
}
