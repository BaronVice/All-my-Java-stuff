package DesignPatterns.task.dbms;

import DesignPatterns.task.Entity;

public interface CRUD {
    void create(Entity obj);
    Entity get(int id);
    void update(Entity obj);
    void delete(int id);
}
