package Reflection;

import AnnotationsStuff.MailValidator;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Scanner;

/** Magic time: reading class names from console and then with reflection we'll create their objects
 * So, it's kinda delegates, but more extended */
public class MoreStuffWithReflection {
    // Yeah, better check before manipulate, but I know what will be putted here (so it's fine)
    @SneakyThrows
    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public static void main(String[] args) {
        // To get method by signature we need to give method name and parameter types
        Scanner scanner = new Scanner(System.in);
        // Gets class name and creates its object of Class
        // AnnotationsStuff.MailValidator java.lang.String isMailCorrect
        Class firstObj = Class.forName(scanner.next());
        Class secondObj = Class.forName(scanner.next());
        String methodName = scanner.next();
        // There are three getMethods:
        // 1) Get method considering scope - getMethod()
        // 2) Get any method even if its private - getDeclaredMethod()
        // 3) Get method from local or anonymous class - getEnclosingMethod()
        Method method = firstObj.getMethod(methodName, secondObj);
        String a = "1";
        // Now this will happen:
        Object obj1 = firstObj.getConstructor().newInstance();
        Object obj2 = secondObj.getConstructor(String.class).newInstance("random.mail.123@gmail.com");

        // On what object do I call it, then write args
        System.out.println(method.invoke(obj1, obj2));
        System.out.println(obj1);
        System.out.println(obj2);

        MailValidator mailValidator = new MailValidator();
        System.out.println(mailValidator.isMailCorrect("random.mail.123@gmail.com"));
    }
}
