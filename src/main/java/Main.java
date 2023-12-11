import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.Scanner;

public class Main{

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var a = new Some(Instant.now());
        for (int i = 0; i < 100000000; i++) {
            int b = i * i * i;
        }
        var b = new Some(Instant.now());

        System.out.println(a.instant);
    }

}

@AllArgsConstructor
@NoArgsConstructor
@ToString
class Some implements Comparable<Some>{
    public Instant instant;


    @Override
    public int compareTo(Some o) {
        if (instant.equals(o.instant)){
            return 1;
        }
        return this.instant.compareTo(o.instant);
    }
}