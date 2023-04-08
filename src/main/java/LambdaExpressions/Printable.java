package LambdaExpressions;

/** When interface has only one abstract method, then it is called functional interface */
@FunctionalInterface
public interface Printable {
    String print(String prefix, String suffix);
}
