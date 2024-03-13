package DesignPatterns.task.helpers;

import DesignPatterns.task.dbms.DBMSFactory;

public class MySQLHelper extends Helper{
    public MySQLHelper() {
        super(DBMSFactory.get().getMySQL());
    }
}
