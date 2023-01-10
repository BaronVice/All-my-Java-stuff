package CollectionsStudy.SetExamples;

import java.util.*;

/** equals() и hashCode() нужны вместе для сравнения наиболее быстрым образом.
 * Используя только equals() было бы слишком долго проходить по всем полям.
 * В то время как используя хеширование мы сравниваем лишь хеши.
 * Но hashCode() не всегда работает правильно, для этого ему в поддержку нужен equals
 * -
 * Хеширование - преобразование данных в битовую строку фиксированной длины
 * */

public class HashCodeAndEquals {
    public static void main(String[] args) {

        String word = "aboba";
        System.out.println(word.hashCode());

        Map<Person, Integer> marks = new HashMap<>();

        marks.put(new Person(15, "Mark"), 4);
        marks.put(new Person(15, "Mark"), 5);

        System.out.println(marks);
    }
}

record Person(int age, String name){

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
