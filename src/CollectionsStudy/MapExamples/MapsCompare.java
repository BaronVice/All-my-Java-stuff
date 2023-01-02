package CollectionsStudy.MapExamples;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsCompare {
    public static void main(String[] args) {
        // Порядок не гарантируется
        Map<String, String> hashMap = new HashMap<>();
        // Порядок сохраняется
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        // Автоматическая сортировка по ключу (можно задать критерий сортировки)
        Map<String, String> treeMap = new TreeMap<>();

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map<String, String> map){
        map.put("Somebody", "Кто-то");
        map.put("Once", "Однажды");
        map.put("Told", "Сказал");
        map.put("Me", "Мне");

        for (Map.Entry<String, String> pair : map.entrySet())
            System.out.printf("%s: %s\n", pair.getKey(), pair.getValue());

        System.out.println();
    }
}
