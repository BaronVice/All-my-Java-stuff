package DesignPatterns.decorator.cakes;

/**
 * Декоратор - паттерн, позволяющий добавлять объекту обязанности другого объекта за счет
 * внедрения второго в первый
 */
public abstract class CakeDecorator implements CakeComponent{
    // Объект, обязанности которого хотим внедрить в этот объект
    private final CakeComponent cakeComponent;

    public CakeDecorator(CakeComponent cakeComponent){
        this.cakeComponent = cakeComponent;
    }

    @Override
    public String getDescription() {
        // Вызываем функционал внедренного объекта, затем собственный
        return cakeComponent.getDescription() + getCoreDescription();
    }

    /**
     * Метод получения собственного описания компоненты
     * @return собственное описание компоненты
     */
    public abstract String getCoreDescription();
}
