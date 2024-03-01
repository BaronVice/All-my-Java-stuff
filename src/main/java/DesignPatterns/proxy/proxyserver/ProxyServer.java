package DesignPatterns.proxy.proxyserver;

import DesignPatterns.proxy.Employee;
import DesignPatterns.proxy.storage.DefaultStorage;
import DesignPatterns.proxy.storage.EmployeeStorage;
import DesignPatterns.proxy.storage.IStorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProxyServer implements IProxyServer, IStorage, Statistics {
    private static final ProxyServer proxyServer = new ProxyServer();
    private final Map<Integer, EmployeeStorage> employeeStorageMap;

    private ProxyServer(){
        employeeStorageMap = new ConcurrentHashMap<>();
    }

    public static ProxyServer getProxyServer(){
        return proxyServer;
    }

    @Override
    public void deleteEmployee(int id) {
        for (EmployeeStorage storage : employeeStorageMap.values()){
            storage.deleteEmployee(id);
        }
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        for (EmployeeStorage storage : employeeStorageMap.values()){
            employee = storage.getEmployee(id);
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employeeStorageMap.size() == 0){
            EmployeeStorage storage = new DefaultStorage();
            storage.addEmployee(employee);
            employeeStorageMap.put(storage.getId(), storage);
            return;
        }

        int minId = 0;
        int minSize = (int) 1e9;
        for (Map.Entry<Integer, EmployeeStorage> storage : employeeStorageMap.entrySet()){
            if (storage.getValue().getEmployeeMap().size() < minSize){
                minSize = storage.getValue().getEmployeeMap().size();
                minId = storage.getKey();
            }
        }

        employeeStorageMap.get(minId).addEmployee(employee);
    }

    @Override
    public void addStorage() {
        EmployeeStorage storage = new DefaultStorage();
        employeeStorageMap.put(storage.getId(), storage);
    }

    @Override
    public void addStorage(EmployeeStorage storage) {
        employeeStorageMap.put(storage.getId(), storage);
    }

    @Override
    public EmployeeStorage getStorage(int id) {
        return employeeStorageMap.get(id);
    }

    @Override
    public void removeStorage(int id) {
        EmployeeStorage storage = employeeStorageMap.get(id);
        if (storage == null)
            return;

        employeeStorageMap.remove(id);
        storage.getEmployeeMap().values().forEach(this::addEmployee);
    }

    @Override
    public double averageSalary() {
        double sum = 0;
        int amount = 0;
        for (EmployeeStorage storage : employeeStorageMap.values()){
            amount += storage.getEmployeeMap().size();
            sum += storage.getEmployeeMap().values().stream().mapToInt(Employee::getSalary).sum();
        }

        return sum / amount;
    }
}
