package DesignPatterns.proxy.proxyserver;

import DesignPatterns.proxy.storage.EmployeeStorage;

public interface IProxyServer {
    void addStorage();
    void addStorage(EmployeeStorage storage);
    EmployeeStorage getStorage(int id);
    void removeStorage(int id);
}
