package CollectionsStudy.QueueExamples;

import java.util.*;

/** Iterable дает понять, что объект - коллекция, по которой можно проходить */
public class IterableAndIterators {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < 20; i++)
            list.add(i);

        // Before Java 5
        // Однако с итератором можно удалять/добавлять элементы
        ListIterator<Integer> iterator = list.listIterator();

        int id = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            if (id % 2 == 0)
                iterator.remove();
            if (id % 5 == 0)
                iterator.add(228);

            id++;
        }

        System.out.println(list);

//        // Java 5 and above
//        for (int num : list)
//            System.out.println(num);


    }
}
