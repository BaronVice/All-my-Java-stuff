package DesignPatterns.task.helpers;


import DesignPatterns.task.dbms.DBMSFactory;

public class PostgreSQLHelper extends Helper{
    public PostgreSQLHelper() {
        super(DBMSFactory.get().getPostgreSQL());
    }
}
