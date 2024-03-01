package DesignPatterns.task.dbms;

import DesignPatterns.task.sql.CRUD;
import DesignPatterns.task.sql.Driver;

public abstract class DBMS implements CRUD {
    protected Driver driver;

    public DBMS(String port){
        this.driver = new Driver(port);
    }

    public abstract Driver getDriver();
}
