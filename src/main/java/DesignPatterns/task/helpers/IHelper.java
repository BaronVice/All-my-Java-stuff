package DesignPatterns.task.helpers;

import DesignPatterns.task.dbms.CRUD;

public interface IHelper extends CRUD {
    void dropDB();
    void generatePDF(String location);
    void generateHTML(String location);
}
