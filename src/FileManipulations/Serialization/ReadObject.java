package FileManipulations.Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadObject {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/FileManipulations/Serialization/Files/people"))){
//            FileInputStream fis = new FileInputStream("src/FileManipulations/Serialization/people.bin");
//            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true){
                Person person = (Person)ois.readObject();
                if(person != null){
                    people.add(person);
                }
                else{
                    break;
                }
            }

//            ois.close();
        }
        catch (IOException e){
        }
        catch (ClassNotFoundException e){
            System.out.println("Wrong class");
        }

        for(Person person : people){
            System.out.println(person);
        }
    }
}
