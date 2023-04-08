package LambdaExpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaComparator {
    public static void main(String[] args) {
        List<String> famousLastWords = new ArrayList<>(
                List.of("Some body once told me, the world is gonna roll me".split("[\\s,.]+")));
        Comparator<String> lastCharComparator = (Comparator.comparingInt(obj -> getLastCharacter(obj)));

        famousLastWords.sort(lastCharComparator);
        System.out.println(famousLastWords);
    }

    public static char getLastCharacter(String s){
        return s.toCharArray()[s.length() - 1];
    }
}
