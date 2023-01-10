package CollectionsStudy.QueueExamples;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {
    public static void main(String[] args) {

        // ArrayBlockingQueue - полезен при многозадачности для ограничения доступа к ресурсу
        Queue<Person> people = new ArrayBlockingQueue<>(10);

        for (int i = 0; i < 5; i++)
            people.offer(new Person());

        Person person = people.poll();
        people.offer(person);
        person = people.poll();
        people.offer(person);

        for (Person p : people)
            System.out.println(p);

    }
}

class Person {
    private static int ID;
    private final int id;

    public Person(){
        this.id = ++ID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}