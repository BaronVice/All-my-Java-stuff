package SingleClasses;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Starting_value");
        sb.append(" and_this_is_new").append(" with_chaining");
        System.out.println(sb.toString());

        System.out.printf("More than 10 symbols: %10d\n", 1234567);
        System.out.printf("More than 10 symbols: %10d\n", 12345);
        System.out.printf("More than 10 symbols: %10d\n", 123);

        System.out.printf("Only to symbols after point: %.2f\n", 1337.1337); // Ceil as well

    }
}
