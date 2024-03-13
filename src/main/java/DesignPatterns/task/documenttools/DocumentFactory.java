package DesignPatterns.task.documenttools;

public class DocumentFactory {
    private static DocumentFactory factory;

    public static DocumentFactory get(){
        if (factory == null){
            factory = new DocumentFactory();
        }

        return factory;
    }

    public IDocument getPDF(){
        return (dbms, location) -> System.out.println("Generated .pdf doc in " + location);
    }

    public IDocument getHTML(){
        return (dbms, location) -> System.out.println("Generated .html doc in " + location);
    }
}
