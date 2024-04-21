package DesignPatterns.decorator.cakes;

/**
 * Конечный/опорный класс в декораторе
 */
public class Cake implements CakeComponent {
    @Override
    public String getDescription() {
        return "Торт:\n";
    }
}
