package CollectionsStudy.ComparatorAndComparable;

import lombok.Data;

import java.util.*;

/** Чтобы объекты класса можно было сравнивать/сортировать, они должны реализовывать интерфейс Comparable */
public class MyClassSort {
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();
        addPersonal(peopleList);
        Set<Person> peopleSet = new TreeSet<>(peopleList);
        System.out.println(peopleSet);


//        System.out.println(peopleList);
//        // Sort by id
//        peopleList.sort(Comparator.comparing(Person::getId));
//        System.out.println(peopleList);
//        // Sort by name
//        peopleList.sort(Comparator.comparing(Person::getName));
//        System.out.println(peopleList);
    }

    public static void addPersonal(Collection<Person> collection){
        collection.add(new Person(213, "Mike"));
        collection.add(new Person(245, "Kate"));
        collection.add(new Person(123, "Bob"));
    }
}

// record - data carrier class, i.e. contain data and carry it between modules
record Person(int id, String name) implements Comparable<Person> {

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int compareTo(Person o) {
        if (this.id == o.id())
            return 0;

        return this.id > o.id() ? 1 : -1;
    }
}
