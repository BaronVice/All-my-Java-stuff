package DesignPatterns.proxy.storage;

import DesignPatterns.proxy.Employee;

public interface IStorage {
    void deleteEmployee(int id);
    Employee getEmployee(int id);
    void addEmployee(Employee employee);
}
