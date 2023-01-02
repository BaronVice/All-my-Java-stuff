package CollectionsStudy.MapExamples;

import java.util.HashMap;
import java.util.Map;

public class HashMapExamples {
    public static void main(String[] args) {
        // В HashMap элементы не упорядочены -> не подходят для сортировки элементов
        Map<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);

        // Ключи перезаписываются

        System.out.println(map);
        // null если ключ не существует
        System.out.println(map.get("X"));

        // Entry - пара
        for (Map.Entry<String, Integer> pair : map.entrySet())
            System.out.printf("%s: %d\n", pair.getKey(), pair.getValue());
    }
}
