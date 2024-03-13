package DesignPatterns.task.helpers;


public class HelperFactory {
    private static HelperFactory factory;

    public static HelperFactory get(){
        if (factory == null){
            factory = new HelperFactory();
        }

        return factory;
    }

    public Helper getMySQLHelper(){
        return new MySQLHelper();
    }

    public Helper getOracleHelper(){
        return new OracleHelper();
    }

    public Helper getPostgreSQLHelper(){
        return new PostgreSQLHelper();
    }
}
