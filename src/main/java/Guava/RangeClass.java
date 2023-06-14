package Guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/** Kinda python slices, but this is another level - a whole class with its own methods (whatever you need for slices) */
public class RangeClass {
    public static void main(String[] args) {
        List<Range<Integer>> ranges = new ArrayList<>(
                List.of(Range.greaterThan(30),
                        Range.openClosed(-10, 0),
                        Range.closedOpen(0, 10),
                        Range.open(-15, -8)
                )
        );

        ranges.forEach(System.out::println);

        System.out.println(ranges.get(0).span(ranges.get(1)));

        for (Range<Integer> range : ranges) {
            try {
                Pair<Integer, Integer> bounds = getRangeEndpoints(range);
                System.out.printf(
                        "Lower endpoint | Upper endpoint: %d | %d%n",
                        bounds.first,
                        bounds.second
                );
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Pair<Integer, Integer> getRangeEndpoints(Range<Integer> range){
        Preconditions.checkState(range.hasLowerBound(), "Range is unbounded on lower side");
        Preconditions.checkState(range.hasUpperBound(), "Range is unbounded on upper side");

        return new Pair<>(range.lowerEndpoint(), range.upperEndpoint());
    }

}

@AllArgsConstructor
@Data
class Pair<T, U> {
    public final T first;
    public final U second;
}