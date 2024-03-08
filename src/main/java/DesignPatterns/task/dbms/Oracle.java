package DesignPatterns.task.dbms;

import DesignPatterns.task.sql.Driver;

public class Oracle extends DBMS {

    public Oracle(String port) {
        super(port);
    }

    @Override
    public Driver getDriver() {
        return driver;
    }

    @Override
    public void create() {
        driver.create();
    }

    @Override
    public void read() {
        driver.read();
    }

    @Override
    public void update() {
        driver.update();
    }

    @Override
    public void delete() {
        driver.delete();
    }
}