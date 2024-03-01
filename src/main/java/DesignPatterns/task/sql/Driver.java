package DesignPatterns.task.sql;

public class Driver implements CRUD {
    private final String port;

    public Driver(String port){
        this.port = port;
    }

    private void connect(){
        System.out.println("Connecting to " + port);
    }

    @Override
    public void create() {
        connect();
        System.out.println("Created");
    }

    @Override
    public void read() {
        connect();
        System.out.println("Got some data");
    }

    @Override
    public void update() {
        connect();
        System.out.println("Entities updated");
    }

    @Override
    public void delete() {
        connect();
        System.out.println("Table is dropped... Or maybe not .-.");
    }
}
