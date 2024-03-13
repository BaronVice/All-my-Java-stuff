package DesignPatterns.task.helpers;

import DesignPatterns.task.Entity;
import DesignPatterns.task.dbms.DBMS;
import DesignPatterns.task.documenttools.DocumentFactory;
import DesignPatterns.task.documenttools.IDocument;

public abstract class Helper implements IHelper {
    private final DBMS dbms;
    private final IDocument html;
    private final IDocument pdf;

    public Helper(DBMS dbms){
        this.dbms = dbms;
        this.html = DocumentFactory.get().getHTML();
        this.pdf = DocumentFactory.get().getPDF();
    }

    @Override
    public void dropDB() {
        dbms.getEntityMap().clear();
    }

    @Override
    public void generatePDF(String location) {
        pdf.generate(dbms, location);
    }

    @Override
    public void generateHTML(String location) {
        html.generate(dbms, location);
    }

    @Override
    public void create(Entity obj) {
        dbms.create(obj);
    }

    @Override
    public Entity get(int id) {
        return dbms.get(id);
    }

    @Override
    public void update(Entity obj) {
        dbms.update(obj);
    }

    @Override
    public void delete(int id) {
        dbms.delete(id);
    }
}
