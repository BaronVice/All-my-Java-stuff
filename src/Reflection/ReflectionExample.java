package Reflection;

import AnnotationsStuff.ClassInfo;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionExample {
    @SneakyThrows
    public static void main(String[] args) {
        Class someClass = Class.forName("InheritExample.Animal");

        // How to get all class methods:
        for (Method method : someClass.getDeclaredMethods()) {
            System.out.println("Name: " + method.getName());
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Parameters: " + (method.getParameters().length != 0 ?
                    Arrays.toString(method.getParameters()) : "None"));
        }

        // How to get all class fields:
        for (Field field : someClass.getDeclaredFields()){
            System.out.println("Name: " + field.getName());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("Type: " + field.getType());
        }

        // How to check class annotation:
        System.out.println("ClassInfo annotation " + (
                Arrays.stream(someClass.getAnnotations()).anyMatch(annotation -> annotation instanceof ClassInfo) ?
                "is applied" : "is not applied"));
    }
}
