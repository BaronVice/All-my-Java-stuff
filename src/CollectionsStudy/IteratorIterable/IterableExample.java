package CollectionsStudy.IteratorIterable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class IterableExample {
    public static void main(String[] args) {

    }
}

class SafeList<T> implements Iterable<T>{
    private T[] elements;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}