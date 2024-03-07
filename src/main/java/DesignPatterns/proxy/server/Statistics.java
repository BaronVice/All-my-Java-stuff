package DesignPatterns.proxy.server;

/**
 * Для обработки статистики по работникам
 */
public interface Statistics {
    /**
     * Получить среднюю зарплату всех работников
     * @return средняя зарплата всех работников
     */
    double averageSalary();
}
