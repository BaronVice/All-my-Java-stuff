package DesignPatterns.proxy.storage;

import DesignPatterns.proxy.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Абстракция хранилища работников
 */
@Getter
@Setter
public abstract class EmployeeStorage implements IStorage {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(0);
    private int id;
    private final Map<Integer, Employee> employeeMap;

    public EmployeeStorage(){
        id = SEQUENCE.getAndIncrement();
        employeeMap = new ConcurrentHashMap<>();
    }

    @Override
    public void deleteEmployee(int id){
        employeeMap.remove(id);
    }

    @Override
    public Employee getEmployee(int id){
        return employeeMap.get(id);
    }

    @Override
    public void addEmployee(Employee employee){
        employeeMap.put(employee.getId(), employee);
    }
}
