package DesignPatterns;

import java.util.HashSet;
import java.util.Set;

public class Builder {
    private final Set<String> ingredients;

    public Builder(){
        ingredients = new HashSet<>();
    }

    public void addTomato(){
        ingredients.add("Tomato");
    }

    public void addCheese(){
        ingredients.add("Cheese");
    }

    public void secretSauce(){
        ingredients.add("Secret Sauce");
    }

    @Override
    public String toString(){
        return String.format("Your product contains: %s", String.join(" ", ingredients));
    }
}
