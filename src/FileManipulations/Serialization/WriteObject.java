package FileManipulations.Serialization;

import java.io.*;
import java.util.ArrayList;

public class WriteObject {
    public static void main(String[] args) {
        Person person1 = new Person(12, "Bob");
        Person person2 = new Person(17, "Kyle");

        ArrayList<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/FileManipulations/Serialization/Files/people"))){

            oos.writeObject(person1);

            oos.flush();
        }
        catch (IOException e){
            System.out.println("File not found");
        }

    }
}
