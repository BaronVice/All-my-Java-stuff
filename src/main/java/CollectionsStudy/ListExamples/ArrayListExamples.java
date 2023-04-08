package CollectionsStudy.ListExamples;


import java.util.ArrayList;
import java.util.List;

/** ArrayList - класс, реализующий динамический массив.
 * Добавляет сколько угодно данных, пока не закончится память на компьютере. */

public class ArrayListExamples {
    public static void main(String[] args) {
        arrayListFunctional();
    }

    public static void arrayListActions() {

        ArrayList<Integer> firstList = new ArrayList<>();

        for (int i = 0; i < 30; i++)
            firstList.add(i);

        System.out.printf("Second list: %s\n", firstList);

        // Можно получать элементы через get
        System.out.printf("Fifth element: %d\n", firstList.get(5));

        // Можно получить размер
        System.out.printf("Size of list: %d\n", firstList.size());

        // Удалить по индексу/объекту (не эффективен из-за внутреннего массива)
        firstList.remove(5);
    }

    public static void arrayListFunctional(){
        // Лучше ссылать реализацию на интерфейс (здесь ArrayList на List)
        // Это полезно при переводе из одного типа списка в другой, например из ArrayList в LinkedList
        List<Integer> arrayList = new ArrayList<>();

        // Можно в конструкторе задать размерность
        List<Integer> firstList = new ArrayList<>(30);
        firstList.add(3);
        // Или задать другую коллекцию из Collection
        List<Integer> secondList = new ArrayList<>(firstList);
        System.out.println(secondList);
    }
}

