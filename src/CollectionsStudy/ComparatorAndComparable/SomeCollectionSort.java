package CollectionsStudy.ComparatorAndComparable;

import java.util.*;

public class SomeCollectionSort {
    public static void main(String[] args) {
        String s = "somebody once told me, the world is gonna roll me.";
        List<String> words = new ArrayList<>(List.of(s.split("[ ,.]+")));

        System.out.println(words);

//        words.sort(Comparator.comparingInt(String::length));
//        Collections.reverse(words);

        words.sort(new lastLetterCompare());
        System.out.println(words);
    }
}

class lastLetterCompare implements Comparator<String>{

    private static char getLastCharacter(String s){
        return s.toCharArray()[s.length() - 1];
    }

    @Override
    public int compare(String o1, String o2) {
        return getLastCharacter(o1) - getLastCharacter(o2);
    }
}

