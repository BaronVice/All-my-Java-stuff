package CollectionsStudy.SetExamples;

import java.util.*;
import java.util.stream.Collectors;

/** HashSet быстрее остальных Set
 * HashSet определяет наличие предмаета за O(1) */
public class SetCompare {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

//        fillStringSet(hashSet);
//        System.out.println(hashSet);
//        fillStringSet(linkedHashSet);
//        System.out.println(linkedHashSet);
//        fillStringSet(treeSet);
//        System.out.println(treeSet);

//        System.out.println(hashSet.contains("body"));


        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        for (int i = 1; i < 20; i++){
            if (i % 2 == 0)
                hashSet1.add(i);
            if (i % 3 == 0)
                hashSet2.add(i);
        }

        System.out.printf("First: %s\n", hashSet1);
        System.out.printf("Second: %s\n", hashSet2);

        // union
        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);
        System.out.println(union);

        // intersection
        // HashSet<Integer> intersection = hashSet1.stream().filter(hashSet2::contains).collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> intersection = new HashSet<>(hashSet1);
        intersection.retainAll(hashSet2);
        System.out.println(intersection);

        // subtract
        HashSet<Integer> subtraction1 = new HashSet<>(hashSet1);
        subtraction1.removeAll(hashSet2);
        HashSet<Integer> subtraction2 = new HashSet<>(hashSet2);
        subtraction2.removeAll(hashSet1);

        System.out.println(subtraction1);
        System.out.println(subtraction2);

        // exclusiveOr
        HashSet<Integer> exclusiveOr = new HashSet<>(subtraction1);
        exclusiveOr.addAll(subtraction2);
        System.out.println(exclusiveOr);
    }

    public static void fillStringSet(Set<String> set){
        String s = "Some body once told me the world is gonna roll   me.";
        set.addAll(Arrays.asList(s.split("[ .,]+")));
    }
}

