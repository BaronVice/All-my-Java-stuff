import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<>(
                Map.of("Sas", 1, "Bob", 2, "Ken", 4)
        );

        m.values().remove(2);
        System.out.println(m);
    }
}


