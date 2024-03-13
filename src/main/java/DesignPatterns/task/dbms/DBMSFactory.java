package DesignPatterns.task.dbms;

public class DBMSFactory {
    private static DBMSFactory factory;

    public static DBMSFactory get(){
        if (factory == null){
            factory = new DBMSFactory();
        }

        return factory;
    }

    public DBMS getOracle(){
        return new DBMS(1234);
    }

    public DBMS getMySQL(){
        return new DBMS(5678);
    }

    public DBMS getPostgreSQL(){
        return new DBMS(5432);
    }

}
