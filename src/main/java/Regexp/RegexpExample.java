package Regexp;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class RegexpExample {
    public static void main(String[] args) {
        /*
        \\d - one digit
        \\w - one letter
        \\w equals [a-zA-z]
        \\s - white-space

        + - 1 or more
        * - 0 or more
        ? - 0 or 1

        (+|-) - contains + or -
        [a-zA-Z] - set of all English alphabet
        [0-9] - \\d
        [^] - ^ is for not (every symbol after it should not be included into set)
        [^a-z] - all stuff, except lowercase a-z

        . - any symbol
        \\d{2} - exactly 2 digits
        [a-zA-z]{2,} - 2 or more eng letters
        [^a-zA-z]{2, 6} - from 2 to 6 symbols, which not include eng letters
         */

        List<String> toCheck = new ArrayList<>(asList("-1234", "321", "+890", "213.456", "212.",
                                                      ".123", "0.0", "32..12", "1234.,32", "1,,5", "4,.1"));
        toCheck.forEach(RegexpExample::checkIfNumber);

        String d = "ABOBA1337";
        System.out.println(d.matches("[a-zA-z731]+"));

        String e = "abOba12E";
        // First part: length 0 or more and without digits
        // Second part: length 1 or more and without lowercase a-z
        System.out.println(e.matches("\\D*[^a-z]+"));

        String url = "http://www.google.com";
        boolean isValid = url.matches("http://www\\..+\\.(com|ru)");
        System.out.println(isValid);

        List<String> song = new ArrayList<>(List.of("Some body once told me, the world is gonna roll me".split("[ ,]+")));
        song.removeIf(word -> (word.matches("[a-z]{3,4}")));
        song.forEach(System.out::println);

        String line = "W1h2o m3e4s5s6e7d8 9w0i2th3 m1y32 1l3i4n5e6?";
        line = line.replaceAll("\\d+", "");
        System.out.println(line);
    }
    public static void checkIfNumber(String s){
        System.out.printf("%s is %sa number\n", s, isNumber(s) ? "" : "not ");
    }

    public static boolean isNumber(String s){
        return s.matches("[-+]?\\d+(([.,])\\d+)?");
    }
}
