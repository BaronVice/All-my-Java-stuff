package DesignPatterns.proxy;

import DesignPatterns.proxy.server.ProxyServer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProxyServer proxyServer = ProxyServer.getProxyServer();

        List<Employee> employeeList = List.of(
                new Employee("Bob", 1234),
                new Employee("Alice", 5678),
                new Employee("Sam", 3211),
                new Employee("Harry", 3221)
        );
        employeeList.forEach(proxyServer::addEmployee);

        System.out.println(proxyServer.averageSalary());

        proxyServer.addEmployee(new Employee("Aron", 33333));
        System.out.println(proxyServer.averageSalary());

        proxyServer.deleteEmployee(0);
        proxyServer.deleteEmployee(1);
        proxyServer.deleteEmployee(3);
        System.out.println(proxyServer.averageSalary());

        System.out.println(proxyServer.getEmployee(4));

        System.out.println(proxyServer.averageSalary());
        System.out.println(proxyServer.getStorage(0) != null);
        proxyServer.removeStorage(0);
        System.out.println(proxyServer.getStorage(0) != null);
        System.out.println(proxyServer.averageSalary());


//        System.out.println(proxyServer.averageSalary());
//        proxyServer.deleteEmployee(3);
//        System.out.println(proxyServer.averageSalary());
//        System.out.println(proxyServer.getEmployee(1));
//        proxyServer.removeStorage(1);
//        System.out.println(proxyServer.averageSalary());
    }
}
