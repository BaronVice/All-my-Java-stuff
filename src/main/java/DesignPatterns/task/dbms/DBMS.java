package DesignPatterns.task.dbms;

import DesignPatterns.task.Entity;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class DBMS implements CRUD{
    private static final AtomicInteger SEQUENCE = new AtomicInteger(0);
    private final Map<Integer, Entity> entityMap;
    private final int port;

    public DBMS(int port){
        this.port = port;
        this.entityMap = new HashMap<>();
    }

    @Override
    public void create(Entity obj) {
        obj.setId(SEQUENCE.incrementAndGet());
        entityMap.put(obj.getId(), obj);
        System.out.println("Port " + port + ": entity created with id = " + SEQUENCE.get());
    }

    @Override
    public Entity get(int id) {
        Entity en = entityMap.get(id);
        if (en == null){
            System.out.println("Port " + port + ": can't find entity with id = " + id);
            return null;
        }
        System.out.println("Port " + port + ": entity requested with id = " + SEQUENCE.get());
        return en;
    }

    @Override
    public Collection<Entity> getAll() {
        return entityMap.values();
    }

    @Override
    public void update(Entity obj) {
        Entity toUpdate = entityMap.get(obj.getId());
        if (toUpdate == null){
            System.out.println("Port " + port + ": entity is not reachable with id = " + obj.getId());
            return;
        }

        System.out.println("Port " + port + ": entity updated with id = " + SEQUENCE.get());
        toUpdate.setObject(obj.getObject());
    }

    @Override
    public void delete(int id) {
        entityMap.remove(id);
        System.out.println("Port " + port + ": entity removed with id = " + SEQUENCE.get());
    }
}
