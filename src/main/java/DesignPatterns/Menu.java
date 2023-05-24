package DesignPatterns;

import java.util.Set;

public interface Menu {
    Set<String> getNormalBurger();
    Set<String> getVeganBurger();
    Set<String> getSpecialBurger();
}
