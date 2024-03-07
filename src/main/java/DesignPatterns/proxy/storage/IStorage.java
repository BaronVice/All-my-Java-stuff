package DesignPatterns.proxy.storage;

import DesignPatterns.proxy.Employee;

public interface IStorage {
    /**
     * Удалить работника из хранилища
     * @param id id работника
     */
    void deleteEmployee(int id);
    /**
     * Получить работника из хранилища
     * @param id id работника
     * @return объект Employee или null если не найден
     */
    Employee getEmployee(int id);

    /**
     * Добавить работника в хранилище
     * @param employee работник для добавления
     */
    void addEmployee(Employee employee);
}
