package DesignPatterns.task.documenttools;

import DesignPatterns.task.dbms.DBMS;

public interface IDocument {
    void generate(DBMS dbms, String location);
}
