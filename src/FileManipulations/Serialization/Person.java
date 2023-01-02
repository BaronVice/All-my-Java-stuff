package FileManipulations.Serialization;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {
    @Serial
    // При изменении класса меняем UID
    private static final long serialVersionUID = -5462303583760276173L; // Другие значения при изменении класса
    private int id;
    private transient String name;  // Это поле не сериализуется (по умолчанию будет даваться null)

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return String.format("%d : %s", id, name);
    }

}
