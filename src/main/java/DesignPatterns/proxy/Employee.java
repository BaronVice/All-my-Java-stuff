package DesignPatterns.proxy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public class Employee {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(0);
    private int id;
    private String name;
    private int salary;

    public Employee(String name, int salary){
        id = SEQUENCE.getAndIncrement();
        this.name = name;
        this.salary = salary;
    }
}
