package CollectionsStudy.ListExamples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** Для add в конец и get элементов лучше пользоваться ArrayList
 * Для добавления в середину/начало и удаления лучше использовать LinkedList */

public class LinkedListExamples {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < 30; i++)
            list.add(i);

        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(0));
    }

    public static void linkedListActions(){
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        timeMeasure(linkedList);
        timeMeasure(arrayList);
    }

    private static void timeMeasure(List<Integer> list){

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1e5; i++)
            list.add(0, i);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public static void linkedListFunctional(){

    }
}
