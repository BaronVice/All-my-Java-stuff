package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** With these classes we can extend regexp functional/
 * Pattern - is a class to store regexp
 * Matcher - using pattern to do something with given text */
public class PatternAndMatcher {
    public static void main(String[] args) {
        String text = """
                Some body once told me the world is gonna roll me,
                I ain't the toni.sas.228@mail.ru in a shed.
                She was looking kinda big.bobba.1337@mail.ru
                In the shape of an "L" on her b.vice@gmail.com
                """;

        // Factory class - can't really create its objects, since no constructor in here.
        // Instead, we have here a static method which will return a class object
        Pattern email = Pattern.compile("[a-z\\d]+(\\.[a-z\\d]+)*@(mail|yandex|gmail)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find())
            // group due to args. We can get full hit or only specific part (like here)
            System.out.println(matcher.group());
    }
}
