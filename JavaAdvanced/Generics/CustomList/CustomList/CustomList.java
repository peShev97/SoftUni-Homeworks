package Generics.CustomList;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public int size() {
        return this.data.size();
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.data, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        int count = 0;

        for (T e : this.data) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T getMax() {
        return Collections.max(this.data);
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
