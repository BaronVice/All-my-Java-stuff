package DesignPatterns.task.helpers;

import DesignPatterns.task.dbms.DBMSFactory;

public class OracleHelper extends Helper{
    public OracleHelper() {
        super(DBMSFactory.get().getOracle());
    }
}
