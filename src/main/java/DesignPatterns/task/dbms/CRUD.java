package DesignPatterns.task.dbms;

import DesignPatterns.task.Entity;

import java.util.Collection;

public interface CRUD {
    void create(Entity obj);
    Entity get(int id);
    Collection<Entity> getAll();
    void update(Entity obj);
    void delete(int id);
}
